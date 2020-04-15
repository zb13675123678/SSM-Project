<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/13
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>详情-${freshGoods.goodName}</title>
    <!--/tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script>
        /*addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }*/
    </script>
    <!--//tags -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/font-awesome.css" rel="stylesheet">
    <!--pop-up-box-->
    <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
    <!--//pop-up-box-->
    <!-- price range -->
    <link rel="stylesheet" type="text/css" href="css/jquery-ui1.css">
    <!-- flexslider -->
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
    <!-- fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800"
          rel="stylesheet">
    <style type="text/css">
        a{white-space: nowrap; overflow: hidden;display:block;}
    </style>
</head>

<body>

<jsp:include page="top.jsp"/>

<!-- page -->
<div class="services-breadcrumb">
    <div class="agile_inner_breadcrumb">
        <div class="container">
            <ul class="w3_short">
                <li>
                    <a href="index.jsp">主页</a>
                    <%--<i>|</i>--%>
                </li>
                <li><a href="#">丨Cart</a> </li>
            </ul>
        </div>

    </div>
</div>
<!-- //page -->

<div>
    <c:if test="${cart != null}">

        <div class="occasion-cart">
            <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">

            </div>
        </div>

        <form action="payment" method="post">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th><input type="checkbox" id="all" onclick="checkAllCart(this.checked)"></th>
                    <th>pdid</th>
                    <th>pname</th>
                    <th>price</th>
                    <th>discount</th>
                    <th>image</th>
                    <th>count</th>
                    <th>gtid</th>
                    <th>summary</th>
                </tr>

                <C:forEach items="${cart}" var="ct">
                    <tr>
                        <th><input type="checkbox" name="one" onclick="checkOneCart()" value="${ct.key}"></th>
                        <td>&nbsp;${ct.key}</td>
                        <td>&nbsp;${ct.value.freshGoods.goodName}</td>
                        <td>&nbsp;${ct.value.freshGoods.price}</td>
                        <td>&nbsp;${ct.value.freshGoods.discount}%</td>
                        <td>&nbsp;${ct.value.freshGoods.img}</td>
                        <td>&nbsp;${ct.value.count}</td>
                        <td>&nbsp;${ct.value.freshGoods.gtid}</td>
                        <td>&nbsp;${ct.value.count * ct.value.freshGoods.price * ct.value.freshGoods.discount / 100}</td>
                    </tr>
                </C:forEach>
            </table>
            <input type="hidden" name="fdid" value="${freshGoods.fdid}"/>
            <input type="submit" value="pay" class="button btn-primary btn-success btn-lg" style="width: 200px;" />
        </form>

    </c:if>

</div>

<jsp:include page="bottom.jsp"/>

<script>
    /*全选框点击事件:多选框属性要与所有当选框属性同步*/
    function checkAllCart(v) {

        var chOne = document.getElementsByName("one");

        for (var i = 0; i < chOne.length; i++){
            chOne[i].checked = v ;
        }

    }
    /*单选框点击事件：单选框只要一个未选中，多选框就为false*/
    /*               单选框只要全部选中，多选框就为true*/
    function checkOneCart() {
        var chOne =document.getElementsByName("one");

        for(var i = 0; i < chOne.length; i++){
            if(!chOne[i].checked){
                document.getElementById("all").checked = false;
                break;
            }
        }

        var flag = true;
        for(var i = 0; i < chOne.length; i++){
            if(!chOne[i].checked){
                 flag = false;
                 break;
            }
        }
        if(flag){
            document.getElementById("all").checked = true;
        }
    }
</script>

<script src="js/jquery-2.1.4.min.js"></script>
<!-- //jquery -->
<script>
    $(function () {
        $("#signIn").click(function () {
            var name=$("#username1").val();
            var pass=$("#password1").val();
            $.post("/userLogin",{username:name,password:pass},function (data) {
                if (data == "true"){
                    location.href="index.jsp";
                }
            });
        });

        function goodType() {
            $.get("/getGoodTypes", function (data) {
                var option = "<option value=''>所有种类</option>"
                for (var key in data){
                    option += "<option value='"+data[key].gtid+"'>"+data[key].gtname+"</option>"
                }
                $(".goodType").append($(option));
            });
        }
        //初始化下拉框
        goodType();
        //获取被选中的种类
        $(".goodType").on("change",function () {
            var gtid = $(this).find(":selected").val();
            console.log(gtid);
            location.href = "getFreshGoods?gtid="+gtid;
        });

    });
</script>
<!-- popup modal (for signin & signup)-->
<script src="js/jquery.magnific-popup.js"></script>
<script>
    $(document).ready(function () {
        $('.popup-with-zoom-anim').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>
<!-- Large modal -->
<!-- <script>
    $('#').modal('show');
</script> -->
<!-- //popup modal (for signin & signup)-->

<!-- cart-js -->
<script src="js/minicart.js"></script>
<script>
    paypalm.minicartk.render(); //use only unique class names other than paypal1.minicart1.Also Replace same class name in css and minicart.min.js

    paypalm.minicartk.cart.on('checkout', function (evt) {
        var items = this.items(),
            len = items.length,
            total = 0,
            i;

        // Count the number of each item in the cart
        for (i = 0; i < len; i++) {
            total += items[i].get('quantity');
        }

        if (total < 3) {
            alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
            evt.preventDefault();
        }
    });
</script>
<!-- //cart-js -->

<!-- password-script -->
<script>
    /* window.onload = function () {
         document.getElementById("password1").onchange = validatePassword;
         document.getElementById("password2").onchange = validatePassword;
     }

     function validatePassword() {
         var pass2 = document.getElementById("password2").value;
         var pass1 = document.getElementById("password1").value;
         if (pass1 != pass2)
             document.getElementById("password2").setCustomValidity("Passwords Don't Match");
         else
             document.getElementById("password2").setCustomValidity('');
         //empty string means no validation error
     }*/
</script>
<!-- //password-script -->

<!-- smoothscroll -->
<script src="js/SmoothScroll.min.js"></script>
<!-- //smoothscroll -->

<!-- start-smooth-scrolling -->
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script>
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();

            $('html,body').animate({
                scrollTop: $(this.hash).offset().top
            }, 1000);
        });
    });
</script>
<!-- //end-smooth-scrolling -->

<!-- smooth-scrolling-of-move-up -->
<script>
    $(document).ready(function () {
        /*
        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
        };
        */
        $().UItoTop({
            easingType: 'easeOutQuart'
        });

    });
</script>
<!-- //smooth-scrolling-of-move-up -->

<!-- imagezoom -->
<script src="js/imagezoom.js"></script>
<!-- //imagezoom -->

<!-- FlexSlider -->
<script src="js/jquery.flexslider.js"></script>
<script>
    // Can also be used with $(document).ready()
    $(window).load(function () {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>
<!-- //FlexSlider-->

<!-- flexisel (for special offers) -->
<script src="js/jquery.flexisel.js"></script>
<script>
    $.get("/getGoodDetailsAll",function (data) {
        for(var key in data){
            var li = $("<li></li>");
            var divParent = $("<div class='w3l-specilamk'></div>");
            var divChild1 = $("<div class='speioffer-agile'></div>");
            var divChild2 = $("<div class='product-name-w3l'></div>");
            //第一个子div
            var imgs = data[key].img.split("-");
            var img = $("<a href='getGoodDetailsByFdid2?fdid="+data[key].fdid+"'><img src='img/"+imgs[0]+".jpg' style='width: 150px;height: 150px;white-space:nowrap; overflow:hidden;' /></a>");
            divChild1.append(img);

            //第二个子div
            var h4 = $("<h4><a href='getGoodDetailsByFdid2?fdid="+data[key].fdid+"'>"+data[key].goodName+"</a></h4>");
            divChild2.append(h4);
            var divGrandson1 =$("<div class='w3l-pricehkj'></div>");
            //divGrandson1中的标签
            var h6 = $("<h6>$"+data[key].price*data[key].discount/100+"</h6>");
            var p = $("<p>原价 $"+data[key].price+"</p>")
            divGrandson1.append(h6);
            divGrandson1.append(p);
            var divGrandson2 = $("<div class='snipcart-details top_brand_home_details item_add single-item hvr-outline-out'></div>");
            //divGrandson2中的标签
            var form =$("<form action='#' method='post'></form>");
            var fieldset=$("<fieldset></fieldset>");

            var input1 =$('<input type="hidden" name="cmd" value="_cart" />');
            var input2 =$('<input type="hidden" name="add" value="1" />');
            var input3 =$('<input type="hidden" name="business" value=" " />');
            var input4 =$('<input type="hidden" name="item_name" value="'+data[key].name+'" />');
            var input5 =$('<input type="hidden" name="amount" value="'+data[key].price+'" />');
            var input6 =$('<input type="hidden" name="currency_code" value="USD" />');
            var input7 =$('<input type="hidden" name="return" value=" " />');
            var input8 =$('<input type="hidden" name="cancel_return" value=" " />');
            var input9 =$('<input type="submit" name="submit" value="加入购物车" class="button" />');

            fieldset.append(input1);
            fieldset.append(input2);
            fieldset.append(input3);
            fieldset.append(input4);
            fieldset.append(input5);
            fieldset.append(input6);
            fieldset.append(input7);
            fieldset.append(input8);
            fieldset.append(input9);

            form.append(fieldset);
            divGrandson2.append(form);

            /*divChild2.append(divGrandson2);
            divChild1.append(details);
            divParent.append(divChild1);
            divParent.append(divChild2);
            li.append(divParent);*!/*/
            divParent.append(divChild1);
            divChild2.append(divGrandson1);
            divChild2.append(divGrandson2);
            divParent.append(divChild2);
            li.append(divParent);
            $(".specialOffers").append(li);
        }
        lunxun();
    })

</script>
<script>
    function lunxun() {
        $("#flexiselDemo1").flexisel({
            visibleItems: 3,
            animationSpeed: 1000,
            autoPlay: true,
            autoPlaySpeed: 3000,
            pauseOnHover: true,
            enableResponsiveBreakpoints: true,
            responsiveBreakpoints: {
                portrait: {
                    changePoint: 480,
                    visibleItems: 1
                },
                landscape: {
                    changePoint: 640,
                    visibleItems: 2
                },
                tablet: {
                    changePoint: 768,
                    visibleItems: 2
                }
            }
        });
    }
</script>

<script>
    $(window).load(function () {
        /*  $("#flexiselDemo1").flexisel({
              visibleItems: 3,
              animationSpeed: 1000,
              autoPlay: true,
              autoPlaySpeed: 3000,
              pauseOnHover: true,
              enableResponsiveBreakpoints: true,
              responsiveBreakpoints: {
                  portrait: {
                      changePoint: 480,
                      visibleItems: 1
                  },
                  landscape: {
                      changePoint: 640,
                      visibleItems: 2
                  },
                  tablet: {
                      changePoint: 768,
                      visibleItems: 2
                  }
              }
          });*/

    });
</script>
<!-- //flexisel (for special offers) -->

<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- //js-files -->

</body>

</html>