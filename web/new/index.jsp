<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="today" value="<%=new java.util.Date()%>" />
<fmt:formatDate value="${today}" pattern="yyyy.MM.dd" var="now"></fmt:formatDate>
<%@page import="model.Days"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<div id="left">
    <div class="box">
        <div class="header"><h2>Összes diák</h2></div>
        <div class="content" id="homew">  
            <form method="post" action="activeStudents.jsp" style="float: left; padding-right: 10px;">                   
                <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/users.png" style="vertical-align: middle;"/> Jelenlegi diákok</a>
            </form>
            <form method="post" action="inactiveStudents.jsp" style="float: left; padding-right: 10px;">                   
                <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/users.png" style="vertical-align: middle;"/> Volt diákok</a>
            </form>
            <form method="post" action="topStudents.jsp">                   
                <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/users.png" style="vertical-align: middle;"/> TOP diákok</a>
            </form>
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.id}</td>
                            <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${student.name}</td>
                            <td><img src="../images/mail.png" style="vertical-align: middle;"/> ${student.email}</td>
                            <td>
                                <a href="student.jsp?studentId=${student.id}"><img src="../images/pencil.png" style="vertical-align: middle;"/></a>
                            </td>
                            <td>
                                <form method="post" action="RemoveStudentServlet">
                                    <input type="hidden" name="id" value="${student.id}"/>
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                </form>
                            </td>
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Tanárok</h2></div>
        <div class="content" id="homew">   
            <form method="post" action="ofok.jsp">                   
                <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/users.png" style="vertical-align: middle;"/> Osztályfönökök</a>
            </form>
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="teacher" items="${teachers}">
                        <tr>
                            <td>${teacher.id}</td>
                            <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${teacher.name}</td>
                            <td><img src="../images/mail.png" style="vertical-align: middle;"/> ${teacher.email}</td>
                            <td>
                                <a href="teacher.jsp?teacherId=${teacher.id}"><img src="../images/pencil.png" style="vertical-align: middle;"/></a>
                            </td>
                            <td>
                                <form method="post" action="RemoveTeacherServlet">
                                    <input type="hidden" name="id" value="${teacher.id}"/>
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                </form>
                            </td>                        
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table> 

        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Tantárgyak</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="subject" items="${subjects}">
                        <tr>
                            <td>${subject.id}</td>
                            <td><img src="../images/chalkboard.png" style="vertical-align: middle;"/> ${subject.name}</td>
                            <td>
                                <form method="post" action="RemoveSubjectServlet">
                                    <input type="hidden" name="id" value="${subject.id}"/>
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                </form>
                            </td>
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table> 

        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Termek</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Projektor</th>
                        <th>Labor</th>
                        <th>Size</th>
                        <th></th>
                    </tr>
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
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                </form>
                            </td>
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Tanévek</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>From</th>
                        <th>To</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="schoolYear" items="${schoolYears}">
                        <tr>
                            <td>${schoolYear.id}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${schoolYear.from}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${schoolYear.to}</td>
                            <td>
                                <a href="schoolyear.jsp?schoolYearId=${schoolYear.id}"><img src="../images/pencil.png" style="vertical-align: middle;"/></a>
                            </td>
                            <td>
                                <form method="post" action="RemoveSchoolYearServlet">
                                    <input type="hidden" name="id" value="${schoolYear.id}"/>
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                </form>
                            </td>                        
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Osztályok</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">                
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>SchoolYear</th>
                        <th>Teacher</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="class" items="${classes}">
                        <tr>
                            <td>${class.id}</td>
                            <td>${class.name}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${class.schoolYear.id}</td>
                            <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${class.teacher.name}</td>
                            <td>
                                <a href="class.jsp?classId=${class.id}"><img src="../images/pencil.png" style="vertical-align: middle;"/></a>
                            </td>
                            <td>
                                <form method="post" action="RemoveClassServlet">
                                    <input type="hidden" name="id" value="${class.id}"/>
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                </form>
                            </td>                        
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div id="right">
    <div class="pin">
        <div class="header">Diák létrehozása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddStudentServlet"/>" method="post" >                               
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
            </form>
        </div>
    </div>
    <div class="pin">
        <div class="header">Tanár létrehozása</div>
        <div class="content">
            <form class="right" action="<c:url value="AddTeacherServlet"/>" method="post" >                
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
            </form>
        </div>
    </div>
    <div class="pin">
        <div class="header">Osztály létrehozása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddClassServlet"/>" method="post" >
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
                            <select name="tanev" class="chzn-choices" style="width: 12em;">
                                <c_rt:forEach var="schoolYear" items="${schoolYears}">
                                    <option value="${schoolYear.id}" selected>${schoolYear.id}</option>
                                </c_rt:forEach>          
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Osztályfőnök:</td>
                        <td>
                            <select name="tanar" class="chzn-choices" style="width: 12em;">
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
            </form>
        </div>
    </div>
    <div class="pin">
        <div class="header">Tantárgy létrehozása</div>
        <div class="content">
            <form class="right" action="<c:url value="AddSubjectServlet"/>" method="post" >
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
            </form>
        </div>
    </div>
    <div class="pin">
        <div class="header">Tanév létrehozása</div>
        <div class="content">
            <form class="right" action="<c:url value="AddSchoolYearServlet"/>" method="post" >
                <table align="center">
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
            </form>
        </div>
    </div>
    <div class="pin">
        <div class="header">Terem létrehozása</div>
        <div class="content">
            <form class="right" action="<c:url value="AddRoomServlet"/>" method="post" >
                <table align="center">
                    <tr>
                        <td>Név:</td>
                        <td>
                            <input type="text" name="nev"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Labor:</td>
                        <td>
                            <select name="labor" class="chzn-choices" style="width: 12em;">                             
                                <option value="true" selected>Igen</option>
                                <option value="false">Nem</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Projektor:</td>
                        <td>
                            <select name="projektor" class="chzn-choices" style="width: 12em;">                             
                                <option value="true" selected>Van</option>
                                <option value="false">Nincs</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Férőhely:</td>
                        <td>
                            <input type="number" name="ferohely"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" >
                            <input type="submit" value="Létrehozás" />
                        </td>
                    </tr>
                </table>      
            </form>
        </div>
    </div>
</div>
