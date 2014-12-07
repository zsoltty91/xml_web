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
@WebServlet(value = "/AddClassServlet")
public class AddClassServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String nev = request.getParameter("nev");
        String tanev = request.getParameter("tanev");
        String tanar = request.getParameter("tanar");
        
        if (!(nev.isEmpty() || tanev.isEmpty() || tanar.isEmpty())) {
            model.Class osztaly = new model.Class();
            SchoolYear schoolYear = new SchoolYear();
            schoolYear.setId(tanev);
            osztaly.setSchoolYear(schoolYear);
            osztaly.setName(nev);
            Teacher teacher = new Teacher();
            teacher.setId(tanar);
            osztaly.setTeacher(teacher);            
            successm="Sikeresen hozzáadva!";
            try {
                osztaly.add();
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
