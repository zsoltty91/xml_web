/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.ConsultingHour;

/**
 *
 * @author zsolti
 */
public class ConsultingHourDAO extends DefaultDAO<ConsultingHour> {

    public ConsultingHourDAO() {
        super(ConsultingHour.class);
    }

    public ConsultingHourDAO(ConsultingHour consultingHour) {
        super(ConsultingHour.class, consultingHour);
    }

    public ConsultingHour find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')//fogadoora[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<ConsultingHour> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')//fogadoora");
        } finally {
            closeConnection();
        }
    }

    public void add(String teacherId) throws JAXBException, IOException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/tanarok/tanar[@id='" + teacherId + "']/fogadoorak");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer//fogadoora[@id='" + object.getId() + "']");
        } finally {
            closeConnection();
        }
    }
}
