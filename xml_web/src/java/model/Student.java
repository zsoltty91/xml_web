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
@XmlRootElement(name="diak")
public class Student extends Person{
  
    @XmlElementWrapper(name="jegyei")
    @XmlElement(name="jegy")
  private ArrayList<Mark> marks;

    public Student() {
        marks=new ArrayList<Mark>();
    }

    public Student(ArrayList<Mark> marks, int id, String name, String email) {
        super(id, name, email);
        this.marks = marks;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+ "marks=" + marks + '}';
    }
  
}
