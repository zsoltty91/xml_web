/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.HolidayDAO;
import java.io.IOException;
import java.time.LocalDate;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "szunet")
public class Holiday implements XmlID {

    @XmlAttribute
    private String id;

    @XmlElement(name = "nev")
    private String name;

    @XmlElement(name = "mettol")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate from;

    @XmlElement(name = "meddig")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate to;

    public Holiday() {
    }

    public Holiday(String id, String name, LocalDate from, LocalDate to) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
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

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public static Holiday find(String id) throws JAXBException, IOException {
        return new HolidayDAO().find(id);
    }

    public static ArrayList<Holiday> findAll() throws JAXBException, IOException {
        return new HolidayDAO().findAll();
    }

    public void add(String schoolYearId) throws JAXBException, IOException {
        new HolidayDAO(this).add(schoolYearId);
    }

    public void remove() throws IOException {
        new HolidayDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
