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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
    <!-- Form for selecting stock symbol -->
    <form id="consolidationForm" action="${pageContext.request.contextPath}/StockConsolidationController" method="GET" class="form">
        <label for="consolidationSymbol">Symbol:</label>
        <select id="consolidationSymbol" name="symbol" onchange="document.getElementById('consolidationForm').submit();">
            <option value="" disabled selected>Select a symbol</option>
            <c:forEach var="symbol" items="${symbols}">
                <option value="${symbol}" ${symbol eq selectedSymbol ? 'selected' : ''}>${symbol}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="route" value="view" />
    </form>

    <h1>Stock Consolidation for: ${symbol}</h1>
    <!-- Button to download PDF -->
    <form action="${pageContext.request.contextPath}/StockConsolidationController" method="GET" class="pdf-form">
        <input type="hidden" name="route" value="pdf">
        <input type="hidden" name="symbol" value="${symbol}">
        <button type="submit" class="open-modal-btn">Download PDF</button>
    </form>

    <!-- Summary Purchases (Always Visible) -->
    <div class="table-container">
        <table>
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
                <td><fmt:formatNumber value="${totalUnitCost}" type="number" maxFractionDigits="2" /></td>
            </tr>
            <tr>
                <th>% Gain/Loss</th>
                <td class="<c:if test='${unitPercentage >= 0}'>green</c:if><c:if test='${unitPercentage < 0}'>red</c:if>">
                    <fmt:formatNumber value="${unitPercentage}" type="number" maxFractionDigits="2" />%
                </td>
            </tr>
            <tr>
                <th>$ Gain/Loss</th>
                <td class="<c:if test='${totalGain >= 0}'>green</c:if><c:if test='${totalGain < 0}'>red</c:if>">
                    <fmt:formatNumber value="${totalGain}" type="number" maxFractionDigits="2" />
                </td>
            </tr>
        </table>
    </div>

    <!-- Tabs for switching between content -->
    <div class="tabs">
        <div id="summaryTab" class="tab active" onclick="switchTab('summary')">Summary Purchases</div>
        <div id="performanceTab" class="tab" onclick="switchTab('performance')">Stock Performance Over Time</div>
    </div>

    <!-- Summary Purchases Tab (Tab Content) -->
    <div id="summary" class="tab-content active">
        <div class="table-container">
            <h2>Summary Purchases</h2>
            <table>
                <thead>
                    <tr>
                        <th>Purchase Date</th>
                        <th>Stock</th>
                        <th>Purchase Price (USD)</th>
                        <th>Quantity</th>
                        <th>USD Purchase</th>
                        <th>Gain/Loss (USD)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty stocks}">
                            <tr><td colspan="6" class="no-data">No stock purchases recorded.</td></tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="stock" items="${stocks}">
                                <tr>
                                    <td><fmt:formatDate value="${stock.purchaseDate}" pattern="dd-MM-yyyy" /></td>
                                    <td>${stock.symbol}</td>
                                    <td>${stock.purchasePrice}</td>
                                    <td>${stock.quantity}</td>
                                    <td>${stock.purchasePrice * stock.quantity}</td>
                                    <td class="<c:if test='${(stock.currentPrice - stock.purchasePrice) * stock.quantity >= 0}'>green</c:if><c:if test='${(stock.currentPrice - stock.purchasePrice) * stock.quantity < 0}'>red</c:if>">
                                        <fmt:formatNumber value="${(stock.currentPrice - stock.purchasePrice) * stock.quantity}" type="number" maxFractionDigits="2" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>

<!-- Stock Performance Over Time Tab -->
<div id="performance" class="tab-content">
    <h2>Stock Performance Over Time</h2>
    <canvas id="performanceChart" width="600" height="400"></canvas>
    <script>
        const ctx = document.getElementById('performanceChart').getContext('2d');
        const labels = [];
        const purchasePrices = [];
        const currentPrices = [];
        const totalPerformance = []; // New array for total performance over time

        let cumulativePurchase = 0;
        let cumulativeCurrent = 0;

        <c:forEach var="stock" items="${stocks}">
            // Prepare labels for each date
            labels.push("<fmt:formatDate value='${stock.purchaseDate}' pattern='dd-MM-yyyy' />");

            // Calculate cumulative purchase and current prices for each stock
            cumulativePurchase += ${stock.purchasePrice * stock.quantity};
            cumulativeCurrent += ${stock.currentPrice * stock.quantity};

            purchasePrices.push(cumulativePurchase);
            currentPrices.push(cumulativeCurrent);

            // Add the total performance data (current - purchase)
            totalPerformance.push(cumulativeCurrent - cumulativePurchase);
        </c:forEach>

        const performanceChart = new Chart(ctx, {
            type: 'line',  // Line chart to show the performance trend
            data: {
                labels: labels,
                datasets: [
                    {
                        label: 'Cumulative Purchase Price (USD)', // More descriptive label
                        data: purchasePrices,
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 2,
                        fill: false,
                        pointStyle: 'circle', // Add points to make it clearer
                        pointRadius: 5
                    },
                    {
                        label: 'Cumulative Current Price (USD)', // More descriptive label
                        data: currentPrices,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 2,
                        fill: false,
                        pointStyle: 'circle',
                        pointRadius: 5
                    },
                    {
                        label: 'Total Performance (USD)', // More descriptive label
                        data: totalPerformance,
                        backgroundColor: 'rgba(255, 159, 64, 0.2)',
                        borderColor: 'rgba(255, 159, 64, 1)',
                        borderWidth: 2,
                        fill: false,
                        pointStyle: 'circle',
                        pointRadius: 5
                    }
                ]
            },
            options: {
                responsive: true,
                scales: {
                    x: {
                        title: {
                            display: true,
                            text: 'Purchase Date' // Clear label for X-axis
                        }
                    },
                    y: {
                        beginAtZero: false, // Adjust based on your data range
                        title: {
                            display: true,
                            text: 'Value in USD' // Clear label for Y-axis
                        }
                    }
                },
                plugins: {
                    legend: {
                        position: 'top', // Position of the legend for clarity
                    }
                }
            }
        });
    </script>
</div>

<script>
    function switchTab(tabName) {
        // Hide all tab contents
        document.querySelectorAll('.tab-content').forEach(tabContent => {
            tabContent.classList.remove('active');
        });

        // Show the selected tab content
        document.getElementById(tabName).classList.add('active');

        // Update tab styles
        document.querySelectorAll('.tab').forEach(tab => {
            tab.classList.remove('active');
        });
        document.querySelector(`#${tabName}Tab`).classList.add('active');
    }

    // Ensure the correct tab is active after form submission (when a symbol is selected)
    document.addEventListener("DOMContentLoaded", function() {
        if("${symbol}" != "") {
            switchTab('summary');  // By default, show 'Summary Purchases'
        }
    });
</script>

</body>
</html>
