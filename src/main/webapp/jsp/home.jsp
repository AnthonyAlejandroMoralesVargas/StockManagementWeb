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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css"> <!-- Vincula tu archivo CSS si es necesario -->
</head>
<body>
<h1>Stock Management</h1>

<!-- Sección para mostrar mensajes de éxito o error -->
<c:if test="${not empty success}">
    <p style="color: green;">${success}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<!-- Formulario para registrar una nueva acción -->
<h2>Registrar Nueva Acción</h2>
<form action="${pageContext.request.contextPath}/RegisterStockController?route=add" method="POST">

    <label for="symbol">Nombre de la Acción:</label>
    <input type="text" id="symbol" name="symbol" required>
    <br><br>

    <label for="purchasePrice">Precio de Compra (USD):</label>
    <input type="number" id="purchasePrice" name="purchasePrice" step="0.01" required>
    <br><br>

    <label for="quantity">Cantidad:</label>
    <input type="number" id="quantity" name="quantity" required>
    <br><br>

    <label for="purchaseDate">Fecha de Compra:</label>
    <input type="date" id="purchaseDate" name="purchaseDate" required>
    <br><br>

    <input type="submit" value="Registrar Compra">
</form>

<!-- Tabla para mostrar el listado de acciones registradas -->
<h2>Resumen de Compras de Acciones</h2>
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
            <td>${stock.unitGain}</td>
            <td>${stock.unitPercentage}</td>
            <td>${stock.totalBalance}</td>
            <td>${stock.totalGain}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
