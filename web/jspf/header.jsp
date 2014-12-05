<%-- 
    Document   : header
    Created on : 2014.11.30., 15:34:50
    Author     : zsolti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <link href="css/main.css" type="text/css"
              rel="stylesheet" />
        <title>Tanulmányi Rendszer</title>
    </head>
    <body>
        <div id="container">

            <div id="header">
                <div id="leftheader">
                    <table>
                        <tr>
                            <td>
                                <h1>Tanulmányi rendszer</h1>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="menu">
                <ul>
                    <li><a href='index.jsp'><span>Kezdőlap</span></a></li>
                    <li class='has-sub '><a href=''><span>Tanárok</span></a>
                        <ul>
                            <li><a href='users.jsp'><span>Keresés</span></a></li>
                            <li><a href='createuser.jsp'><span>Hozzáadás</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div id="content">
                <c_rt:if test="${param.errorMessage!=null || errorMessage!=null}">
                    <table id="errormsg">
                        <tr>
                            <td>
                                <img src="images/error40.png"/>
                            </td>
                            <td>
                                ${param.errorMessage}${errorMessage}
                            </td>
                        </tr>
                    </table>
                </c_rt:if>  

                <c_rt:if test="${param.successMessage!=null || successMessage!=null}">
                    <table id="successmsg">
                        <tr>
                            <td>
                                <img src="images/ok40.png"/>
                            </td>
                            <td>
                                ${param.successMessage}${successMessage}
                            </td>
                        </tr>
                    </table>  
                </c_rt:if>

