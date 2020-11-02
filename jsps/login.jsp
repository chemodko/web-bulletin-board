<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <style> <%@ include file="../css/style.css"%> </style>
    </head>
    <body bgcolor="#293241", class="text">

        <form action="login" method="post">
            <h1> Login page! </h1>
            Name:<input type="text" name="name">
            Password:<input type="password" name="password">
            <input type="submit" value="login" class = "b1">
        </form>

        <%
            if ((String)request.getAttribute("Error") != null) {
                out.print("<h3>" + (String)request.getAttribute("Error") + "</h3>");
            }
        %>

    </body>
</html>