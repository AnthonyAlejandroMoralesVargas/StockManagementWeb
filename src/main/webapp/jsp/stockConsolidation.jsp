<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Consolidation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<header>
    <div class="header-buttons">
        <button onclick="window.location.href='${pageContext.request.contextPath}/RegisterStockController?route=list'">Home</button>
        <button onclick="window.location.href='${pageContext.request.contextPath}/StockConsolidationController?route=enter'">Stock Consolidation</button>
    </div>
</header>

<form id="consolidationForm" action="${pageContext.request.contextPath}/StockConsolidationController" method="GET">
    <label for="consolidationSymbol">Symbol:</label>
    <select id="consolidationSymbol" name="symbol" onchange="document.getElementById('consolidationForm').submit()">
        <!-- Default option to avoid sending if no symbol is selected -->
        <option value="" disabled selected>Select a symbol</option>

        <!-- List of symbols -->
        <c:forEach var="symbol" items="${symbols}">
            <option value="${symbol}">${symbol}</option>
        </c:forEach>
    </select>

    <!-- Add the 'route' parameter with value 'view' to the form -->
    <input type="hidden" name="route" value="view" />
</form>

<h1>Stock Consolidation for: ${symbol}</h1>

<table border="1">
    <tr>
        <th>Total Quantity of Stocks Purchased</th>
        <td>${totalQuantity}</td>
    </tr>
    <tr>
        <th>Total Value of Stocks Purchased (USD)</th>
        <td>${totalValue}</td>
    </tr>
    <tr>
        <th>Cost Price (USD)</th>
        <td><fmt:formatNumber value="${totalUnitCost}" type="number" maxFractionDigits="2" />
        </td>
    </tr>
    <tr>
        <th>% Gain/Loss</th>
        <td class="<c:if test='${unitPercentage >= 0}'>green</c:if><c:if test='${unitPercentage < 0}'>red</c:if>">
            <fmt:formatNumber value="${unitPercentage}" type="number" maxFractionDigits="2" />
        </td>
    </tr>
    <tr>
        <th>$ Gain/Loss</th>
        <td class="<c:if test='${totalGain >= 0}'>green</c:if><c:if test='${totalGain < 0}'>red</c:if>">
            <fmt:formatNumber value="${totalGain}" type="number" maxFractionDigits="2" />
        </td>
    </tr>
</table>

<h2>Summary purchases</h2>

<table border="1">
    <thead>
    <tr>
        <th>Purchase Date</th>
        <th>Stock</th>
        <th>Purchase Price (USD)</th>
        <th>Quantity</th>
        <th>USD Purchase</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stock" items="${stocks}">
        <tr>
            <td><fmt:formatDate value="${stock.purchaseDate}" pattern="dd-MM-yyyy" /></td>
            <td>${stock.symbol}</td>
            <td>${stock.purchasePrice}</td>
            <td>${stock.quantity}</td>
            <td>${stock.purchasePrice * stock.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>

</body>
</html>
