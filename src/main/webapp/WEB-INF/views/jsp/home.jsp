<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring MVC with REST Demo</title>
    <style type="text/css">
        table.result th {
            background-color: lightgray;
        }

        table.result {
            border: 1px solid;
        }
    </style>
</head>
<body>
<form:form action="/findProduct" modelAttribute="product" method="post">
    <table>
        <tr>
            <td>Product ID</td>
            <td><form:input path="productId"/></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><form:button value="Search">Search</form:button></td>
        </tr>
    </table>
    <br>
    <c:if test="${not empty productList}">
        <table class="result">
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Price</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productType}</td>
                    <td>${product.price}</td>
                    <td>${product.status}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${NO_DATA_FOUND}">
        <h2>No Data Found !</h2>
    </c:if>
</form:form>
</body>
</html>