/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddStudentServlet")
public class AddStudentServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (!(name.isEmpty() || email.isEmpty())) {
            Student student = new Student();
            student.setEmail(email);
            student.setName(name);
            try {
                student.add();
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
