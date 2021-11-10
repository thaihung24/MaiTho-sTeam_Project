<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/fonts/icon_font/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/categoriess.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jasmine-1.3.1/jasmine.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jasmine-1.3.1/jasmine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jasmine-1.3.1/jasmine-html.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/simplePagination.css">
    
</head>

<body >
    <!-- <div class="mock-header"></div> -->
    <!-- Begin Header -->
    <header class="Header">
        <div class="Logo">
            <a href="#"> <img src="${pageContext.request.contextPath}/resource/assets/img/home/logo_200x200.png" height="150" width="150" alt="Amazing" class="reponsive"></a>
        </div>
        <div class="Menu">
            <li class="Menu__Trademark"><a href="">TRADEMARK</a>
                <ul class="Menu__Trademark__List">
                    <li class="Menu__Trademark__List__Babhabit"><a href="carteogory.html">Bad Habits</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logobadhabit.jpg" alt="" class="reponsive">
                            <li> <a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__Dirtycoins"><a href="">Dirty Coins</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodirtycoin.png" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__UnCover"><a href="">Un Cover</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/Logouncover.jpg" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__DAVIES"><a href="">DAVIES</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodavies.jpg" alt="" class="reponsive">
                            <li><a href="products?action=Tshirt">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="Menu__Store"><a href="">STORE</a>
                <ul class="Menu__Store__List">
                    <li> <a>North</a>
                        <ul class="List">
                            <li><a href="products?action=display_products">Hà Nội</a></li>
                        </ul>
                    </li>
                    <li><a>Central</a>
                        <ul class="List">
                            <li><a href="">Huế</a></li>
                            <li><a href="products?action=display_products">Đà Nẵng</a></li>
                        </ul>
                    </li>
                    <li><a>Southern</a>
                        <ul class="List">
                            <li><a href="products?action=display_products?">Hồ Chí Minh</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="Menu__Contact"><a href="">CONTACT</a></li>
        </div>

            <input type="hidden" class="JSON" name="JSON" value='${sessionScope.memberJSON}'>

        <div class="Other">

            <!-- user -->

            <!-- member -->
            <div class="member">
                <div class="member__avt">
                    <!-- <img src=""
                                alt="avt" srcset=""> -->
                <img class="js__memberimg" src="${pageContext.request.contextPath}/resource/assets/img/member/error/member.png" alt="avt" srcset=""> 
                </div>
                <div class="member__name">
                    <span class="js__membername">Guest</span>
                </div>
            </div>

            <!-- end user -->
            <!--search icon -->
            <li class="Other__item Other__search">
                <input class="Other__search__input" placeholder="search" type="text">
                <i class="fa fa-search"></i>

            </li>
            <!--user icon -->
            <li class="Other__item Other__User">          
                <a class="fa fa-user js__icon--user"  href="${pageContext.request.contextPath}/member"></a>
                <div class="js__icon--edit">        
                        <a class="fas fa-user-cog" href="${pageContext.request.contextPath}/edit"></a> 
                </div>
                    
            </li>
            <!--cart icon -->
            <li class="Other__item Other__shoopping-bag"    >
                <a class="fa fa-shopping-cart" href="${pageContext.request.contextPath}/cart"></a>
            </li>
        </div>
    </header>
    <section class="category">
        <div class="category-right ">
            <div class="category-right-top row">
                <div class="category-right-top-item">
                    <p id="show-product">${show}</p>
                </div>
                <div  class="category-right-top-item">
                    <select size="1" name="" id="gender" onchange="genderChanged(this)">
                        <option value="" id="">Lọc</option>
                        <option value="all" id="all">Tất cả sản phẩm</option>
                        <option value="T-SHIRT" id="T-SHIRT">T-Shirt</option>
                        <option value="SHIRT" id="SHIRT">SHIRT</a></option>
                    </select>
                </div>
                <div  class="category-right-top-item">
                    <select size="1" name="" id="">
                        <option value="" >Sắp xếp </option>
                        <option value="" >Cao đến thấp</option>
                        <option value="" >Thấp đến cao</option>
                    </select>
                </div>
            </div>  
        </div>
        <ul class="products">
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <c:forEach var="product" items="${products}">
                    <li>
                        <div class="product-item">
                            <div class="product-top">
                                <a href="" class="product-thumb">
                                    <img src="${pageContext.request.contextPath}/resource/assets/img/product/${product.brand}/${product.code}">
                                </a>
                                <a href="" class="buy-now">MUA NGAY</a>
                            </div>
                            
                        </div>
                       <div class="product-info">
                           <a href=""class="product-cat">${product.classify}</a>
                           <a href="" class="product-name">${product.desc} </a>
                           <div class="product-price"><span>${product.price}<sub>đ</sub></span></div>
                       </div>
                    </li>
                   
                </c:forEach>
        </ul> 
    </section>
    <div id="pagination-container"></div>
    <!-------------------app---------------->
    <footer>
        <section class="app-container">
            <p>Tải ứng dụng SARK</p>
            <div class="app-google">
                <a href=""> <img src="image/appstore.png"></a>
                <a href=""> <img src="image/googleplay.png"></a>
            </div>
            <p id="demo">Nhận bản tin SARK</p>
            <li> <input placeholder="Email" type="text">
                <i class="fa fa-arrow-left" aria-current="true"></i>
            </li>
            </div>
        </section>
        <!-------------------footer---------------->
        <div class="footer-top">
            <li>
                <a href="https://www.facebook.com/76storee"> <i class="fa fa-facebook-square" aria-hidden="true"></i></li>
            <li><a href="">Liên Hệ</a></li>
            <li><a href="">Tuyển Dụng</a></li>
            <li><a href="">Giới Thiệu</a></li>
            <li>
                <a class="fa fa-instagram" href="https://www.instagram.com/hi_hungw/?fbclid=IwAR2rgxF_ygWB_qOWBVH2qe1bKdH2uPfFD3HdQ9lnuDyq_GX00t2HxIxbFJM"></a>
            </li>
            <li>
                <a class="fa fa-youtube" href=""></a>
            </li>
        </div>
        <div class="information">
            <p>Shop bán hàng Online với số đăng ký kinh doanh: 0929468214 <br> Địa chỉ đăng ký: S5.02 VinHome Grand Park ,Đường Nguyễn Xiển , P.Long Thạnh Mỹ, Q.9, TP.HCM, Việt Nam - 092946821 <br> Đặt hàng online : <span>0929468214.</span>
            </p>
        </div>
        <div class="footer-bottom">
            <div>@SARK</div>
        </div>
    </footer>
</body>
    <script
    src="https://code.jquery.com/jquery-3.6.0.js"
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
    crossorigin="anonymous"></script>
    <script
    src="https://code.jquery.com/jquery-3.6.0.js"
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
    crossorigin="anonymous">
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/jquery.simplePagination.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/spec/SpecHelper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/spec/SimplePaginationSpec.js"></script>
    <script>
        $(function() {
        var items = $(".products li");
            var numItems = items.length;
            var perPage = 8;

            items.slice(perPage).hide();

            $('#pagination-container').pagination({
                items: numItems,
                itemsOnPage: perPage,
                prevText: "&laquo;",
                nextText: "&raquo;",
                onPageClick: function (pageNumber) {
                    var showFrom = perPage * (pageNumber - 1);
                    var showTo = showFrom + perPage;
                    items.hide().slice(showFrom, showTo).show();
                }
            });
            //$.pagination(container, options);

            container.addHook('beforeInit', function () {
            window.console && console.log('beforeInit...');
            });
            container.pagination(options);

            container.addHook('beforePageOnClick', function () {
            window.console && console.log('beforePageOnClick...');
            //return false
            });
        })
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/Redirect.js"></script>
</html>