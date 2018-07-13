<%--
  Created by IntelliJ IDEA.
  User: mohammed
  Date: 7/12/18
  Time: 2:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="models.Product" %>
<%@ page import="java.util.List" %>
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
        <a href="<%= request.getContextPath() %>/products" class="btn btn-dark menu-btn2">Products</a>
        <a href="<%= request.getContextPath() %>/cart" class="btn btn-dark menu-btn1">Cart</a>
        <c:if test="${sessionScope.username != null}">
            <a href="<%= request.getContextPath() %>/logout" class="btn btn-dark logout-btn">Logout</a>
        </c:if>
    </div>

    <div class="container">

        <h2 class="page-title">Checkout</h2>

        <h4 class="page-subtitle">Purchase summary</h4>

        <div class="purchase-summary">
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

        <form action="checkout" method="post">

            <h4 class="page-subtitle">Shipping Address</h4>

            <div class="checkout-section">
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

            <div class="checkout-section">

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

        <p class="checkout-note">** We'll never share your data with anyone else **</p>

    </div>


</body>
</html>
