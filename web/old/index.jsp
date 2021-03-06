<%-- 
    Document   : index
    Created on : 2012.10.14., 21:08:32
    Author     : zsolti
--%>
<%@page import="model.Days"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
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
                    <input type="text" name="name"/>
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
                    <input type="text" name="name"/>
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
                <td>Tanév:</td>
                <td>
                    <select name="tanev">
                        <c_rt:forEach var="schoolYear" items="${schoolYears}">
                            <option value="${schoolYear.id}" selected>${schoolYear.id}</option>
                        </c_rt:forEach>          
                    </select>
                </td>
            </tr>
            <tr>
                <td>Osztályfőnök:</td>
                <td>
                    <select name="tanar">
                        <c_rt:forEach var="teacher" items="${teachers}">
                            <option value="${teacher.id}" selected>${teacher.name}</option>
                        </c_rt:forEach>          
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

    

        

Students
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
</thead>
<tbody>
    <c_rt:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>
                <form method="post" action="RemoveStudentServlet">
                    <input type="hidden" name="id" value="${student.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <a href="student.jsp?studentId=${student.id}">Info</a>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table>
Teachers
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
</thead>
<tbody>
    <c_rt:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.email}</td>
            <td>
                <form method="post" action="RemoveTeacherServlet">
                    <input type="hidden" name="id" value="${teacher.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <a href="teacher.jsp?teacherId=${teacher.id}">Info</a>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table> 

Subjects
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
</thead>
<tbody>
    <c_rt:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.name}</td>
            <td>
                <form method="post" action="RemoveSubjectServlet">
                    <input type="hidden" name="id" value="${subject.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table> 

Rooms
<table>
    <thead>
    <th>Id</th>
    <th>Projektor</th>
    <th>Labor</th>
    <th>Size</th>
</thead>
<tbody>
    <c_rt:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.id}</td>
            <td>${room.projektor}</td>
            <td>${room.labor}</td>
            <td>${room.ferohely}</td>
            <td>
                <form method="post" action="RemoveRoomServlet">
                    <input type="hidden" name="id" value="${room.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table>

Schoolyears
<table>
    <thead>
    <th>Id</th>
    <th>From</th>
    <th>To</th>
</thead>
<tbody>
    <c_rt:forEach var="schoolYear" items="${schoolYears}">
        <tr>
            <td>${schoolYear.id}</td>
            <td>${schoolYear.from}</td>
            <td>${schoolYear.to}</td>
            <td>
                <form method="post" action="RemoveSchoolYearServlet">
                    <input type="hidden" name="id" value="${schoolYear.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <a href="schoolyear.jsp?schoolYearId=${schoolYear.id}">Info</a>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table>

Classes
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>SchoolYear</th>
    <th>Teacher</th>
</thead>
<tbody>
    <c_rt:forEach var="class" items="${classes}">
        <tr>
            <td>${class.id}</td>
            <td>${class.name}</td>
            <td>${class.schoolYear.id}</td>
            <td>${class.teacher.name}</td>
            <td>
                <form method="post" action="RemoveClassServlet">
                    <input type="hidden" name="id" value="${class.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
            <td>
                <a href="class.jsp?classId=${class.id}">Info</a>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table>
<%@include file="jspf/footer.jsp" %>