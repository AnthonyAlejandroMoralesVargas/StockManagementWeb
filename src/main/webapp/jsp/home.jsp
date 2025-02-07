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
<header class="navbar">
    <div class="nav-logo">Stock Management</div>
    <ul class="nav-links">
        <li><a href="${pageContext.request.contextPath}/RegisterStockController?route=list">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/StockConsolidationController?route=enter">Stock Consolidation</a></li>
    </ul>
</header>

<div class="container">
<h2>Stock Register</h2>
    <button class="open-modal-btn" onclick="document.getElementById('registerModal').style.display='flex'">Register New Stock</button>

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

    <div class="table-container">
        <table>
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
                <c:choose>
                    <c:when test="${empty stocks}">
                        <tr><td colspan="10" class="no-data">No stocks registered yet.</td></tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="stock" items="${stocks}">
                            <tr>
                                <td>${stock.symbol}</td>
                                <td>${stock.quantity}</td>
                                <td><fmt:formatDate value="${stock.purchaseDate}" pattern="dd-MM-yyyy" /></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.purchasePrice != null}">
                                            <fmt:formatNumber value="${stock.purchasePrice}" type="number" maxFractionDigits="2" />
                                        </c:when>
                                        <c:otherwise>0.00</c:otherwise>
                                    </c:choose>
                                </td>
                                <td><fmt:formatDate value="${stock.currentDate}" pattern="dd-MM-yyyy" /></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.currentPrice != null}">
                                            <fmt:formatNumber value="${stock.currentPrice}" type="number" maxFractionDigits="2" />
                                        </c:when>
                                        <c:otherwise>0.00</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.unitGain != null}">
                                            <fmt:formatNumber value="${stock.unitGain}" type="number" maxFractionDigits="2" />
                                        </c:when>
                                        <c:otherwise>0.00</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.unitPercentage != null}">
                                            <fmt:formatNumber value="${stock.unitPercentage}" type="number" maxFractionDigits="2" />
                                        </c:when>
                                        <c:otherwise>0.00</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.totalBalance != null}">
                                            <fmt:formatNumber value="${stock.totalBalance}" type="number" maxFractionDigits="2" />
                                        </c:when>
                                        <c:otherwise>0.00</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${stock.totalGain != null}">
                                            <fmt:formatNumber value="${stock.totalGain}" type="number" maxFractionDigits="2" />
                                        </c:when>
                                        <c:otherwise>0.00</c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal for Registration -->
<div id="registerModal" class="modal">
    <div class="modal-content">
        <span class="close-modal" onclick="document.getElementById('registerModal').style.display='none'">&times;</span>
        <h2>Register New Stock</h2>
            <form action="${pageContext.request.contextPath}/RegisterStockController?route=add" method="POST">
            <label for="symbol">Symbol:</label>
            <input type="text" id="symbol" name="symbol" required>

            <label for="purchasePrice">Purchase price (USD):</label>
            <input type="number" id="purchasePrice" name="purchasePrice" step="0.01" required>

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>

            <label for="purchaseDate">Purchase Date:</label>
            <input type="date" id="purchaseDate" name="purchaseDate" required>

            <input type="submit" value="Save">
        </form>
    </div>
</div>

<!-- Message Notification -->
<div id="messageModal" class="message-modal">
    <div class="notification-content">${messageControl}</div>
</div>

<script>
    window.onload = function () {
        const message = '${messageControl}';
        if (message.trim()) {
            const modal = document.getElementById('messageModal');
            modal.style.display = 'block';
            setTimeout(function () {
                modal.style.opacity = '0';
                setTimeout(() => modal.style.display = 'none', 500);
            }, 3000);
        }
    };
</script>

</body>
</html>
