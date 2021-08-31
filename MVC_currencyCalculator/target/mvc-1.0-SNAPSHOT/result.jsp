<%@ page import="pl.javastart.mvc.currencycalc.ExchangeResult" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="pl.javastart.mvc.currencycalc.ExchangeType" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: 48602
  Date: 05.08.2021
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kalkulator walut - wynik</title>
</head>
<body>
    <%
        ExchangeResult exchangeResult = (ExchangeResult) request.getAttribute("result");
        BigDecimal base = exchangeResult.getBase();
        BigDecimal result = exchangeResult.getResult();
        ExchangeType exchangeType = exchangeResult.getExchangeType();
        BigDecimal exchangeRate = exchangeType.getExchangeRate();
        String baseCurrency = exchangeType.getBaseCurrency();
        String targetCurrency = exchangeType.getTargetCurrency();
    %>

<h2>
    <%= base + " " + baseCurrency + " to " + result + " " + targetCurrency%><br>
    <%= String.format("%s %S to %s %S", base.toString(), baseCurrency, result.toString(), targetCurrency)%><br>
</h2>


</body>
</html>
