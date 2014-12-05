/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mark;
import model.SchoolYear;
import model.Student;
import model.Subject;
import model.Teacher;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddMarkServlet")
public class AddMarkServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String targy = request.getParameter("targy");
        String tanev = request.getParameter("tanev");
        String jegy = request.getParameter("jegy");
        String diak = request.getParameter("diak");
        if (!(targy.isEmpty() || tanev.isEmpty() || jegy.isEmpty())) {
          Mark mark = new Mark();
            Subject subject = new Subject();
            subject.setId(targy);
            mark.setSubject(subject);
            SchoolYear schoolYear = new SchoolYear();
            schoolYear.setId(tanev);
            mark.setSchoolYear(schoolYear);
            try {
                mark.setMark(Integer.parseInt(jegy));
                mark.add(diak);
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
