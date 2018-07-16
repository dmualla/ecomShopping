/*
description: Project CS 472
author: The invincibles
*/

(function(){
    "use strict";

    function addToCart() {
        var self = this;
        self.innerHTML = "Adding <img src='https://i.imgur.com/5P3kadY.gif' width='20px'/>";

        $.post("/ecomshopping/products", {"id": self.value})
            .done(ajaxSuccessAddToCart.bind(self))
            .fail(ajaxFailureAddToCart.bind(self));
    }

    function removeFromCart() {
        var self = this;
        self.innerHTML = "Removing <img src='https://i.imgur.com/5P3kadY.gif' width='20px'/>";

        $.post("/ecomshopping/cart", {"id": self.value})
            .done(ajaxSuccessRemoveFromCart.bind(self))
            .fail(ajaxFailureRomoveFromCart.bind(self));
    }

    function checkCart(e) {
        if($('#selected-products').children().length == 0) {
            swal("Empty Cart", "Before checkout you need at least 1 product in your cart", "warning");
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
        //productsParentNode.removeChild(elem);
        $(elem).hide('slow', function(){
            productsParentNode.removeChild(elem);
            var child_length = productsParentNode.children.length;
            if( child_length > 1) {
                $(".cart-size").html(child_length+" products ");
            }else{
                $(".cart-size").html(child_length+" product");
            }

            $("#empty-cart").css("display", "none");
            if( child_length == 0) {
                $("#empty-cart").css("display", "block");
            }
        });
    }
    
    function updateProfile() {
        var fullname = document.getElementById("fullname").value;
        var email = document.getElementById("email").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var id = document.getElementById("id").value;

        if(fullname.length == 0 || email.length == 0 || username.length == 0 || password.length == 0 ) {
            swal("Notice", "All the fields are required", "warning");
        }else
            if(!email.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/))  {
                swal("Error", "Email address is not valid!", "error");
            }else{
                var data = { id: id, "fullname": fullname, "email": email, "username": username, "password": password  }

                $.post("/ecomshopping/account", data)
                    .done(ajaxSuccessUpdateProfile)
                    .fail(ajaxFailureUpdateProfile);
        }
    }

    function verifySignUpInputs(e) {

        var fullname = document.getElementById("fullname").value;
        var email = document.getElementById("email").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        if(fullname.length == 0 || email.length == 0 || username.length == 0 || password.length == 0 ) {
            swal("Notice", "All the fields are required", "warning");
            e.preventDefault();
        }else
        if(!email.match(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/))  {
            swal("Error", "Email address is not valid!", "error");
            e.preventDefault();
        }
    }

    function ajaxSuccessUpdateProfile() {
        document.getElementById("password").value = "";
        swal("Perfect!", "Your profile is updated!", "success");
    }

    function ajaxFailureUpdateProfile() {
        document.getElementById("password").value = "";
        swal("Sorry", "Something went wrong", "error");
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

    function ajaxSuccessSearchProduct(data) {
        var elem = document.getElementById("products-list");
        $( "#products-list" ).empty();
        var data = JSON.parse(data);

        if(data.length  == 0) {
            $( "#products-list" ).append("<div class='no-result-found'>" +
                "<div class='no-result-found-text'> Sorry! no result found</div>"+
                "<img src='https://i.imgur.com/coOzBxj.png' alt='no result' class='no-result-found-img' /></div>")
        } else {
            for (var i=0; i<data.length; i++) {
                var element = ''+
                    '<div class="col-md-3 col-sm-2 col-xs-2">' +
                    '<div class="card">' +
                    '<img class="card-img-top" src="'+ data[i].imgSrc +'" alt="Product Card">' +
                    '<div class="card-body">'+
                    '<h5 class="card-title"><a href="/ecomshopping/product?id=' + data[i].id + '">'+ data[i].name +'</a></h5>' +
                    '<p class="card-text">$'+ data[i].price +'</p>';
                if(!data[i].inCard) {
                    element += '<button class="btn btn-info btn-add-to-cart" value="' + data[i].id + '">Add to cart</button>';
                }else{
                    element += '<button class="btn btn-light btn-add-to-cart" value="' + data[i].id + '" disabled>Added</button>';
                }
                element +=    '</div>' +
                    '</div>' +
                    '</div>';
                $( "#products-list" ).append(element);
            }
            $(".btn-add-to-cart").click(addToCart);
        }
        $("#search-btn").text(" Search");
    }

    function ajaxFailureSearchProduct() {
        console.log("An Error Occured!");
    }

    function searchForProduct() {
        var productName = document.getElementById("search").value;
        var search = productName.replace(/\s/g, '');
        if(search.length  > 0) {
            $("#search-btn").html(" Searching <img src='https://i.imgur.com/5P3kadY.gif' width='20px'/>");
            $.post("/ecomshopping/product", {"productName": productName})
                .done(ajaxSuccessSearchProduct)
                .fail(ajaxFailureSearchProduct);
        }else{
            swal("Notice", "Please type the name of the product first!", "warning");
        }
    }

    $(function () {
        $(".btn-add-to-cart").click(addToCart);
        $("#checkout").click(checkCart);
        $(".btn-remove-from-cart").click(removeFromCart);
        $("#search-btn").click(searchForProduct);
        $("#update-profile").click(updateProfile);
        $("#signup-btn").click(verifySignUpInputs);
        if($('#selected-products').children().length == 0) {
            $("#empty-cart").css("display", "block");
        }
    });

})();