<%@ page import="models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="ctm" uri="http://title.example" %>
<html>
<head>
    <ctm:title title="Product Details" />
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</head>

<body>

    <div class="top-name">
        <h1> <span class="logo-color">eCom</span>Shopping</h1>
    </div>
    <div id='cssmenu' class="align-center">
        <ul>
            <li ><a href='<%= request.getContextPath() %>'><span>Home</span></a></li>
            <li class='active'><a href='<%= request.getContextPath() %>/products'><span>Products</span></a></li>
            <li ><a href='<%= request.getContextPath() %>/cart'><span>Cart</span></a></li>
            <c:if test="${sessionScope.username != null}"  var="sessionExist">
                <li class='last has-sub'>
                    <a href='<%= request.getContextPath() %>/account'>
                        <span>Account</span>
                    </a>
                    <ul>
                        <li><a href="<%= request.getContextPath() %>/account">PROFILE</a></li>
                        <li><a href="<%= request.getContextPath() %>/logout">LOGOUT</a></li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${!sessionExist}">
                <li class='last'>
                    <a href='<%= request.getContextPath() %>/account'>
                        <span>Account</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>

    <div class="container">

        <% Product product = (Product)request.getAttribute("product"); %>

        <div>
            <div class="product-img-container">
                <img src="<c:out value='${product.imgSrc}'/>" alt="product">
            </div>
            <div class="product-desc-container">
                <h3>Product Details</h3>
                <div>
                    Reference: <span><c:out value='${product.id}'/></span>
                </div>
                <div>
                    Name: <span><c:out value='${product.name}'/></span>
                </div>
                <div>
                    Price: <span>$ <c:out value='${product.price}'/></span>
                </div>
                <div>
                    Description: <span> <c:out value='${product.description}'/></span>
                </div>
                <div class="add-to-card-container">
                    <c:if test="${product.inCard}">
                        <button class="btn btn-light btn-add-to-cart" value="<c:out value='${product.id}'/>" disabled>Added</button>
                    </c:if>
                    <c:if test="${!product.inCard}">
                        <button class="btn btn-info btn-add-to-cart" value="<c:out value='${product.id}'/>">Add to cart</button>
                    </c:if>
                </div>
            </div>
        </div>

    </div>

    <ctm:footer/>

</body>
</html>
