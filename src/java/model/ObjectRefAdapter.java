/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.apache.log4j.Logger;
import util.JAXBUtil;
import java.lang.Class;

/**
 *
 * @author zsolti
 * @param <T>
 */
public class ObjectRefAdapter<T extends XmlID> extends XmlAdapter<String, T> {

    private Class<T> clazz;

    protected ObjectRefAdapter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T unmarshal(String v) throws Exception {
        if (v.isEmpty()) {
            return null;
        }
        T t = clazz.newInstance();
        t.setId(v);
        return t;
    }

    @Override
    public String marshal(T v) throws Exception {
        return v.getId();
    }

}
