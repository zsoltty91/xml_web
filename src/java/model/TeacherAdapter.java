/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.log4j.Logger;
import util.JAXBUtil;

/**
 *
 * @author zsolti
 */
public class TeacherAdapter extends ObjectRefAdapter<Teacher> {

    public TeacherAdapter() {
        super(Teacher.class);
    }
}
