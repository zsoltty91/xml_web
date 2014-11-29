/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author zsolti
 */
public class DayAdapter extends XmlAdapter<String, Days> {

    public Days unmarshal(String v) throws Exception {
        Days nap = null;
        switch (v) {
            case "hétfő":
                nap = Days.HÉTFŐ;
                break;
            case "kedd":
                nap = Days.KEDD;
                break;
            case "szerda":
                nap = Days.SZERDA;
                break;
            case "csütörtök":
                nap = Days.CSÜTÖRTÖK;
                break;
            case "péntek":
                nap = Days.PÉNTEK;
                break;
            case "szombat":
                nap = Days.SZOMBAT;
                break;
            case "vasárnap":
                nap = Days.VASÁRNAP;
                break;
        }
        return nap;
    }

    @Override
    public String marshal(Days v) throws Exception {
        String nap = null;
        switch (v) {
            case HÉTFŐ:
                nap = "hétfő";
                break;
            case KEDD:
                nap = "kedd";
                break;
            case SZERDA:
                nap = "szerda";
                break;
            case CSÜTÖRTÖK:
                nap = "csütörtök";
                break;
            case PÉNTEK:
                nap = "péntek";
                break;
            case SZOMBAT:
                nap = "szombat";
                break;
            case VASÁRNAP:
                nap = "vasárnap";
                break;
        }
        return nap;
    }
}
