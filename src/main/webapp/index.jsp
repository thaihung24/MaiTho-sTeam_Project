<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%-- Loc change --%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>SARK</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/fonts/icon_font/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/home.css">
</head>

<body>
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
                            <li><a href="">T-SHIRT</a></li>
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
                            <li><a href="">Hà Nội</a></li>
                        </ul>
                    </li>
                    <li><a>Central</a>
                        <ul class="List">
                            <li><a href="">Huế</a></li>
                            <li><a href="">Đà Nẵng</a></li>
                        </ul>
                    </li>
                    <li><a>Southern</a>
                        <ul class="List">
                            <li><a href="">Hồ Chí Minh</a></li>
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
            <li class="Other__item Other__shoopping-bag">
                <a class="fa fa-shopping-cart" href="${pageContext.request.contextPath}/cart"></a>
            </li>
        </div>
    </header>

    <section id="Slide">
        <div class="row">
            <div class="row-1">
                <div class="row-1-col-1">
                    <div class="aspect-ratio-169">
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/badhabit/slideshow_1.jpg" alt=""></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide2.jpg" alt=""></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/badhabit/slideshow_3.jpg" alt=""></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/slideshow2.jpg" alt=""></a>
                    </div>
                    <div class="dot-container">
                        <div class="dot active"></div>
                        <div class="dot"></div>
                        <div class="dot"></div>
                        <div class="dot"></div>
                    </div>
                </div>
            </div>
            <div class="row-2">
                <div class="row-2-item">
                    <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/badhabit/slideshow_1.jpg" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/sp1.PNG" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/sp2.PNG" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/dirtycoin/sp1.PNG" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/dirtycoin/sp2.PNG" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href=""><img src="${pageContext.request.contextPath}/resource/assets/img/home/bobui/slideshow2.jpg" alt="" class="row-2-item"></a>
                </div>
            </div>
            <div class="row-3"></div>
        </div>
    </section>
    <!-------------------app---------------->
    <footer>
        <section class="app-container">
            <p>Tải ứng dụng SARK</p>
            <div class="app-google">
                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/appstore.png"></a>
                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/googleplay.png"></a>
            </div>
            <p>Nhận bản tin SARK</p>
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
    <%-- <input type="hidden" class="JSON" name="JSON" value="${member.avt}"> --%>




</body>
<script>
    /* const header=document.querySelector("header")
                                                                                    window.addEventListener("scroll",function(){
                                                                                        x=window.pageYOffset
                                                                                        if(x>0)
                                                                                        {
                                                                                            header.classList.add("sticky")
                                                                                        }
                                                                                        else{
                                                                                            header.classList.remove("sticky")
                                                                                        }
                                                                                    })
                                                                                    */

    const imgPosition = document.querySelectorAll(".aspect-ratio-169 a img")
    const imgContainer = document.querySelector(".aspect-ratio-169")
    const dotItem = document.querySelectorAll(".dot")
    let imgNumber = imgPosition.length
    index = 0
        /*console.log(imgPosition)*/
    imgPosition.forEach(function(${pageContext.request.contextPath}/resource/assets/img/home,index) {
        ${pageContext.request.contextPath}/resource/assets/img/home.style.left = index * 100 + "%"
        dotItem[index].addEventListener("click", function() {
            slider(index)
        })
    })

    function imgSlide() {
        index++;
        console.log(index)
        if (index >= imgNumber) {
            index = 0;
        }
        imgContainer.style.left = "-" + index * 100 + "%"
        slider(index)

    }

    function slider(index) {
        imgContainer.style.left = "-" + index * 100 + "%"
        const dotActive = document.querySelector('.active')
        dotActive.classList.remove("active")
        dotItem[index].classList.add("active")
    }
    setInterval(imgSlide, 5000)
</script>
<!-- NEW -->
<script>
    //container
    const memberAvt = document.querySelector(".member__avt");
    const memberName = document.querySelector(".member__name");
    //JSON
    const dataJSONE = document.querySelector(".JSON");
    const dataJSON = JSON.parse(dataJSONE.value);
    //Icon change
    const userE = document.querySelector(".Other__User")
    const iconUser =  document.querySelector(".js__icon--user");
    const iconEdit =  document.querySelector(".js__icon--edit");
    if(${sessionScope.memberJSON eq null}){
        iconUser.style.display ="block";
    }
    else{
        iconUser.style.display ="none";
        iconEdit.style.display = "block";
    }
    //
    const hideImg = document.querySelector(".js__memberimg");
    const hideName = document.querySelector(".js__membername")
    hideImg.style.display = "none";
    hideName.style.display ="none";
    //handle data
    function getInfo(username,avt) {
        let myAvt = document.createElement("img");
        let myName = document.createElement("span");
        myAvt.setAttribute("src", avt);
        let uname = username || "guest";
        myName.innerHTML ="<span>"+uname+"</span>";
        memberAvt.appendChild(myAvt);
        memberName.appendChild(myName);
    }
    // get data
    const {username,avt} = dataJSON;
    if(username != undefined || avt != undefined){
        getInfo(username,avt);
    }
    else{
        hideImg.style.display = "block";
        hideName.style.display ="inline-block";
    }

</script>

</html>