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
import model.SchoolYear;
import model.Student;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddSchoolYearServlet")
public class AddSchoolYearServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String mettol = request.getParameter("mettol");
        String meddig = request.getParameter("meddig");
        if (!(mettol.isEmpty() || meddig.isEmpty())) {
            SchoolYear schoolYear = new SchoolYear();
            schoolYear.setFrom(LocalDate.parse(mettol));
            schoolYear.setTo(LocalDate.parse(meddig));
            try {
                schoolYear.add();
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
