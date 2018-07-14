<%--
  Created by IntelliJ IDEA.
  User: mohammed
  Date: 7/12/18
  Time: 2:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>eComShopping</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="top-name">
        <h1> <span class="logo-color">eCom</span>Shopping</h1>
    </div>
    <div id='cssmenu'>
        <ul>
            <li class='active'><a href='<%= request.getContextPath() %>'><span>Home</span></a></li>
            <li><a href='<%= request.getContextPath() %>/products'><span>Products</span></a></li>
            <li><a href='<%= request.getContextPath() %>/cart'><span>Cart</span></a></li>
            <li class='last'><a href='<%= request.getContextPath() %>/account'><span>Account</span></a></li>
        </ul>
    </div>


    <div class="container">

        <div class="homepage-content">
            <p class="homepage-description"><span class="logo-color">eCom</span>Shopping your electronic online store</p>
            <img src="https://i.imgur.com/UPu16GN.jpg" height="300px" alt="computer">
        </div>


    </div>

    <div class="footer">
        eComShopping &copy; 2018
    </div>

</body>
</html>
