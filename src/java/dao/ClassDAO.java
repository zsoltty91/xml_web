/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    public model.Class find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/osztalyok/osztaly[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<model.Class> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/osztalyok/osztaly");
        } finally {
            closeConnection();
        }
    }

    public void add() throws JAXBException, IOException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/osztalyok");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer/osztalyok/osztaly[@id='" + object.getId() + "']");
        } finally {
            closeConnection();
        }
    }
}
