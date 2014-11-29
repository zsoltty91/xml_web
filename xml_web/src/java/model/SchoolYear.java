/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="tanev")
public class SchoolYear {
    
    @XmlAttribute
    private int id;
    
    @XmlElement(name="mettol")
    private Date from;
    
    @XmlElement(name="meddig")
    private Date to;
    
    @XmlElementWrapper(name="szunetek")
    @XmlElement(name="szunet")
    ArrayList<Holiday> holidays;

    public SchoolYear() {
        holidays=new ArrayList<Holiday>();
    }

    public SchoolYear(int id, Date from, Date to, ArrayList<Holiday> holidays) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.holidays = holidays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Holiday> holidays) {
        this.holidays = holidays;
    }

    @Override
    public String toString() {
        return "SchoolYear{" + "id=" + id + ", from=" + from + ", to=" + to + ", holidays=" + holidays + '}';
    }
    
}
