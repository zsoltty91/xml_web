/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MarkDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author zsolti
 */
@XmlRootElement(name = "jegy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mark implements XmlID {

    @XmlAttribute
    private String id;

    @XmlElement(name = "tantargy")
    @XmlJavaTypeAdapter(SubjectAdapter.class)
    private Subject subject;

    @XmlElement(name = "tanev")
    @XmlJavaTypeAdapter(SchoolYearAdapter.class)
    private SchoolYear schoolYear;

    @XmlElement(name = "erdemjegy")
    private Integer mark;

    public Mark() {
    }

    public Mark(Subject subject, SchoolYear schoolYear, Integer mark) {
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public static Mark find(String id) throws JAXBException, IOException {
        return new MarkDAO().find(id);
    }

    public static ArrayList<Mark> findAll() throws JAXBException, IOException {
        return new MarkDAO().findAll();
    }

    public void add(String studentId) throws IOException, JAXBException {
        new MarkDAO(this).add(studentId);
    }

    public void remove() throws IOException {
        new MarkDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
