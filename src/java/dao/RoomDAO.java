/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Room;

/**
 *
 * @author zsolti
 */
public class RoomDAO extends DefaultDAO<Room> {

    public RoomDAO() {
        super(Room.class);
    }

    public RoomDAO(Room room) {
        super(Room.class, room);
    }

    public Room find(int id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer/termek/terem[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Room> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer/termek/terem");
        } finally {
            closeConnection();
        }
    }

    public void add() throws JAXBException, IOException {
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/termek");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer/termek/terem[@id='" + object.getId() + "']");
        } finally {
            closeConnection();
        }
    }
}
