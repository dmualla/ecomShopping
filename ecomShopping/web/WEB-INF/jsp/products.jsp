
<%--
  Created by IntelliJ IDEA.
  User: mohammed
  Date: 7/11/18
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="models.Product" %>

<html>

<head>
    <title>eComShopping</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</head>

<body>

    <div class="header">
        <h1>eComShopping</h1>
        <a href="<%= request.getContextPath() %>/cart" class="btn btn-dark cart-btn">Cart</a>
        <c:if test="${sessionScope.username != null}">
            <a href="<%= request.getContextPath() %>/logout" class="btn btn-dark logout-btn">Logout</a>
        </c:if>

    </div>
    <div class="container">
        <% List<Product> products = (List)request.getAttribute("products"); %>
        <div class="row">
            <c:forEach items="${products}" var="product">
                <div class="col-md-3 col-sm-2 col-xs-2">
                    <div class="card">
                        <img class="card-img-top" src="<c:out value='${product.imgSrc}'/>" alt="Product Card">
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${product.name}"/></h5>
                            <p class="card-text">$<c:out value="${product.price}"/></p>

                            <c:if test="${product.inCard}">
                                <button class="btn btn-light btn-add-to-cart" value="<c:out value='${product.id}'/>" disabled>Added</button>
                            </c:if>
                            <c:if test="${!product.inCard}">
                                <button class="btn btn-info btn-add-to-cart" value="<c:out value='${product.id}'/>">Add to cart</button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</body>
</html>