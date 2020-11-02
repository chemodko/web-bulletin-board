<%@ page import="java.util.*" %>
<%@ page import="java.util.Map.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <style> 
            <%@ include file="../css/style.css"%>
        </style>
    </head>
    <body bgcolor="#293241", class="text"> 
        <h1> Board page! </h1>
        <%
            Map<String, String> adverts = (Map<String, String>)request.getAttribute("adverts");
            for (Entry<String, String> entry : adverts.entrySet()) {
                out.print("<p class=\"head\">" + entry.getKey() + "</p>\n");
                String cur = "cur";
                if ((String)request.getSession().getAttribute("name") != null) {
                    cur = (String)request.getSession().getAttribute("name");
                }
                if (entry.getKey().contains(cur)) {
                    out.print("<a href=\"/lab15/board/delete/" + entry.getKey() + "\">Delete</a>\n");
                }
                out.print("<p class=\"advert\">" + entry.getValue() + "</p>\n");
            }
            if (request.getSession().getAttribute("name") != null) {
                out.print("<form method=POST action=/lab15/board/add>\n");
                out.print("<input type=\"text\" placeholder=\"Advert: \" name=\"advert\">\n");
                out.print("<input type=\"submit\" value=\"add\" class=\"b1\">\n");
                out.print("</form>\n");
                out.print("<h3><a href=\"/lab15/logout\">Logout</a></h3>\n");
            }
            else {
                out.print("<h3><a href=\"/lab15/login\">Login</a></h3>\n");
            }
        %>
    </body>
</html>