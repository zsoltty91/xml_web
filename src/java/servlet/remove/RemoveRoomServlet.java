/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.remove;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Room;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/RemoveRoomServlet")
public class RemoveRoomServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        url = "index.jsp";
        String id = request.getParameter("id");

        if (!(id.isEmpty())) {
            Room room = new Room();
            room.setId(id);
            try {
                room.remove();
                successm = "Sikeresen törölve!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
