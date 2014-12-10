<%-- 
    Document   : teacher
    Created on : 2014.12.10., 19:42:34
    Author     : zsolti
--%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="jspf/header.jsp" %>
<a href="index.jsp">Vissza</a>
<h1>Diák</h1>
<table>
    <tr>
        <th>Név:</th>
        <td>${student.name}</td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>${student.email}</td>
    </tr>
</table>
<form class="left" action="<c:url value="AddMarkServlet"/>" method="post" >
    <fieldset>
        <legend>Jegy beírása</legend>
        <table align="center">
            <tr>
                <td>Tanév:</td>
                <td>
                    <select name="tanev">
                        <c_rt:forEach var="tanev" items="${schoolYears}">
                            <option value="${tanev.id}">${tanev.id}</option>
                        </c_rt:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Tantárgy:</td>
                <td>
                    <select name="tantargy">
                        <c_rt:forEach var="subject" items="${subjects}">
                            <option value="${subject.id}">${subject.name}</option>
                        </c_rt:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Jegy:</td>
                <td>
                    <select name="jegy">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="hidden" value="${student.id}" name="diak"/>
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>

<h2>Jegyei</h2>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Tantárgy</th>
            <th>Tanév</th>
            <th>Jegy</th>
        </tr>
    </thead>
    <tbody>
        <c_rt:forEach var="jegy" items="${student.marks}">
            <tr>
                <td>${jegy.id}</td>
                <td>${jegy.subject.name}</td>
                <td>${jegy.schoolYear.id}</td>
                <td>${jegy.mark}</td>
                <td>
                    <form method="post" action="RemoveMarkServlet">
                    <input type="hidden" name="id" value="${jegy.id}"/>
                    <input type="hidden" name="diak" value="${student.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
                </td>
            </tr>
        </c_rt:forEach>
    </tbody>
</table>

<%@include file="jspf/footer.jsp" %>