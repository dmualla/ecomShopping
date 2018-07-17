<%@ page import="models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="ctm" uri="http://title.example" %>
<html>
<head>
    <ctm:title title="Cart" />
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</head>

<body>

    <div class="top-name">
        <h1> <span class="logo-color">eCom</span>Shopping</h1>
    </div>
    <div id='cssmenu' class="align-center">
        <ul>
            <li ><a href='<%= request.getContextPath() %>'><span>Home</span></a></li>
            <li ><a href='<%= request.getContextPath() %>/products'><span>Products</span></a></li>
            <li class='active'><a href='<%= request.getContextPath() %>/cart'><span>Cart</span></a></li>
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

        <% List<Product> products = (List)request.getAttribute("products"); %>

        <div>
            <div class="cart-items-number"> You have
                <c:if test="${fn:length(products) gt 1}">
                    <span class="cart-size"><%=  products.size() %> products</span>
                </c:if>
                <c:if test="${fn:length(products) <= 1}">
                    <span class="cart-size"><%= products.size() %> product</span>
                </c:if>
                in your shopping cart
            </div>
            <div class="checkout-btn-section">
                <a href="<%= request.getContextPath() %>/checkout" id="checkout">Checkout</a>
            </div>
        </div>

        <div id="empty-cart">
            <img src="https://i.imgur.com/ZWi3Mc6.png" width="400px" alt="cart empty">
        </div>
        
        <div class="row" id="selected-products">
            <c:forEach items="${products}" var="product">
                <div class="col-md-3 col-sm-2 col-xs-2">
                    <div class="card">
                        <img class="card-img-top" src="<c:out value='${product.imgSrc}'/>" alt="Product Card">
                        <div class="card-body">
                            <h5 class="card-title"><a href="<c:url value="/product"><c:param name="id" value="${product.id}" /></c:url>"><c:out value="${product.name}"/></a></h5>
                            <p class="card-text">$<c:out value="${product.price}"/></p>
                            <button class="btn btn-info btn-remove-from-cart" value="<c:out value='${product.id}'/>">Remove</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>

    <ctm:footer/>

</body>
</html>
