/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author zsolti
 */
public class LocalTimeAdapter extends XmlAdapter<String,LocalTime>{
    public LocalTime unmarshal(String v) throws Exception {
		return LocalTime.parse(v);
	}

	public String marshal(LocalTime v) throws Exception {
            	return v.format(DateTimeFormatter.ISO_LOCAL_TIME);
	}
}
