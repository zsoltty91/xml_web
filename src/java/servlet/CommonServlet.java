/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.SchemaException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import model.Room;
import model.SchoolYear;
import model.Student;
import model.Subject;
import model.Teacher;
import org.apache.log4j.Logger;

/**
 *
 * @author zsolti
 */
public abstract class CommonServlet extends HttpServlet {

    public String errm = null;
    public String successm = null;
    public String url = null;
    public boolean forward = false;

    protected Logger logger = Logger.getLogger(CommonServlet.class);

    public abstract void doServlet(HttpServletRequest request, HttpServletResponse response);

    private void doBefore(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.removeAttribute("successMessage");
        request.removeAttribute("errorMessage");
    }

    private void doAfter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("students", Student.findAll());
            request.setAttribute("teachers", Teacher.findAll());
            request.setAttribute("schoolYears", SchoolYear.findAll());
            request.setAttribute("rooms", Room.findAll());
            request.setAttribute("subjects", Subject.findAll());
            ArrayList<model.Class> classes = model.Class.findAll();
            if (classes != null) {
                for (model.Class clazz : classes) {
                    if (clazz.getTeacher() != null) {
                        clazz.setTeacher(Teacher.find(clazz.getTeacher().getId()));
                    }                    
                    ArrayList<Student> students = new ArrayList<>();
                    for (Student student : clazz.getStudents()) {
                        students.add(Student.find(student.getId()));
                    }
                    clazz.setStudents(students);
                }
                request.setAttribute("classes", classes);
            }
        } catch (IOException | JAXBException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            logger.error(ex.getMessage());
        } catch (SchemaException se) {
            StringBuilder sb = new StringBuilder();
            for (String s : se.errors) {
                sb.append(s).append("<br>");
            }
            request.setAttribute("errorMessage", sb.toString());
        }

        String concat = "";
        String prefix = "?";

        if (url.matches(".*\\.jsp\\?.*")) {
            prefix = "&";
        }

        if (errm != null) {
            request.setAttribute("errorMessage", errm);
            concat = "errorMessage=" + URLEncoder.encode(errm);
        }
        if (successm != null) {
            request.setAttribute("successMessage", successm);
            if (errm != null) {
                concat += "&successMessage=" + URLEncoder.encode(successm);
            } else {
                concat = "successMessage=" + URLEncoder.encode(successm);
            }
        }

        concat = prefix + concat;

        errm = null;
        successm = null;

        if (forward) {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else {
            response.sendRedirect(url + concat);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doBefore(request, response);
        doServlet(request, response);
        doAfter(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
