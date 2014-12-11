/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Holiday;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/RemoveHolidayServlet")
public class RemoveHolidayServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "schoolyear.jsp?schoolYearId="+request.getParameter("tanev");
        forward=false;
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            Holiday holiday = new Holiday();
            holiday.setId(id);
            try {
                holiday.remove();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
