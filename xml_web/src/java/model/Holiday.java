/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="szunet")
public class Holiday {
    
    @XmlAttribute
    private int id;
   
    @XmlElement(name="nev")
    private String name;
    
    @XmlElement(name="mettol")
    private Date from;
    
    @XmlElement(name="meddig")
    private Date to;

    public Holiday() {
    }

    public Holiday(int id, String name, Date from, Date to) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Holiday{" + "id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + '}';
    }
    
    
}
