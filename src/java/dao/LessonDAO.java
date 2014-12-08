/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import model.Lesson;

/**
 *
 * @author zsolti
 */
public class LessonDAO extends DefaultDAO<Lesson> {

    public LessonDAO() {
        super(Lesson.class);
    }

    public LessonDAO(Lesson lesson) {
        super(Lesson.class, lesson);
    }

    public Lesson find(String id) throws JAXBException, IOException {
        try {
            return getObjectByQuery("doc('rendszer')/rendszer//ora[@id='" + id + "']");
        } finally {
            closeConnection();
        }
    }

    public ArrayList<Lesson> findAll() throws JAXBException, IOException {
        try {
            return getObjectsByQuery("doc('rendszer')/rendszer//ora");
        } finally {
            closeConnection();
        }
    }

    public void generateId() throws IOException {
        String query = query("inf:max-id-ora()").get(0);
        logger.info("Max id:"+query);
        object.setId(Integer.toString(Integer.parseInt(query)+1));
    }
    
    public void add(String classId) throws JAXBException, IOException {
        generateId();
        try {
            executeQuery("insert node " + getXml(object) + " into doc('rendszer')/rendszer/osztalyok/osztaly[@id='" + classId + "']/orarend");
        } finally {
            closeConnection();
        }
    }

    public void remove() throws IOException {
        try {
            executeQuery("delete node doc('rendszer')/rendszer//ora[@id='" + object.getId() + "']");
        } finally {
            closeConnection();
        }
    }
}
