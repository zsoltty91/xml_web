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
        <div class="header"><h2>Diák</h2></div>
        <div class="content" id="homew">            
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Név:</th>
                        <th>Email:</th>
                    </tr>
                </thead>                
                <tbody>
                    <tr>
                        <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${student.name}</td>
                        <td><img src="../images/mail.png" style="vertical-align: middle;"/> ${student.email}</td>
                    </tr>
                </tbody>
            </table>
        </div></div>
    <div class="box">
        <div class="header"><h2>Jegyei</h2></div>
        <div class="content" id="homew">            
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Tantárgy</th>
                        <th>Tanév</th>
                        <th>Jegy</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="jegy" items="${student.marks}">
                        <tr>
                            <td>${jegy.id}</td>
                            <td><img src="../images/chalkboard.png" style="vertical-align: middle;"/> ${jegy.subject.name}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/>  ${jegy.schoolYear.id}</td>
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


        </div>
    </div>
</div>
<div id="right">
    <div class="pin">
        <div class="header">Jegy beírása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddMarkServlet"/>" method="post" >                
                <table align="center">
                    <tr>
                        <td>Tanév:</td>
                        <td>
                            <select name="tanev" class="chzn-choices" style="width: 12em;">
                                <c_rt:forEach var="tanev" items="${schoolYears}">
                                    <option value="${tanev.id}">${tanev.id}</option>
                                </c_rt:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Tantárgy:</td>
                        <td>
                            <select name="tantargy" class="chzn-choices" style="width: 12em;">
                                <c_rt:forEach var="subject" items="${subjects}">
                                    <option value="${subject.id}">${subject.name}</option>
                                </c_rt:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Jegy:</td>
                        <td>
                            <select name="jegy" class="chzn-choices" style="width: 8em;">
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
            </form>
        </div>
    </div>
</div>

