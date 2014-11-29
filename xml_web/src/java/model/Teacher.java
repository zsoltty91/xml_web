/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="tanar")
public class Teacher extends Person{
    
    @XmlElement(name="osztalya")
    private Class form;
            
    @XmlElementWrapper(name="fogadoorak")
    @XmlElement(name="fogadoora")
    private ArrayList<ConsultingHour> consultingHours;

    public Teacher() {
        consultingHours= new ArrayList<ConsultingHour>();
    }

    public Teacher(int id, Class form, ArrayList<ConsultingHour> consultingHours, String name, String email) {
        super(id, name, email);
        this.form = form;
        this.consultingHours = consultingHours;
    }
    
    
}
