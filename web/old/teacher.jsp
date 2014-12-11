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
<h1>Tanár</h1>
<table>
    <tr>
        <th>Név:</th>
        <td>${teacher.name}</td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>${teacher.email}</td>
    </tr>
</table>
    
<form class="left" action="<c:url value="AddConsultingHourServlet"/>" method="post" >
    <fieldset>
        <legend>Fogadóóra hozzáadása</legend>
        <table align="center">
            <tr>
                <td>Nap:</td>
                <td>
                    <select name="nap">
                            <option value="HÉTFŐ">hétfő</option>
                            <option value="KEDD">kedd</option>
                            <option value="SZERDA">szerda</option>
                            <option value="CSÜTÖRTÖK">csütörtök</option>
                            <option value="PÉNTEK">péntek</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Időpont:</td>
                <td>
                    <input type="text" name="ido"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="hidden" name="tanar" value="${teacher.id}"/>
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>        

<h2>Fogadóórái</h2>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Nap</th>
            <th>Időpont</th>
        </tr>
    </thead>
    <tbody>

        <c_rt:forEach var="fogadoora" items="${teacher.consultingHours}">
            <tr>
                <td>${fogadoora.id}</td>
                <td>${fogadoora.day}</td>
                <td>${fogadoora.hour}</td>
                <td>
                    <form method="post" action="RemoveConsultingHourServlet">
                    <input type="hidden" name="id" value="${fogadoora.id}"/>
                    <input type="hidden" name="tanar" value="${teacher.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
                </td>
            </tr>
        </c_rt:forEach>
    </tbody>
</table>

<%@include file="jspf/footer.jsp" %>