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
        <div class="header"><h2>Tanár</h2></div>
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
                        <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${teacher.name}</td>
                        <td><img src="../images/mail.png" style="vertical-align: middle;"/> ${teacher.email}</td>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Fogadóórái</h2></div>
        <div class="content" id="homew">            
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nap</th>
                        <th>Időpont</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <c_rt:forEach var="fogadoora" items="${teacher.consultingHours}">
                        <tr>
                            <td>${fogadoora.id}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${fogadoora.day}</td>
                            <td><img src="../images/clock.png" style="vertical-align: middle;"/> ${fogadoora.hour}</td>
                            <td>
                                <form method="post" action="RemoveConsultingHourServlet">
                                    <input type="hidden" name="id" value="${fogadoora.id}"/>
                                    <input type="hidden" name="tanar" value="${teacher.id}"/>
                                    <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/cross.png" style="vertical-align: middle;"/></a>
                                    <!--
                                    <input type="submit" value="Delete"/>
                                    -->
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
        <div class="header">Fogadóóra hozzáadása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddConsultingHourServlet"/>" method="post" >                
                <table align="center">
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
                        <td colspan="2" align="center" >
                            <input type="hidden" name="tanar" value="${teacher.id}"/>
                            <input type="submit" value="Létrehozás" />
                        </td>
                    </tr>
                </table>                      
            </form> 
        </div>
    </div>
</div>
