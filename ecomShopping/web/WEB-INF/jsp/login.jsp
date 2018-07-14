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
    <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</head>

<body>

    <div class="top-name">
        <h1> <span class="logo-color">eCom</span>Shopping</h1>
    </div>
    <div id='cssmenu'>
        <ul>
            <li ><a href='<%= request.getContextPath() %>'><span>Home</span></a></li>
            <li ><a href='<%= request.getContextPath() %>/products'><span>Products</span></a></li>
            <li ><a href='<%= request.getContextPath() %>/cart'><span>Cart</span></a></li>
            <li class='active last'><a href='<%= request.getContextPath() %>/account'><span>Account</span></a></li>
        </ul>
    </div>

    <div class="container">

        <h4 class="page-subtitle"> Sign in to your account </h4>

        <div class="sign-container">
            <% String username = (String) request.getAttribute("username"); %>
            <% String isChecked = (String) request.getAttribute("isChecked"); %>
            <form method="post"  action="login">
                <label for="username" class="sr-only">Email address</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" value="<c:out value='${username}'/>" required autofocus>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                <div class="checkbox">
                    <label><input type="checkbox" name="remember" value="remember" <c:out value='${isChecked}'/>> Remember me </label>
                </div>
                <button class="btn btn-dark" type="submit">Sign in</button>
            </form>

        </div>


    </div>

</body>
</html>
