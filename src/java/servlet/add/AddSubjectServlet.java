/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

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
@WebServlet(value = "/AddSubjectServlet")
public class AddSubjectServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String id = request.getParameter("id");
        String nev = request.getParameter("nev");

        if (!(id.isEmpty() || nev.isEmpty())) {
            Subject subject = new Subject();
            subject.setId(id);
            subject.setName(nev);
            try {
                subject.add();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
