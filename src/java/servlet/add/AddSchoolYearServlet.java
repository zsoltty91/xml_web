/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SchoolYear;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/AddSchoolYearServlet")
public class AddSchoolYearServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String mettol = request.getParameter("mettol");
        String meddig = request.getParameter("meddig");
        if (!(mettol.isEmpty() || meddig.isEmpty())) {
            SchoolYear schoolYear = new SchoolYear();
            schoolYear.setHolidays(new ArrayList<>());
            schoolYear.setFrom(LocalDate.parse(mettol));
            schoolYear.setTo(LocalDate.parse(meddig));
            try {
                schoolYear.add();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
