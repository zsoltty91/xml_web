/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.SchoolYear;

/**
 *
 * @author zsolti
 */
public class SchoolYearDAO extends DefaultDAO<SchoolYear> {

    public SchoolYearDAO() {
        super(SchoolYear.class);
    }

    public SchoolYearDAO(SchoolYear schoolYear) {
        super(SchoolYear.class, schoolYear);
    }

    public SchoolYear find(String id) throws JAXBException, IOException, SchemaException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/tanevek/tanev[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<SchoolYear> findAll() throws JAXBException, IOException, SchemaException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/tanevek/tanev");
        } finally {
            closeConnection();
        }
    }
        
    public void generateId() {
        int from = this.object.getFrom().getYear();
        int to = this.object.getTo().getYear();        
        StringBuffer sb = new StringBuffer();
        sb.append(from).append("/").append(to);
        this.object.setId(sb.toString());
    }

    public void add() throws JAXBException, IOException, SchemaException {
        generateId();        
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/tanevek");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException, SchemaException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer/tanevek/tanev[@id='"+object.getId()+"']");
        } finally {
            closeConnection();
        }
    }
}
