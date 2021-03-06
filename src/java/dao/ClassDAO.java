/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.SchemaException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author zsolti
 */
public class ClassDAO extends DefaultDAO<model.Class> {

    public ClassDAO() {
        super(model.Class.class);
    }

    public ClassDAO(model.Class clazz) {        
        super(model.Class.class, clazz);        
    }

    public model.Class find(String id) throws JAXBException, IOException, SchemaException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/osztalyok/osztaly[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<model.Class> findAll() throws JAXBException, IOException, SchemaException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/osztalyok/osztaly");
        } finally {
            closeConnection();
        }
    }

    public void generateId() {
        StringBuilder sb = new StringBuilder();        
        sb.append(this.object.getName()).append("-").append(this.object.getSchoolYear().getFrom().getYear()).append("/").append(this.object.getSchoolYear().getTo().getYear());
        logger.info(sb);
        object.setId(sb.toString());
    }
    
    public void updateTeacher() throws JAXBException, IOException, SchemaException {
        try {            
            //executeQuery("replace value of node doc('rendszer')/rendszer/osztalyok/osztaly[@id='"+object.getId()+"']/osztalyfonok with '" + object.getTeacher().getId()+"'");
            executeQuery("inf:update-tanar-into-osztaly('"+ object.getId() +"', " + Integer.parseInt(object.getTeacher().getId())+")");
        } finally {
            closeConnection();
        }
    }
    
    public void add() throws JAXBException, IOException, SchemaException {
        generateId();
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/osztalyok");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException, SchemaException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer/osztalyok/osztaly[@id='" + object.getId() + "']");
        } finally {
            closeConnection();
        }
    }
    
    public void removeStudent(String id) throws IOException, SchemaException {        
        try {            
            query("inf:delete-diak-from-osztaly('" + object.getId() + "', '" + id + "')");            
        } finally {
            closeConnection();
        }
    }
}