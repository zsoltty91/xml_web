/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Lesson;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/RemoveLessonServlet")
public class RemoveLessonServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "class.jsp?classId="+request.getParameter("classId");
        forward=false;
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            Lesson lesson = new Lesson();
            lesson.setId(id);
            try {
                lesson.remove();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
