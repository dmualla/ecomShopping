/*
lab13
description: JSP & EL
author: mohammed
*/

(function(){
    "use strict";

    function addToCart() {

        var self = this;
        self.innerHTML = "Adding <img src='http://images.vivara.com.br/Stores/Vivara3/Others/lazyLoadImage.gif' width='20px'/>";

        $.post("/ecomshopping/products", {"id": self.value})
            .done(ajaxSuccessAddToCart.bind(self))
            .fail(ajaxFailureAddToCart.bind(self));
    }

    function removeFromCart() {
        var self = this;
        self.innerHTML = "Removing <img src='http://images.vivara.com.br/Stores/Vivara3/Others/lazyLoadImage.gif' width='20px'/>";

        $.post("/ecomshopping/cart", {"id": self.value})
            .done(ajaxSuccessRemoveFromCart.bind(self))
            .fail(ajaxFailureRomoveFromCart.bind(self));
    }

    function checkCart(e) {
        console.log($('#selected-products').children().length);
        if($('#selected-products').children().length == 0) {
            alert("Before checkout you need to have at least 1 product in your shopping cart!");
            e.preventDefault();
        }
    }

    function findAncestor (el, cls) {
        while ((el = el.parentElement) && !el.classList.contains(cls));
        return el;
    }

    function ajaxSuccessRemoveFromCart() {
        var elem = findAncestor(this, "col-md-3");
        var productsParentNode = elem.parentNode;
        productsParentNode.removeChild(elem);
        var child_length = productsParentNode.children.length;
        if( child_length > 1) {
            $(".cart-size").html(child_length+" products ");
        }else{
            $(".cart-size").html(child_length+" product");
        }

        console.log("success");
    }

    function ajaxFailureRomoveFromCart() {
        this.innerHTML = "Remove";
        this.disabled = false;
    }

    function ajaxSuccessAddToCart() {
        this.innerHTML = "Added";
        this.disabled = true;
        this.className = this.className.replace(/\bbtn-info\b/g, "btn-light");
    }

    function ajaxFailureAddToCart() {
        this.innerHTML = "Add To cart";
        this.disabled = false;
    }

    $(function () {
        $(".btn-add-to-cart").click(addToCart);
        $("#checkout").click(checkCart);
        $(".btn-remove-from-cart").click(removeFromCart);
    });

})();