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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
    <h1>eComShopping</h1>
    <c:if test="${sessionScope.username != null}">
        <a href="<%= request.getContextPath() %>/logout" class="btn btn-dark logout-btn">Logout</a>
    </c:if>
</div>

<div class="container">

    <h2 class="page-title">Welcome to eComShopping!</h2>

    <h4 class="page-subtitle"> Specialized in the most beautiful cube products </h4>


    <div class="welcome-page-section">
        <div>
            <img src="http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png" alt="cube" width="400px">
        </div>
        <div>
            <a href="<%= request.getContextPath() %>/products" class="btn btn-dark btn-lg">Check the latest products</a>
        </div>
    </div>




</div>

</body>
</html>
