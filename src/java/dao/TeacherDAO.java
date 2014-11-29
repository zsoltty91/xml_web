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
        super(Teacher.class,teacher);
    }

    public Teacher find(int id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/tanarok/tanar[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Teacher> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/tanarok/tanar");
        } finally {
            closeConnection();
        }
    }
    
    public void add() throws IOException, JAXBException {
       try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/tanarok");
        } finally {
            closeConnection();
        }
    }
    
    public void remove() throws IOException {
       try {
            executeQuery("delete node doc('rendszer')/rendszer/tanarok/tanar[@id='"+object.getId()+"']");
        } finally {
            closeConnection();
        }
    }
}
