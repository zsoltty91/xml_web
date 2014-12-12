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
        <div class="header"><h2>Jelenleg is diákok</h2></div>
        <div class="content" id="homew">  
            <table class="sortableTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>                        
                    </tr>
                </thead>
                <tbody>
                    <c_rt:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.id}</td>
                            <td><img src="../images/user-business-gray.png" style="vertical-align: middle;"/> ${student.name}</td>
                            <td><img src="../images/mail.png" style="vertical-align: middle;"/> ${student.email}</td>                            
                        </tr>
                    </c_rt:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="box">        
        <div class="header"><h2>XML eredmény</h2></div>
        <div class="content" id="homew" style="font-size: 1.3em;">
            <pre><code class="xml">
                <c_rt:forEach var="sor" items="${xml}">
                    ${sor}
                </c_rt:forEach>
            </code></pre>
        </div>
    </div>
</div>
