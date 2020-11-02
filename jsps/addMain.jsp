<html>
    <head>
        <style> <%@ include file="../css/style.css"%> </style>
    </head>
    <body bgcolor="#A9A9A9", class="text">
        <h1> Start page! </h1>
        <h3><a href="/lab15/notebook/All">All</a></h3>
        <h3><a href="/lab15/notebook/Family">Family</a></h3>
        <h3><a href="/lab15/notebook/Friends">Friends</a></h3>
        <h3><a href="/lab15/notebook/Colleagues">Colleagues</a></h3>

        <form method=GET action=/lab15/notebook/add>
            Name: <input type="text" name="name">
            Number: <input type="text" name="number">
            Group: <input type="text" name="group">
            <input type="submit" value="add" class="b1">    
        </form>

        <h3><a href="/lab15/logout">Logout</a></h3>
    </body>
</html>