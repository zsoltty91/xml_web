/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	public String marshal(LocalDate v) throws Exception {
		return v.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

}

