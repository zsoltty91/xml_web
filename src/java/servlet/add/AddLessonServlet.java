/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Days;
import model.Lesson;
import model.Room;
import model.SchoolYear;
import model.Student;
import model.Subject;
import model.Teacher;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/AddLessonServlet")
public class AddLessonServlet extends servlets.CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String nap = request.getParameter("nap");
        String osztaly = request.getParameter("osztaly");
        String ido = request.getParameter("ido");
        String tantargy = request.getParameter("tantargy");
        String tanar = request.getParameter("tanar");
        String terem = request.getParameter("terem");

        if (!(nap.isEmpty() || osztaly.isEmpty() || ido.isEmpty() || tantargy.isEmpty() || tanar.isEmpty() || terem.isEmpty())) {
            Lesson lesson = new Lesson();
            lesson.setDay(Days.valueOf(nap));
            lesson.setTime(LocalTime.parse(ido));
            Subject subject = new Subject();
            subject.setId(tantargy);
            lesson.setSubject(subject);

            Teacher teacher = new Teacher();
            teacher.setId(tanar);
            lesson.setTeacher(teacher);

            Room room = new Room();
            room.setId(terem);
            lesson.setRoom(room);
            try {
                lesson.add(osztaly);
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
