/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.Teacher;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddTeacherServlet")
public class AddTeacherServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (!(name.isEmpty() || email.isEmpty())) {
            Teacher teacher = new Teacher();
            teacher.setConsultingHours(new ArrayList<>());
            teacher.setEmail(email);
            teacher.setName(name);
            try {
                teacher.add();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
