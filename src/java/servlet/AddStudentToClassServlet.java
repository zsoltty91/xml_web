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
import model.Teacher;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddStudentToClassServlet")
public class AddStudentToClassServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String osztaly = request.getParameter("osztaly");
        String tanulo = request.getParameter("tanulo");
         
        if (!(osztaly.isEmpty() || tanulo.isEmpty())) {
            Student student = new Student();
            student.setId(tanulo);
            try {
                model.Class osztalyObj = model.Class.find(osztaly);
                osztalyObj.remove();
                osztalyObj.addStudent(student);
                osztalyObj.add();
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
