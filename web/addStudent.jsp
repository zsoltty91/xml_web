<%-- 
    Document   : index
    Created on : 2012.10.14., 21:08:32
    Author     : zsolti
--%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="jspf/header.jsp" %>

<form class="left" action="<c:url value="AddStudentServlet"/>" method="post" >
    <fieldset>
        <legend>Diák létrehozása</legend>
        <table align="center">
            <tr>
                <td>Név:</td>
                <td>
                    <input type="text" name="nev"/>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="email" name="email"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>
<form class="right" action="<c:url value="AddTeacherServlet"/>" method="post" >
    <fieldset>
        <legend>Tanár létrehozása</legend>
        <table align="center">
            <tr>
                <td>Név:</td>
                <td>
                    <input type="text" name="nev"/>
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="email" name="email"/>
                </td>
            </tr>
            <tr>
                <td>Osztálya:</td>
                <td>
                    <select name="osztaly">
                     <!--   <c_rt:forEach var="osztaly" items="${osztalyok}">
                            <option value="${osztaly.id}" selected>{$osztaly.name}</option>
                        </c_rt:forEach>  -->          
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>

<form class="left" action="<c:url value="AddClassServlet"/>" method="post" >
    <fieldset>
        <legend>Osztály létrehozása</legend>
        <table align="center">
            <tr>
                <td>Név:</td>
                <td>
                    <input type="text" name="nev"/>
                </td>
            </tr>
            <tr>
                <td>Osztályfőnok:</td>
                <td>
                    <select name="osztalyfonok">
                     <!--   <c_rt:forEach var="teacher" items="${teachers}">
                            <option value="${teacher.id}" selected>{$teacher.name}</option>
                        </c_rt:forEach>  -->          
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>
<form class="right" action="<c:url value="AddSubjectServlet"/>" method="post" >
    <fieldset>
        <legend>Tantárgy létrehozása</legend>
        <table align="center">
            <tr>
                <td>Név:</td>
                <td>
                    <input type="text" name="nev"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>

<%@include file="jspf/footer.jsp" %>
