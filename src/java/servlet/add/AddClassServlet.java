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
import model.Student;
import model.Teacher;
import org.apache.log4j.Logger;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddClassServlet")
public class AddClassServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String nev = request.getParameter("nev");
        String tanev = request.getParameter("tanev");
        String tanar = request.getParameter("tanar");

        if (!(nev.isEmpty() || tanev.isEmpty() || tanar.isEmpty())) {
            model.Class osztaly = new model.Class();

            try {
                SchoolYear schoolYear = SchoolYear.find(tanev);
                osztaly.setSchoolYear(schoolYear);
                osztaly.setName(nev);
                Teacher teacher = new Teacher();
                teacher.setId(tanar);
                osztaly.setTeacher(teacher);
                osztaly.setStudents(new ArrayList<>());
                osztaly.setLessons(new ArrayList<>());
                osztaly.add();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                Logger.getLogger("d").error(ex.getMessage());
                errm = ex.getMessage();
            }
        }

    }
}
