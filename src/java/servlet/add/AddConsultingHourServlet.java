/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import java.time.LocalTime;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConsultingHour;
import model.Days;
import model.Mark;
import model.SchoolYear;
import model.Student;
import model.Subject;
import model.Teacher;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddConsultingHourServlet")
public class AddConsultingHourServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "teacher.jsp?teacherId="+request.getParameter("tanar");
        forward=false;
        String day = request.getParameter("nap");
        String ido = request.getParameter("ido");
        String tanar = request.getParameter("tanar");
        if (!(day.isEmpty() || tanar.isEmpty() || ido.isEmpty())) {
            ConsultingHour consult = new ConsultingHour();
            consult.setDay(Days.valueOf(day));
            consult.setHour(LocalTime.parse(ido));
            try {
                consult.add(tanar);
                  successm="Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
