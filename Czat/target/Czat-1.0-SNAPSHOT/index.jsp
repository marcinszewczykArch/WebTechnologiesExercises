<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JavaCzat</title>
<%--    <meta http-equiv="refresh" content="1">--%>
    <style>
        textarea {
            border:1px solid #999999;
            width:100%;
            height:200px;
            margin:5px 0;
            padding:3px;
        }
        input {
            border:1px solid #999999;
            width:100%;
            margin:5px 0;
            padding:3px;
        }
        #header {
            text-align: center;
        }
        /*#chat {*/
        /*    height: 200px;*/
        /*}*/
        .message-list {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        .message-list > li:nth-child(2n+1) {
            background-color: lightgrey;
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <fieldset id="header">
        <h1>Witaj na JavaCzacie!</h1>
        <p>Poniżej widzisz historię konwersacji, możesz do niej dołączyć</p>
    </fieldset>
    <fieldset id="chat">
        <c:if test="${not empty messages}">
            <ul class="message-list">
                <c:forEach var="message" items="${messages}">
                    <li><c:out value="${message}"/></li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty messages}">
            <p>Nie przesłano jeszcze żadnej wiadomości. Rozpocznij konwersację.</p>
        </c:if>
    </fieldset>
    <form action="" method="post" id="control">
        <fieldset>
                <textarea name="content" id="content" required>Twoja wiadomość</textarea>
            <br>
                <input name="sender" id="sender" value="Twoja nazwa" required>
            <br>
                <input type="submit" value="Wyślij">
        </fieldset>
    </form>
</body>
</html>