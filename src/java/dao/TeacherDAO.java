/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Teacher;

/**
 *
 * @author zsolti
 */
public class TeacherDAO extends DefaultDAO<Teacher> {

    public TeacherDAO() {
        super(Teacher.class);
    }

    public TeacherDAO(Teacher teacher) {
        super(Teacher.class, teacher);
    }

    public Teacher find(String id) throws JAXBException, IOException, SchemaException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/tanarok/tanar[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Teacher> findAll() throws JAXBException, IOException, SchemaException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/tanarok/tanar");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Teacher> findOsztalyfonokok(String tanev) throws IOException, JAXBException, SchemaException {
        try {
            this.queryResult = getResultByQuery("inf:osztalyfonokok(" + tanev + ")");
            return getObjects(this.queryResult);
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Teacher> findNemOsztalyfonokok() throws IOException, JAXBException, SchemaException {
        try {
            this.queryResult = getResultByQuery("inf:nem-osztalyfonokok()");
            return getObjects(this.queryResult);
        } finally {
            closeConnection();
        }
    }

    public void generateId() throws IOException, SchemaException {
        String query = query("inf:max-id-tanar()").get(0);
        logger.info("Max id:" + query);
        object.setId(Integer.toString(Integer.parseInt(query) + 1));
    }

    public void add() throws IOException, JAXBException, SchemaException {
        generateId();
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/tanarok");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException, SchemaException {
        try {
            executeQuery("delete node doc('rendszer')//tanar[.='" + object.getId() + "']");
            executeQuery("delete node doc('rendszer')//ora/tanar[.='" + object.getId() + "']");
            executeQuery("delete node doc('rendszer')/rendszer/tanarok/tanar[@id='" + object.getId() + "']/osztaly");            
            executeQuery("delete node doc('rendszer')//osztaly/osztalyfonok[.='" + object.getId() + "']");
            executeQuery("delete node doc('rendszer')/rendszer/tanarok/tanar[@id='" + object.getId() + "']");            
        } finally {
            closeConnection();
        }
    }
}
