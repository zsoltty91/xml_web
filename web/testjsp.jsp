<%-- 
    Document   : testjsp
    Created on : 2014.12.08., 19:30:28
    Author     : Rendszergazda
--%>
<%@page import="dao.ClassDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.SchoolYear"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="jspf/header.jsp" %>

<% 
    model.Class cl = new model.Class();
    cl.setName("12-D");
    cl.setSchoolYear(new SchoolYear("a", LocalDate.of(2013, 1, 1), LocalDate.of(2015, 1, 1), null));
    //out.print(cl.getSchoolYear().getTo());
    String s = new ClassDAO(cl).generateId();    
    out.print(s);
%>

<%@include file="jspf/footer.jsp" %>