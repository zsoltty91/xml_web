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
    
    public void generateId() throws IOException {
        String query = query("inf:max-id-diak()").get(0);
        logger.info("Max id:"+query);
        object.setId(Integer.toString(Integer.parseInt(query)+1));
    }
    
    public void add() throws IOException, JAXBException {
        generateId();
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/diakok");
        } finally {
            closeConnection();
        }
    }
    
    public void remove() throws IOException {
         try {
            executeQuery("delete node doc('rendszer')/rendszer/diakok/diak[@id='"+object.getId()+"']");
           executeQuery("delete node doc('rendszer')//diak[.='"+object.getId()+"']");
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Student> findWithoutClass(String tanev) throws IOException, JAXBException {
        try {
            return getObjectsByQuery("inf:osztalyhoz-nem-rendelt-diakok('"+tanev+"')");            
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Student> findActive(String tanev) throws IOException, JAXBException {
        try {
            this.queryResult = getResultByQuery("inf:diakok("+tanev+")");   
            return getObjects(this.queryResult);                   
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Student> findInactive() throws IOException, JAXBException {
        try {
            this.queryResult = getResultByQuery("inf:inaktivDiakok()");   
            return getObjects(this.queryResult);                   
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Student> findTop(int mennyi) throws IOException, JAXBException {
        try {
            this.queryResult = getResultByQuery("inf:top-diak("+mennyi+")");
            return getObjects(this.queryResult);            
        } finally {
            closeConnection();
        }
    }
    
    public ArrayList<Student> findTop(String tanev, int mennyi) throws IOException, JAXBException {
        try {
            this.queryResult = getResultByQuery("inf:top-diak('"+tanev+"',"+mennyi+")");
            return getObjects(this.queryResult);                     
        } finally {
            closeConnection();
        }
    }
}
