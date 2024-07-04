<%-- 
    Document   : deposit_outcome
    Created on : 16 Apr 2024, 10:46:08 PM
    Author     : MemaniV
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Outcome Page</title>
    </head>
    <body>
        <h1>Deposit outcome</h1>
        <%
            Double amt = (Double)request.getAttribute("amt");
            Integer numDeposits = (Integer)session.getAttribute("numDeposits");
            DecimalFormat df = new DecimalFormat("R0.00");
        %>
        <p>
            <b><%=df.format(amt)%></b> has been successfully deposited. Thus far you have made <b><%=numDeposits%></b> deposit(s).
        </p>
        <p>
            Click <a href="menu.html">here</a> to view menu or <a href="logout.html">here</a> to logout.
        </p>
    </body>
</html>
