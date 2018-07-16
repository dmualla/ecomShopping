<%@ page import="models.User" %>
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
            <li><a href='<%= request.getContextPath() %>/cart'><span>Cart</span></a></li>
            <c:if test="${sessionScope.username != null}"  var="sessionExist">
                <li class='active last has-sub'>
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
                <li class='active last'>
                    <a href='<%= request.getContextPath() %>/account'>
                        <span>Account</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>

    <div>

        <h4 class="page-subtitle"> Welcome to your account </h4>
        <% User user = (User) request.getAttribute("user"); %>

        <div class="sign-container">
                <label for="fullname" class="sr-only">Full name</label>
                <input type="text" id="fullname" name="fullname" class="form-control" placeholder="Full name"  value="<%= user.getFullName() %>" required  />
                <label for="email" class="sr-only">Email address</label>
                <input type="text" id="email" name="email" class="form-control" placeholder="Email address" value="<%= user.getEmail()%>" required  />
                <label for="username" class="sr-only">Full name</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="username" value="<%= user.getUsername() %>" required  />
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required />
                <div class="signup-note">
                    <div>* we'll never share your data with anyone else.</div>
                </div>
                <input type="hidden" id="id" name="id" value="<%= user.getId() %>" required  />
                <button class="btn btn-dark" id="update-profile">Update!</button>
        </div>

    </div>

</body>
</html>
