<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StockManagementDG</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<header>
    <div class="header-buttons">
        <button onclick="window.location.href='${pageContext.request.contextPath}/RegisterStockController?route=list'">Home</button>
        <button onclick="window.location.href='${pageContext.request.contextPath}/StockConsolidationController?route=enter'">Stock Consolidation</button>
    </div>
</header>
<h1>Stock Management</h1>

<h2>Register new stock</h2>
<form action="${pageContext.request.contextPath}/RegisterStockController?route=add" method="POST">

    <label for="symbol">Symbol:</label>
    <input type="text" id="symbol" name="symbol" required>
    <br><br>

    <label for="purchasePrice">Purchase price (USD):</label>
    <input type="number" id="purchasePrice" name="purchasePrice" step="0.01" required>
    <br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" required>
    <br><br>

    <label for="purchaseDate">Purchase Date:</label>
    <input type="date" id="purchaseDate" name="purchaseDate" required>
    <br><br>

    <input type="submit" value="Save">
</form>

<h2>My stock</h2>
<form id="sortForm" action="${pageContext.request.contextPath}/RegisterStockController" method="GET">
    <label for="sortOrder">Sort by:</label>
    <select id="sortOrder" name="sort" onchange="document.getElementById('sortForm').submit()">
        <option value="default" <c:if test="${param.sort == null || param.sort == 'default'}">selected</c:if>>Default Order</option>
        <option value="name" <c:if test="${param.sort == 'name'}">selected</c:if>>Order by Name</option>
        <option value="unitGainAsc" <c:if test="${param.sort == 'unitGainAsc'}">selected</c:if>>Unit Gain Ascending</option>
        <option value="unitGainDesc" <c:if test="${param.sort == 'unitGainDesc'}">selected</c:if>>Unit Gain Descending</option>
    </select>
    <input type="hidden" name="route" value="list" />
</form>

<table border="1">
    <thead>
    <tr>
        <th>Stock Name</th>
        <th>Quantity</th>
        <th>Purchase Date</th>
        <th>Purchase Price (USD)</th>
        <th>Current Date</th>
        <th>Current Price (USD)</th>
        <th>Unit Gain (USD)</th>
        <th>Unit Percentage (%)</th>
        <th>Total Balance (USD)</th>
        <th>Total Gain (USD)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stock" items="${stocks}">
        <tr>
            <td>${stock.symbol}</td>
            <td>${stock.quantity}</td>
            <td><fmt:formatDate value="${stock.purchaseDate}" pattern="dd-MM-yyyy" /></td>
            <td>${stock.purchasePrice}</td>
            <td><fmt:formatDate value="${stock.currentDate}" pattern="dd-MM-yyyy" /></td>
            <td>${stock.currentPrice}</td>
            <td class="<c:if test='${stock.unitGain >= 0}'>green</c:if><c:if test='${stock.unitGain < 0}'>red</c:if>">${stock.unitGain} </td>
            <td class="<c:if test='${stock.unitPercentage >= 0}'>green</c:if><c:if test='${stock.unitPercentage < 0}'>red</c:if>">
                <fmt:formatNumber value="${stock.unitPercentage}" type="number" maxFractionDigits="2" />
            </td>
            <td>${stock.totalBalance}</td>
            <td class="<c:if test='${stock.totalGain >= 0}'>green</c:if><c:if test='${stock.totalGain < 0}'>red</c:if>">
                    ${stock.totalGain}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal -->
<div id="messageModal" class="modal">
    <div class="modal-content">
        <div class="modal-body">${messageControl}</div>
    </div>
</div>
<script>
    window.onload = function () {
        const message = '${messageControl}';
        if (message.trim()) {
            const modal = document.getElementById('messageModal');
            modal.style.display = 'flex';
            setTimeout(function () {
                modal.style.display = 'none';
            }, 5000);
        }
    };
</script>
</body>
</html>
