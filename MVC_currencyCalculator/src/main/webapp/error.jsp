<%--
  Created by IntelliJ IDEA.
  User: 48602
  Date: 05.08.2021
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błąd</title>
</head>
<body>
    <h2> wystąpił błąd</h2>
    <p><%=request.getAttribute("message")%></p>
    <img src="https://thumbs.dreamstime.com/b/sad-face-holding-isolated-white-background-36708154.jpg" width="400" height=auto></img>
</body>
</html>
