/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SchoolYear;
import model.Student;
import model.Subject;
import model.Teacher;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/RemoveSubjectServlet")
public class RemoveSubjectServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            Subject subject = new Subject();
            subject.setId(id);
            try {
                subject.remove();
            successm = "Sikeresen törölve!";
          } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
