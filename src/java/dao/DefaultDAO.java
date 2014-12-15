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
import org.apache.log4j.Logger;
import util.Connection;
import util.Database;
import util.JAXBUtil;

/**
 * @author zsolti
 * @param <T>
 */
public class DefaultDAO<T extends Object> {

    private static final String XQUERY_PATH = "'D:\\Dokumentumok\\Projektek\\Netbeans\\Java\\xml_web\\src\\java\\main\\resources\\xquery.xq'";
    
    protected T object;
    private Database db;
    private Connection conn;
    private final Class<T> objectClass;
    public ArrayList<String> queryResult;
    protected ArrayList<String> errorMessages;

    protected static Logger logger = Logger.getLogger(DefaultDAO.class);

    public DefaultDAO(Class<T> objectClass) {
        this.objectClass = objectClass;
        db = Database.getInstance();
        conn = db.getConnection();
    }

    public DefaultDAO(Class<T> objectClass, T object) {
        this.objectClass = objectClass;
        db = Database.getInstance();
        conn = db.getConnection();
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public ArrayList<String> getErrorMessages() {
        return errorMessages;
    }
    
    public void setObject(T object) {
        this.object = object;
    }
    
    protected void closeConnection() {
        db.freeConnection(conn);
    }

    /*
     @return <code>null</code> if object not found
     */
    protected T getObjectByQuery(String query) throws JAXBException, IOException, SchemaException {
        ArrayList<String> res = query(query);
         return res.isEmpty() ? null : getObject(res.get(0));
    }

    /*
     @return <code>null</code> if object not found
     */
    protected ArrayList<T> getObjectsByQuery(String query) throws IOException, JAXBException, SchemaException {
        return getObjects(query(query));
    }   
    
    protected ArrayList<T> getObjectsBy(ArrayList<String> query) throws IOException, JAXBException {
        return getObjects(query);
    }   
    
    protected ArrayList<String> getResultByQuery(String query) throws IOException, JAXBException, SchemaException {
        return query(query);
    } 

    /*
     @return empty <code>ArrayList<String></code> if there is no result.
     */
    protected ArrayList<String> query(String query) throws IOException, SchemaException {
        logger.debug("Query: " + query);
        query = "import module namespace inf = 'http://inf.unideb.hu/xml' at "+XQUERY_PATH+";\n"+query;        
        ArrayList<String> result = conn.query(query);        
        validate();
        return result;
    }
    
    public void validate() throws IOException, SchemaException {
        String module = "import module namespace inf = 'http://inf.unideb.hu/xml' at "+XQUERY_PATH+";\n";                
        errorMessages = conn.query(module + "inf:validate()"); 
        logger.debug("MÉRET ELTN: " +errorMessages.size());
        if (!errorMessages.isEmpty()) {
            throw new SchemaException(errorMessages);
        }
    }

    protected void executeQuery(String query) throws IOException, SchemaException {
        logger.debug("Query: " + query);
        query = "import module namespace inf = 'http://inf.unideb.hu/xml' at "+XQUERY_PATH+";\n"+query;
        conn.executeQuery(query);
        validate();
    }

    protected T getObject(String xml) throws JAXBException {
        return JAXBUtil.fromXMLElement(objectClass, xml);
    }

    protected ArrayList<T> getObjects(ArrayList<String> xml) throws JAXBException {
        return JAXBUtil.fromXMLElement(objectClass, xml);
    }

    protected String getXml(T object) throws JAXBException {
        return JAXBUtil.toXML(object);
    }        
}