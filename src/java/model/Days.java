/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author zsolti
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="nap")
@XmlJavaTypeAdapter(DayAdapter.class)
public enum Days {
    HÉTFŐ, KEDD, SZERDA, CSÜTÖRTÖK, PÉNTEK, SZOMBAT, VASÁRNAP
}
