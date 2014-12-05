/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Holiday;
import model.Room;
import model.SchoolYear;
import model.Student;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddRoomServlet")
public class AddRoomServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String szam = request.getParameter("szam");
        String labor = request.getParameter("labor");
        String projektor = request.getParameter("projektor");
        String ferohely = request.getParameter("ferohely");
        if (!(szam.isEmpty() || labor.isEmpty() || projektor.isEmpty() || ferohely.isEmpty())) {
            Room room = new Room();
            room.setId(szam);
            room.setLabor(new Boolean(labor));
            room.setProjektor(new Boolean(projektor));
            try {
                room.setFerohely(Integer.parseInt(ferohely));
                room.add();
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
