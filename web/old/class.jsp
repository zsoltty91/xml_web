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
Class
<table>
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>SchoolYear</th>
    <th>Teacher</th>
</thead>
<tbody>    
    <tr>
        <td>${class.id}</td>
        <td>${class.name}</td>
        <td>${class.schoolYear.id}</td>
        <td>${class.teacher.name}</td>
    </tr>    
</tbody>
</table>   

<form class="left" action="<c:url value="AddTeacherToClassServlet"/>" method="post" >
    <fieldset>
        <legend>Osztályfőnök módosítása</legend>
        <table align="center">
            <tr>
                <td>Tanár:</td>
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
                    <input type="hidden" name="osztaly" value="${class.id}"/>
                    <input type="submit" value="Módosítás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>
<form class="right" action="<c:url value="AddLessonServlet"/>" method="post" >
    <fieldset>
        <legend>Óra hozzáadása</legend>
        <table align="center">
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
                <td>Tanár:</td>
                <td>
                    <select name="tanar">
                        <c_rt:forEach var="teacher" items="${teachers}">
                            <option value="${teacher.id}" selected>${teacher.name}</option>
                        </c_rt:forEach>          
                    </select>
                </td>
            </tr>
            <tr>
                <td>Terem:</td>
                <td>
                    <select name="terem">
                        <c_rt:forEach var="terem" items="${rooms}">
                            <option value="${terem.id}" selected>${terem.id}</option>
                        </c_rt:forEach>          
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <input type="hidden" value="${class.id}" name="osztaly"/>
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
    <c_rt:forEach var="student" items="${class.students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>
                <form method="post" action="RemoveStudentFromClassServlet">
                    <input type="hidden" name="id" value="${student.id}"/>
                    <input type="hidden" name="classId" value="${class.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table>

Órarend
<table>
    <thead>
    <th>Id</th>
    <th>Nap</th>
    <th>Időpont</th>
    <th>Tantárgy</th>
    <th>Tanár</th>
    <th>Terem</th>
</thead>
<tbody>
    <c_rt:forEach var="lesson" items="${class.lessons}">
        <tr>
            <td>${lesson.id}</td>
            <td>${lesson.day}</td>
            <td>${lesson.time}</td>
            <td>${lesson.subject.name}</td>
            <td>${lesson.teacher.name}</td>
            <td>${lesson.room.id}</td>
            <td>
                <form method="post" action="RemoveLessonServlet">
                    <input type="hidden" name="id" value="${lesson.id}"/>
                    <input type="hidden" name="classId" value="${class.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c_rt:forEach>
</tbody>
</table>

<%@include file="jspf/footer.jsp" %>
