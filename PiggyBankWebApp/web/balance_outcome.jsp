<%-- 
    Document   : balance_outcome
    Created on : 16 Apr 2024, 11:10:11 PM
    Author     : MemaniV
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Balance Outcome Page</title>
    </head>
    <body>
        <h1>Balance outcome</h1>
        <%
            Double balance = (Double)request.getAttribute("balance");
            DecimalFormat df = new DecimalFormat("R0.00");
        %>
        <p>
            Balance is <b><%=df.format(balance)%></b>.
        </p>
        <p>
            Click <a href="menu.html">here</a> to view menu or <a href="logout.html">here</a> to logout.
        </p>
    </body>
</html>
