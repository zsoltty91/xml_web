/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LessonDAO;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ora")
public class Lesson implements XmlID {

    @XmlAttribute
    private String id;

    @XmlElement(name = "nap")
    @XmlJavaTypeAdapter(DayAdapter.class)
    private Days day;

    @XmlElement(name = "idopont")
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime time;

    @XmlElement(name = "tantargy")
    @XmlJavaTypeAdapter(SubjectAdapter.class)
    private Subject subject;

    @XmlElement(name = "tanar")
    @XmlJavaTypeAdapter(TeacherAdapter.class)
    private Teacher teacher;

    @XmlElement(name = "terem")
    @XmlJavaTypeAdapter(RoomAdapter.class)
    private Room room;

    public Lesson() {
    }

    public Lesson(String id, LocalTime time, Subject subject, Teacher teacher, Room room) {
        this.id = id;
        this.time = time;
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public static Lesson find(String id) throws JAXBException, IOException {
        return new LessonDAO().find(id);
    }

    public static ArrayList<Lesson> findAll() throws JAXBException, IOException {
        return new LessonDAO().findAll();
    }

    public void add(String classId) throws JAXBException, IOException {
        new LessonDAO(this).add(classId);
    }

    public void remove() throws IOException {
        new LessonDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
