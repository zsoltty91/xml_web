/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.TeacherDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tanar")
public class Teacher extends Person {

    @XmlElement(name = "osztaly")
    @XmlJavaTypeAdapter(ClassAdapter.class)
    private Class form;

    @XmlElementWrapper(name = "fogadoorak")
    @XmlElement(name = "fogadoora")
    private ArrayList<ConsultingHour> consultingHours;

    public Teacher() {
        consultingHours = new ArrayList<>();
    }

    public Teacher(String id, Class form, ArrayList<ConsultingHour> consultingHours, String name, String email) {
        super(id, name, email);
        this.form = form;
        this.consultingHours = consultingHours;
    }

    public Class getForm() {
        return form;
    }

    public void setForm(Class form) {
        this.form = form;
    }

    public ArrayList<ConsultingHour> getConsultingHours() {
        return consultingHours;
    }

    public void setConsultingHours(ArrayList<ConsultingHour> consultingHours) {
        this.consultingHours = consultingHours;
    }

    public static Teacher find(int id) throws JAXBException, IOException {
        return new TeacherDAO().find(id);
    }

    public static ArrayList<Teacher> findAll() throws JAXBException, IOException {
        return new TeacherDAO().findAll();
    }

    public void add() throws IOException, JAXBException {
        new TeacherDAO(this).add();
    }

    public void remove() throws IOException {
        new TeacherDAO(this).remove();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
