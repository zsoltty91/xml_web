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
<form class="left" action="<c:url value="AddConsultingHourServlet"/>" method="post" >
    <fieldset>
        <legend>Fogadóóra hozzáadása</legend>
        <table align="center">
            <tr>
                <td>Tanár:</td>
                <td>
                    <select name="tanar">
                        <c_rt:forEach var="tanar" items="${teachers}">
                            <option value="${tanar.id}">${tanar.name}</option>
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
                <td>Idő:</td>
                <td>
                    <input type="text" name="ido"/>
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
                    <input type="submit" value="Létrehozás" />
                </td>
            </tr>
        </table>      
    </fieldset>
</form>    

<form class="left" action="<c:url value="AddMarkServlet"/>" method="post" >
    <fieldset>
        <legend>Jegy beírása</legend>
        <table align="center">
            <tr>
                <td>Diák</td>
                <td>
                    <select name="diak">
                        <c_rt:forEach var="student" items="${students}">
                            <option value="${student.id}">${student.name}</option>
                        </c_rt:forEach>
                    </select>
                </td>
            </tr>
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
        </tr>
    </c_rt:forEach>
</tbody>
</table>
<%@include file="jspf/footer.jsp" %>
