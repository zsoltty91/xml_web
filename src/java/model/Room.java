/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.RoomDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "terem")
public class Room implements XmlID{

    @XmlAttribute
    private String id;

    @XmlElement(name = "labor")
    private Boolean labor;

    @XmlElement(name = "projektor")
    private Boolean projektor;

    @XmlElement(name = "ferohely")
    private Integer ferohely;

    public Room() {
    }

    public Room(String id, boolean labor, boolean projektor, int ferohely) {
        this.id = id;
        this.labor = labor;
        this.projektor = projektor;
        this.ferohely = ferohely;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLabor() {
        return labor;
    }

    public void setLabor(boolean labor) {
        this.labor = labor;
    }

    public boolean isProjektor() {
        return projektor;
    }

    public void setProjektor(boolean projektor) {
        this.projektor = projektor;
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }

    public static Room find(int id) throws JAXBException, IOException {
        return new RoomDAO().find(id);
    }

    public static ArrayList<Room> findAll() throws JAXBException, IOException {
        return new RoomDAO().findAll();
    }
    
    public void add() throws JAXBException, IOException {
        new RoomDAO(this).add();
    }

    public void remove() throws IOException {
        new RoomDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
