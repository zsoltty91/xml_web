/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConsultingHour;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/RemoveConsultingHourServlet")
public class RemoveConsultingHourServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "teacher.jsp?teacherId="+request.getParameter("tanar");
        forward=false;
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            ConsultingHour consult = new ConsultingHour();
            consult.setId(id);
            try {
                consult.remove();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
                logger.error(ex.getMessage());
            }
        }

    }
}
