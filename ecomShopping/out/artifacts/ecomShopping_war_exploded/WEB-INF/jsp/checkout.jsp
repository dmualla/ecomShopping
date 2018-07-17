<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="models.Product" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="ctm" uri="http://title.example" %>
<html>
<head>
    <ctm:title title="Checkout" />
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
        <h4 class="page-subtitle">Purchase summary</h4>
        <div class="checkout-summary">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Reference</th>
                        <th scope="col">Name</th>
                        <th scope="col" class="right-column">Price</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Product> products = (List)request.getAttribute("products"); %>
                    <% String total_price = (String) request.getAttribute("total_price"); %>
                    <c:forEach items="${products}" var="product" varStatus="loop">
                        <tr>
                            <td scope="row"><c:out value='${loop.index+1}'/></td>
                            <td><c:out value='${product.id}'/></td>
                            <td><c:out value='${product.name}'/></td>
                            <td class="right-column">$<c:out value='${product.price}'/>.00</td>
                        </tr>
                    </c:forEach>
                    <tr class="total-row">
                        <td scope="row" colspan="3">Total</td>
                        <td class="right-column">$<c:out value='${total_price}'/>.00</td>
                    </tr>

                </tbody>
            </table>
        </div>
        <div class="checkout-summary">
            <form action="checkout" method="post">

            <h4 class="page-subtitle">Shipping Address</h4>

            <div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Address" required/>
                </div>
                <div class="form-group">
                    <label for="country">Country</label>
                    <input type="text" class="form-control" id="country" name="country" placeholder="Country" required />
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <input type="text" class="form-control" id="city" name="city" placeholder="City" required />
                </div>
                <div class="form-group">
                    <label for="zip">Zip Code</label>
                    <input type="text" class="form-control" id="zip" name="zip" placeholder="Zip Code" required />
                </div>
            </div>

            <h4 class="page-subtitle">Payment details</h4>

            <div>

                <div class="form-group">
                    <label for="card_holder">Name on Card</label>
                    <input type="text" class="form-control" id="card_holder"  name="card_holder" placeholder="Ex. John Doe" required/>
                </div>
                <div class="form-group">
                    <label for="card_number">Card Number</label>
                    <input type="text" class="form-control" id="card_number" name="card_number" placeholder="Ex. 1234 56789 5123456" required/>
                </div>
                <div class="form-group">
                    <label for="billing_address">Billing Address</label>
                    <input type="text" class="form-control" id="billing_address" name="billing_address" placeholder="Billing Address" required/>
                </div>
                <div class="form-group">
                    <label for="cvc">CVC</label>
                    <input type="text" class="form-control" id="cvc" name="cvc" placeholder="CVC code" pattern="^[0-9]{3}$" required/>
                </div>
                <div class="form-group">
                    <label for="expiration">Expiration</label>
                    <input type="text" class="form-control" id="expiration" name="expiration" placeholder="Ex. 06/22" pattern="^(0|1)?[0-9]{1}\/[0-9]{2}$" required />
                </div>
            </div>

            <div class="submit-checkout-btn">
                <input type="submit" class="btn btn-dark btn-lg" value="Checkout" />
            </div>

        </form>
        </div>
    </div>

    <ctm:footer/>
</body>
</html>
