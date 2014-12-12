/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.add;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Subject;
import servlet.CommonServlet;

/**
 *
 * @author zsolti
 */
@WebServlet(value = "/new/AddSubjectServlet")
public class AddSubjectServlet extends CommonServlet {

    @Override
    public void doServlet(HttpServletRequest request, HttpServletResponse response) {
        
        url = "index.jsp";
        String nev = request.getParameter("nev");

        if (!( nev.isEmpty())) {
            Subject subject = new Subject();
            subject.setName(nev);
            try {
                subject.add();
                successm = "Sikeresen hozzáadva!";
            } catch (Exception ex) {
                errm = ex.getMessage();
            }
        }

    }
}
