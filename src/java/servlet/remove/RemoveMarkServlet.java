/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mark;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/RemoveMarkServlet")
public class RemoveMarkServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "student.jsp?studentId="+request.getParameter("diak");
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            Mark mark = new Mark();
            mark.setId(id);
            try {
                mark.remove();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
