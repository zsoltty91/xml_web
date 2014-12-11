/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/RemoveStudentFromClassServlet")
public class RemoveStudentFromClassServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "class.jsp?classId="+request.getParameter("classId");
        forward=false;
        
        String studentId = request.getParameter("studentId");
        String classId = request.getParameter("classId");

        if (!(studentId.isEmpty() || classId.isEmpty())) {
            Student student = new Student();
            student.setId(studentId);
            try {
                model.Class classObj = model.Class.find(classId);
                dao.ClassDAO dao = new dao.ClassDAO(classObj);
                dao.removeStudent(studentId);
                //classObj.removeStudent(student);
                //classObj.remove();
                //classObj.add();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
