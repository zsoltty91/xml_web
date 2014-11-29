/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Holiday;

/**
 *
 * @author zsolti
 */
public class HolidayDAO extends DefaultDAO<Holiday> {

    public HolidayDAO() {
        super(Holiday.class);
    }

    public HolidayDAO(Holiday holiday) {
        super(Holiday.class, holiday);
    }

    public Holiday find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')//szunet[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Holiday> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')//szunet");
        } finally {
            closeConnection();
        }
    }

    public void add(String schoolYearId) throws JAXBException, IOException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/tanevek/tanev[@id='" + schoolYearId + "']/szunetek");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer//szunet[@id='" + object.getId() + "']");
        } finally {
            closeConnection();
        }
    }
}
