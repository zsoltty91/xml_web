<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="today" value="<%=new java.util.Date()%>" />
<fmt:formatDate value="${today}" pattern="yyyy.MM.dd" var="now"></fmt:formatDate>
<%@page import="model.Days"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<div id="secondSubHeader">
    <form method="post" action="/xml_web/new/index.jsp">                
        <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/arrow-curve-180-left.png" style="vertical-align: middle;"/> Vissza</a>
    </form>    
</div> 
<div id="left">
    <div class="box">
        <div class="header"><h2>Osztály</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>SchoolYear</th>
                        <th>Teacher</th>
                    </tr>
                </thead>
                <tbody>    
                    <tr>
                        <td>${class.id}</td>
                        <td>${class.name}</td>
                        <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${class.schoolYear.id}</td>
                        <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${class.teacher.name}</td>
                    </tr>    
                </tbody>
            </table> 
        </div>
    </div>




    <div class="box">
        <div class="header"><h2>Diákok</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th></th>
                    </tr> 
                </thead>
                <tbody>
                    <c_rt:forEach var="student" items="${class.students}">
                        <tr>
                            <td>${student.id}</td>
                            <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/>  ${student.name}</td>
                            <td><img src="../images/mail.png" style="vertical-align: middle;"/> ${student.email}</td>
                            <td>
                                <form method="post" action="RemoveStudentFromClassServlet">
                                    <input type="hidden" name="id" value="${student.id}"/>
                                    <input type="hidden" name="classId" value="${class.id}"/>
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
        <div class="header"><h2>Órarend</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nap</th>
                        <th>Időpont</th>
                        <th>Tantárgy</th>
                        <th>Tanár</th>
                        <th>Terem</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="lesson" items="${class.lessons}">
                        <tr>
                            <td>${lesson.id}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/>  ${lesson.day}</td>
                            <td><img src="../images/clock.png" style="vertical-align: middle;"/> ${lesson.time}</td>
                            <td><img src="../images/chalkboard.png" style="vertical-align: middle;"/> ${lesson.subject.name}</td>
                            <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${lesson.teacher.name}</td>
                            <td>${lesson.room.id}</td>
                            <td>
                                <form method="post" action="RemoveLessonServlet">
                                    <input type="hidden" name="id" value="${lesson.id}"/>
                                    <input type="hidden" name="classId" value="${class.id}"/>
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
        <div class="header">Osztályfőnök módosítása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddTeacherToClassServlet"/>" method="post" >                
                <table align="center">
                    <tr>
                        <td>Tanár:</td>
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
                            <input type="hidden" name="osztaly" value="${class.id}"/>
                            <input type="submit" value="Módosítás" />
                        </td>
                    </tr>
                </table>                      
            </form>
        </div>
    </div>

    <div class="pin">
        <div class="header">Diák hozzáadása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddStudentToClassServlet"/>" method="post" >                
                <table align="center">
                    <tr>
                        <td>Diákok:</td>
                        <td>
                            <select name="id" class="chzn-choices" style="width: 12em;">
                                <c_rt:forEach var="diak" items="${students}">
                                    <option value="${diak.id}" selected>${diak.name}</option>
                                </c_rt:forEach>          
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" >
                            <input type="hidden" name="classId" value="${class.id}"/>
                            <input type="submit" value="Hozzáadás" />
                        </td>
                    </tr>
                </table>                      
            </form>  
        </div>
    </div>

    <div class="pin">
        <div class="header">Óra hozzáadása</div>
        <div class="content">
            <form class="right" action="<c:url value="AddLessonServlet"/>" method="post" >                
                <table align="center">
                    <tr>
                        <td>Tantárgy:</td>
                        <td>
                            <select name="tantargy" class="chzn-choices" style="width: 16em;">
                                <c_rt:forEach var="subject" items="${subjects}">
                                    <option value="${subject.id}">${subject.name}</option>
                                </c_rt:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Nap:</td>
                        <td>
                            <select name="nap" class="chzn-choices" style="width: 12em;">
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
                            <select name="tanar" class="chzn-choices" style="width: 12em;">
                                <c_rt:forEach var="teacher" items="${teachers}">
                                    <option value="${teacher.id}" selected>${teacher.name}</option>
                                </c_rt:forEach>          
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Terem:</td>
                        <td>
                            <select name="terem" class="chzn-choices" style="width: 12em;">
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
            </form>
        </div>
    </div>                            
</div>
