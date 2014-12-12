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
        <div class="header"><h2>Diákok</h2></div>
        <div class="content" id="homew">  

        </div>
    </div>    
</div>
<div id="right">
    <div class="pin">
        <div class="header">Diák létrehozása</div>
        <div class="content">

        </div>
    </div>    
</div>
