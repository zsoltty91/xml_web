/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddStudentToClassServlet")
public class AddStudentToClassServlet extends CommonServlet {

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
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
