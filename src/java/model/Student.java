/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "diak")
public class Student extends Person {

    @XmlElementWrapper(name = "jegyei")
    @XmlElement(name = "jegy")
    private ArrayList<Mark> marks;

    public Student() {
        marks = new ArrayList<>();
    }

    public Student(ArrayList<Mark> marks, String id, String name, String email) {
        super(id, name, email);
        this.marks = marks;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public static Student find(String id) throws JAXBException, IOException {
        return new StudentDAO().find(id);
    }

    public static ArrayList<Student> findAll() throws JAXBException, IOException {
        return new StudentDAO().findAll();
    }

    public void add() throws IOException, JAXBException {
        new StudentDAO(this).add();
    }

    public void remove() throws IOException {
        new StudentDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
