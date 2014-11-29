/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Mark;

/**
 *
 * @author zsolti
 */
public class MarkDAO extends DefaultDAO<Mark> {

    public MarkDAO() {
        super(Mark.class);
    }

    public MarkDAO(Mark mark) {
        super(Mark.class,mark);
    }

    public Mark find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer//jegy[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Mark> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer//jegy");
        } finally {
            closeConnection();
        }
    }

    public void add(String studentId) throws IOException, JAXBException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/diakok/diak[@id='"+studentId+"']/jegyei");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')//jegy[@id='"+object.getId()+"']");
        } finally {
            closeConnection();
        }
    }
}
