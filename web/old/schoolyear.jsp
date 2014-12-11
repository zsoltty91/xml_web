<%-- 
    Document   : index
    Created on : 2012.10.14., 21:08:32
    Author     : zsolti
--%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="jspf/header.jsp" %>
<a href="index.jsp">Vissza</a>
Schoolyear
<table>
    <thead>
    <th>Id</th>
    <th>From</th>
    <th>To</th>
</thead>
<tbody>    
    <tr>
        <td>${schoolYear.id}</td>
        <td>${schoolYear.from}</td>
        <td>${schoolYear.to}</td>
    </tr>    
</tbody>
</table>

<form class="left" action="<c:url value="AddHolidayServlet"/>" method="post" >
    <fieldset>
        <legend>Szünet hozzáadása</legend>
        <table align="center">
            <tr>
                <td>Név:</td>
                <td>
                    <input type="text" name="nev"/>
                </td>
            </tr>
            <tr>
                <td>Mettől:</td>
                <td>
                    <input type="text" name="mettol"/>
                </td>
            </tr>
            <tr>
                <td>Meddig:</td>
                <td>
                    <input type="text" name="meddig"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="hidden" value="${schoolYear.id}" name="tanev"/>
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>

Holidays
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>From</th>
    <th>To</th>
</thead>
<tbody>  
    <c_rt:forEach var="holiday" items="${schoolYear.holidays}">
        <tr>
            <td>${holiday.id}</td>
            <td>${holiday.name}</td>
            <td>${holiday.from}</td>
            <td>${holiday.to}</td>
            <td>
                <form method="post" action="RemoveHolidayServlet">
                    <input type="hidden" name="id" value="${holiday.id}"/>
                    <input type="hidden" name="tanev" value="${schoolYear.id}"/>
                    <input type="submit" value="Delete"/>                    
                </form>
            </td>
        </tr>    
    </c_rt:forEach>
</tbody>
</table>                   

<%@include file="jspf/footer.jsp" %>
