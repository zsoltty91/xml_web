/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Student;

/**
 *
 * @author zsolti
 */
public class StudentDAO extends DefaultDAO<Student>{
   
    public StudentDAO() {
        super(Student.class);
    }
    
    public StudentDAO(Student student) {
        super(Student.class,student);
    }
    
    public Student find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/diakok/diak[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Student> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/diakok/diak");
        } finally {
            closeConnection();
        }
    }
    
    public void add() throws IOException, JAXBException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/diakok");
        } finally {
            closeConnection();
        }
    }
    
    public void remove() throws IOException {
         try {
            executeQuery("delete node doc('rendszer')/rendszer/diakok/diak[@id='"+object.getId()+"']");
        } finally {
            closeConnection();
        }
    }
}
