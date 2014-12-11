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
        <div class="header"><h2>Schoolyear</h2></div>
        <div class="content" id="homew">


            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>From</th>
                        <th>To</th>
                    </tr>
                </thead>
                <tbody>    
                    <tr>
                        <td>${schoolYear.id}</td>
                        <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${schoolYear.from}</td>
                        <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${schoolYear.to}</td>
                    </tr>    
                </tbody>
            </table>


        </div>
    </div>
    <div class="box">
        <div class="header"><h2>Szünetek</h2></div>
        <div class="content" id="homew">
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>From</th>
                        <th>To</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>  
                    <c_rt:forEach var="holiday" items="${schoolYear.holidays}">
                        <tr>
                            <td>${holiday.id}</td>
                            <td>${holiday.name}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${holiday.from}</td>
                            <td><img src="../images/calendar-select-days.png" style="vertical-align: middle;"/> ${holiday.to}</td>
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



        </div>
    </div>
</div>
<div id="right">
    <div class="pin">
        <div class="header">Szünet hozzáadása</div>
        <div class="content">
            <form class="left" action="<c:url value="AddHolidayServlet"/>" method="post" >                
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
            </form>
        </div>
    </div>
</div>


