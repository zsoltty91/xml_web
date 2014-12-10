/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Holiday;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddHolidayServlet")
public class AddHolidayServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String nev = request.getParameter("nev");
        String tanev = request.getParameter("tanev");
        String mettol = request.getParameter("mettol");
        String meddig = request.getParameter("meddig");
        if (!(nev.isEmpty() || tanev.isEmpty() || mettol.isEmpty() || meddig.isEmpty())) {
            Holiday holiday = new Holiday();
            holiday.setFrom(LocalDate.parse(mettol));
            holiday.setTo(LocalDate.parse(meddig));
            try {
                holiday.add(tanev);
                  successm="Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
