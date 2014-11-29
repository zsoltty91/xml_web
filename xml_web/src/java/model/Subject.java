/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="tantargy")
public class Subject {
    @XmlAttribute
    private int id;
    
    @XmlAttribute(name="nev")
    private String name;

    public Subject() {
    }
    
    public Subject(int id, String nev) {
        this.id = id;
        this.name = nev;
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

    public void setName(String nev) {
        this.name = nev;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
