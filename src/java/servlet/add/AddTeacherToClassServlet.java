/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/AddTeacherToClassServlet")
public class AddTeacherToClassServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "class.jsp?classId="+request.getParameter("osztaly");
        forward=false;
        String osztaly = request.getParameter("osztaly");
        String tanar = request.getParameter("tanar");

        if (!(osztaly.isEmpty() || tanar.isEmpty())) {
            Teacher teacher = new Teacher();
            teacher.setId(tanar);
            try {
                model.Class osztalyObj = model.Class.find(osztaly);                
                osztalyObj.setTeacher(Teacher.find(tanar));
                osztalyObj.updateTeacher();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
