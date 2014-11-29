/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil {

    /**
     * Serializes an object to XML. The output document is written in UTF-8
     * encoding.
     *
     * @param o the object to serialize
     * @param os the {@link OutputStream} to write to
     * @throws JAXBException on any error
     */
    public static void toXML(Object o, OutputStream os) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(o, os);
        } catch (JAXBException e) {
            throw e;
        }
    }

    public static String toXML(Object o) throws JAXBException {
        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(o, writer);
            String xml = writer.toString();
            xml=xml.substring(xml.indexOf('\n')+1);
            return xml;
        } catch (JAXBException e) {
            throw e;
        }
    }
    
    /**
     * Deserializes an object from XML.
     *
     * @param clazz the class of the object
     * @param is the {@link InputStream} to read from
     * @return the resulting object
     * @throws JAXBException on any error
     */
    public static <T> T fromXML(Class<T> clazz, InputStream is) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            throw e;
        }
    }

    public static <T> T fromXMLElement(Class<T> clazz, String xmlElement) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlElement);
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw e;
        }
    }

    public static <T> ArrayList<T> fromXMLElement(Class<T> clazz, ArrayList<String> xmlElements) throws JAXBException {
        if (xmlElements.isEmpty()) {
            return null;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = null;
            ArrayList<T> objects = new ArrayList<T>();
            for (String xmlElement : xmlElements) {
                reader = new StringReader(xmlElement);
                objects.add((T) unmarshaller.unmarshal(reader));
            }
            return objects;
        } catch (JAXBException e) {
            throw e;
        }
    }

}
