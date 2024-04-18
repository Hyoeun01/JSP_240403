<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 17.
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko"><head>
    <title> 로그인 | 투어리스트인투어 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="css/common.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.smooth-scroll.min.js"></script>
    <!--[if lte IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/placeholders.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        // 현재 페이지에만 적용
        $(document).ready(function(){
            $('.switch').click(function(){			// 로그인 유지 작동
                $(this).toggleClass("switchOn");
                if($('#autologin').val() === 'on'){
                    $('#autologin').val('off');
                }else{
                    $('#autologin').val('on');
                }
            });
            $('.quick_area').hide();				// 우측 빠른 실행 메뉴 숨김
        });
    </script>
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap" class="s_point">

    <div id="container">

        <!-- bodytext_area -->
        <form action="/login" method="POST">
            <div class="bodytext_area box_inner">
                <!-- login-wrap -->
                <div class="login_wrap">
                    <h1 class="loginTit"><a href="/"><img src="img/tit_login.png" alt="TOURIST IN TOUR"></a></h1>
                    <ul class="login_list">
                        <li><input type="text" name="email1" size="32"></li>
                        <li><input type="password" name="member_pw" size="32"></li>
                        <li><button type="submit" class="btn_srch">로그인</button></li>
                        <input type="hidden" id="autologin" value="off">
                    </ul>

                    <div class="btnonoff_line">
                        <div class="switch"></div>
                        <p>
                            <a href="#" class="btn_onoff" onclick="return false;">로그인 유지</a>
                        </p>
                    </div>

                </div>
                <!-- //login-wrap -->
            </div>
        </form>
        <!-- //bodytext_area -->

    </div>
    <!-- //container -->

    <footer>
        <div class="foot_area box_inner">
            <ul class="foot_list clear">
                <li><a href="javascript:;">이용약관</a></li>
                <li><a href="javascript:;">개인정보취급방침</a></li>
            </ul>
            <h2>투어리스트인투어</h2>
            <p class="addr">서울특별시 종로구 혜화동 9길 청운빌딩 5층 <span class="gubun">/</span>
                <span class="br_line">대표전화 <span class="space0">02-1234-5678</span> <span class="gubun">/</span>
					<span class="br_line">E-mail : <span class="space0"> titour@touristintour.com</span></span>
				</span>
            </p>
            <p class="copy box_inner">Copyright(c) TouristInTour all right reserved</p>
            <ul class="snslink clear">
                <li><a href="javascript:;">blog</a></li>
                <li><a href="javascript:;">facebook</a></li>
                <li><a href="javascript:;">instargram</a></li>
            </ul>
        </div>
    </footer>

</div>
<!-- //wrap -->



</body></html>