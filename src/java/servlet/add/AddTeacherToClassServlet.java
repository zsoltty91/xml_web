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
import model.SchoolYear;
import model.Student;
import model.Teacher;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddTeacherToClassServlet")
public class AddTeacherToClassServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String osztaly = request.getParameter("osztaly");
        String tanar = request.getParameter("tanar");

        if (!(osztaly.isEmpty() || tanar.isEmpty())) {
            Teacher teacher = new Teacher();
            teacher.setId(tanar);
            try {
                model.Class osztalyObj = model.Class.find(osztaly);
                osztalyObj.remove();
                osztalyObj.setTeacher(teacher);
                osztalyObj.add();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
