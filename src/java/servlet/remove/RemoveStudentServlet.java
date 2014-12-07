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
import model.Teacher;

/**
 *
 * @author zsolti
 */

@WebServlet(value = "/RemoveStudentServlet")
public class RemoveStudentServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
       String id = request.getParameter("id");
        
        if (!(id.isEmpty())) {
            Student student = new Student();
            student.setId(id);
            successm="Sikeresen törölve!";
            try {
                student.remove();
             successm="Sikeresen törölve!";
           } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
