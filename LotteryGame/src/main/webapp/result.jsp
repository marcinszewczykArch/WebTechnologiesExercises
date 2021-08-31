<%@ page import="pl.javastart.lotterygame.LotteryResult" %>
<%@ page import="pl.javastart.lotterygame.LotteryDrawing" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 48602
  Date: 05.08.2021
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Wyniki losowania</title>
</head>
<body>
<%
    LotteryResult lotteryResult = (LotteryResult) request.getAttribute("result");
    LotteryDrawing userInput = lotteryResult.getUserInput();
    LotteryDrawing randomNumbers = lotteryResult.getRandomNumbers();
    ArrayList<Integer> matchedNumbersArray = lotteryResult.getMatchedNumbersArray();

%>
<fieldset id="frame">
<h1>
    <%="Wynik losowania: [" + randomNumbers.getN1() + ", " + randomNumbers.getN2() + ", " + randomNumbers.getN3() + ", " + randomNumbers.getN4() + ", " + randomNumbers.getN5() + ", " + randomNumbers.getN6() + "]" %>
    <br><br>
    <%="Twoje liczby: [" + userInput.getN1() + ", " + userInput.getN2() + ", " + userInput.getN3() + ", " + userInput.getN4() + ", " + userInput.getN5() + ", " + userInput.getN6() + "]" %>
    <br><br>
    <%="Liczba trafień: " + matchedNumbersArray.size()%>
    <br><br>
    <%="Trafione liczby: " + lotteryResult.printMatchedNumbers()%>
</h1>
</fieldset>

</body>
</html>
