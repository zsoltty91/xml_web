/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Subject;

/**
 *
 * @author zsolti
 */
public class SubjectDAO extends DefaultDAO<Subject> {

    public SubjectDAO() {
        super(Subject.class);
    }

    public SubjectDAO(Subject subject) {
        super(Subject.class,subject);
    }

    public Subject find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/tantargyak/tantargy[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Subject> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/tantargyak/tantargy");
        } finally {
            closeConnection();
        }
    }

    public void add() throws IOException, JAXBException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/tantargyak");
        } finally {
            closeConnection();
        }
    }
    
    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer/tantargyak/tantargy[@id='"+object.getId()+"']");
        } finally {
            closeConnection();
        }
    }
    
}
