/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SchoolYear;
import model.Student;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/AddStudentToClassServlet")
public class AddStudentToClassServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "class.jsp?classId=" + request.getParameter("classId");
        forward = false;
        String osztaly = request.getParameter("classId");
        String tanulo = request.getParameter("id");
logger.warn(osztaly+" "+tanulo);
        if (!(osztaly.isEmpty() || tanulo.isEmpty())) {
            Student student = new Student();
            student.setId(tanulo);
            try {
                model.Class osztalyObj = model.Class.find(osztaly);
                osztalyObj.setSchoolYear(SchoolYear.find(osztalyObj.getSchoolYear().getId()));
                logger.warn("kiszedtem"+osztalyObj.toString());
                osztalyObj.remove();
                logger.warn("töröltem");
                osztalyObj.addStudent(student);
                logger.warn("adnám hozzá:"+osztalyObj.toString());
               
                osztalyObj.add();
                logger.warn("hozzáadom");
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                throw new RuntimeException("gané");
                //errm = ex.getMessage();
            }
        }

    }
}
