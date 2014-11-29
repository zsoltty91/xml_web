/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    protected T object;
    private Database db;
    private Connection conn;
    private final Class<T> objectClass;

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

    public void setObject(T object) {
        this.object = object;
    }
    
    protected void closeConnection() {
        db.freeConnection(conn);
    }

    /*
     @return <code>null</code> if object not found
     */
    protected T getObjectByQuery(String query) throws JAXBException, IOException {
        ArrayList<String> res = query(query);
        return res.isEmpty() ? null : getObject(res.get(0));
    }

    /*
     @return <code>null</code> if object not found
     */
    protected ArrayList<T> getObjectsByQuery(String query) throws IOException, JAXBException {
        return getObjects(query(query));
    }

    /*
     @return empty <code>ArrayList<String></code> if there is no result.
     */
    protected ArrayList<String> query(String query) throws IOException {
        logger.debug("Query: " + query);
        return conn.query(query);
    }

    protected void executeQuery(String query) throws IOException {
        logger.debug("Query: " + query);
        conn.executeQuery(query);
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
