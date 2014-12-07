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
import model.Holiday;
import model.Lesson;
import model.Mark;
import model.SchoolYear;
import model.Student;
import model.Teacher;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/RemoveMarkServlet")
public class RemoveMarkServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            Mark mark = new Mark();
            mark.setId(id);
            try {
                mark.remove();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
