<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Neptun - Main</title>

        <!-- CSS -->        
        <link type="text/css" href="../css/include/header.css" rel="stylesheet" />
        <link type="text/css" href="../css/main.css" rel="stylesheet" />
        <link type="text/css" href="../css/input.css" rel="stylesheet" />
        <link type="text/css" href="../css/messageDivs.css" rel="stylesheet" />
        <link type="text/css" href="../css/chosen.css" rel="stylesheet"/>                                      
        <!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" /> -->
        <link type="text/css" href="../css/jquery-ui.css" rel="stylesheet"/>  
        <link type="text/css" href="../css/tablesorter/style.css" rel="stylesheet"/>                          
        <link type="text/css" href="../css/onoff.css" rel="stylesheet"/>                          

        <!-- <script src="http://code.jquery.com/jquery-1.8.2.js"></script>         
        <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script> -->
        <script src="../js/jquery-1.8.2.js"></script>
        <script src="../js/jquery-ui.js"></script>
        <script src="../js/timepicker.js"></script>
        <script src="../js/jquery.tablesorter.js" type="text/javascript"></script>
        <script src="../js/jquery.metadata.js" type="text/javascript"></script>
        <script src="../js/chosen/chosen.jquery.min.js"></script>
        <script src="../js/chosen/chosen.proto.min.js"></script> 
        <script src="../js/dateformat.js"></script>  
        <script>
            $(function() {
                $(".datepicker").datepicker({
                    showButtonPanel: true,
                    changeMonth: true,
                    changeYear: true,
                    yearRange: "c-90:c+5"
                });
                $( "#sortable" ).sortable();
                $( "#sortable" ).disableSelection();
            });            
            $(function() {
                $(".chzn-select").chosen();
            });
            $(function() {
                $(".chzn-select-deselect").chosen({
                    allow_single_deselect: true
                });
            });
            $(function() {
                $(".chzn-choices").chosen();
            });            
        </script> 
        <!-- jQuery tooltip -->        
        <script>
            $(function() {
                $( document ).tooltip({
                    position: {
                        my: "center bottom-15",
                        at: "center top",
                        using: function( position, feedback ) {
                            $( this ).css( position );
                            $( "<div>" )
                            .addClass( "arrow" )
                            .addClass( feedback.vertical )
                            .addClass( feedback.horizontal )
                            .appendTo( this );
                        }
                    }                    
                });
            });
        </script>        
        <script>
            $(document).ready(function() 
            { 
                $(".sortableTable").tablesorter({
                    widthFixed: true                    
                }); 
            } 
        ); 
        </script>
        <style>
            .ui-tooltip, .arrow:after {
                background: black;
                border: 2px solid white;                
            }
            .ui-tooltip {
                padding: 7px 12px;                
                color: white;
                border-radius: 5px;
                font: 12px "Helvetica Neue", Sans-Serif;                
                box-shadow: 0 0 7px black;
                opacity: 0.9;
            }
            .arrow {
                width: 70px;
                height: 16px;
                overflow: hidden;
                position: absolute;
                left: 50%;
                margin-left: -35px;                
                bottom: -16px;
            }
            .arrow.top {
                top: -16px;
                bottom: auto;
            }
            .arrow.left {
                left: 20%;
            }
            .arrow:after {
                content: "";
                position: absolute;
                left: 20px;
                top: -20px;
                width: 25px;
                height: 25px;
                box-shadow: 6px 5px 9px -9px black;
                -webkit-transform: rotate(45deg);
                -moz-transform: rotate(45deg);
                -ms-transform: rotate(45deg);
                -o-transform: rotate(45deg);
                tranform: rotate(45deg);
            }
            .arrow.top:after {
                bottom: -20px;
                top: auto;
            }
        </style>        
    </head>
    <body>
        <div id="container">              
            <table id="infoBar">
                <tr>
                    <td>                        
                        <form method="post" action="main.jsp" style="float: left; padding: 10px 5px 4px 5px; background: #ccc; margin: -10px 0 -5px 5px;">                
                            <a onclick="this.parentNode.submit()" style="cursor: pointer;"><img src="../images/home.png" style="vertical-align: middle;"/></a>
                        </form>                                                                          
                    </td>
                    <td>
                        <form method="post" action="../logout">                
                            <a onclick="this.parentNode.submit()" style="cursor: pointer;">[ <img src="../images/control-power.png" style="vertical-align: middle;"/> Kijelentkezés ]</a>
                        </form>                                               
                    </td>
                </tr>    
            </table>
            <div id="header">
                <div class="content">    
                    <ul>
                        <li class="headerLi"><a href="main.jsp">Fejlett adatbázis-rendszerek</a></li>                                               
                    </ul>                
                </div>                 
            </div>        
            <div id="subHeader">
                <div class="content">
                    <ul class="subHeaderUl">                        
                        <li><a href="password.jsp">Tanulmányi Rendszer</a></li>
                    </ul>
                    <ul class="subHeaderUl" style="display: none;">
                        <li><a href="password.jsp">Jelszóváltoztatás</a></li>
                    </ul>
                    <ul class="subHeaderUl" style="display: none;">                        
                    </ul>
                    <ul class="subHeaderUl" style="display: none;">
                        <li><a href="myHomeworks.jsp">Házi feladatok</a></li>
                        <li><a href="reportAttendance.jsp">Hiányzás bejelentése</a></li>
                    </ul>
                </div>
            </div>

            <c:if test="${errorMessage != null || param.errorMessage != null}">
                <div class="errorDiv">
                    <table>
                        <tr>
                            <td><img src="../images/exclamation.png" alt="errorExclamation" /></td>
                                <c:if test="${param.errorMessage != null}">
                                <td><h2>${param.errorMessage}</h2> </td>
                            </c:if>
                            <c:if test="${param.errorMessage == null}">
                                <td><h2>${errorMessage}</h2> </td>
                            </c:if>
                        </tr>                     
                    </table>
                </div>
            </c:if>
            <c:if test="${successMessage != null || param.successMessage != null}">
                <div class="successDiv">
                    <table>
                        <tr>
                            <td><img src="../images/accept.png" alt="accept" /></td>
                                <c:if test="${param.successMessage != null}">
                                <td><h2>${param.successMessage}</h2> </td>
                            </c:if>
                            <c:if test="${param.successMessage == null}">
                                <td><h2>${successMessage}</h2> </td>
                            </c:if>
                        </tr>                     
                    </table>
                </div>
            </c:if>

            <script>
                $("#header .content ul li").hover(function() {
                    var index = $(".headerLi").index($(this));                                                          
                    for (var i=0; i < $(".subHeaderUl").size(); i++) {                        
                        if (index == i) {
                            $(".subHeaderUl").get(i).setAttribute("style", "display:block;");                            
                        } else {
                            $(".subHeaderUl").get(i).setAttribute("style", "display:none;");
                        }
                    }                    
                });
            </script>