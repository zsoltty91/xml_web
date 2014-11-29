/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.SubjectDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tantargy")
public class Subject implements XmlID{

    @XmlAttribute
    private String id;

    @XmlAttribute(name = "nev")
    private String name;

    public Subject() {
    }

    public Subject(String id, String nev) {
        this.id = id;
        this.name = nev;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nev) {
        this.name = nev;
    }

    public static Subject find(String id) throws JAXBException, IOException {
        return new SubjectDAO().find(id);
    }

    public static ArrayList<Subject> findAll() throws JAXBException, IOException {
        return new SubjectDAO().findAll();
    }

    public void add() throws IOException, JAXBException {
        new SubjectDAO(this).add();
    }

    public void remove() throws IOException {
        new SubjectDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
