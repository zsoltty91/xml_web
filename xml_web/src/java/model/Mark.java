/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author zsolti
 */

@XmlRootElement(name="jegy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mark {
    
    @XmlAttribute
    private int id;
    
    @XmlElement(name="tantargy")
    private Subject subject;
    
    @XmlElement(name="tanev")
    private SchoolYear schoolYear;
    
    @XmlElement(name="erdemjegy")
    private int mark;

    public Mark() {
    }

    public Mark(Subject subject, SchoolYear schoolYear, int mark) {
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.mark = mark;
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

    @Override
    public String toString() {
        return "Mark{" + "id=" + id + ", subject=" + subject + ", schoolYear=" + schoolYear + ", mark=" + mark + '}';
    }
    
    
    
}
