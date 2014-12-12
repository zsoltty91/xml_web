<%-- 
    Document   : footer
    Created on : 2014.11.30., 15:34:58
    Author     : zsolti
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
