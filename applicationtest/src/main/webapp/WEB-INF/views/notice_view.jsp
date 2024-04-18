<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 17.
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko"><head>
    <title> 박물관 미션 투어 당첨자 발표 | 공지사항 | 고객센터 | 투어리스트인투어 </title>
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
</head>

<body>
<ul class="skipnavi">
    <li><a href="#container">본문내용</a></li>
</ul>
<!-- wrap -->
<div id="wrap">

    <header id="header">
        <div class="header_area box_inner clear">
            <h1><a href="index.html">Tourist in tour</a></h1>
            <p class="openMOgnb"><a href="#"><b class="hdd">메뉴열기</b> <span></span><span></span><span></span></a></p>
            <!-- header_cont -->
            <div class="header_cont">
                <ul class="util clear">
                    <c:choose>
                        <c:when test="${empty loginInfo}">
                            <li><a href="/login">로그인</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/logout">로그아웃</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li><a href="join.html">회원가입</a></li>
                </ul>
                <nav>
                    <ul class="gnb clear">
                        <li><a href="javascript:;" class="openAll1">여행정보</a>

                            <div class="gnb_depth gnb_depth2_1">
                                <ul class="submenu_list">
                                    <li><a href="javascript:;">국내</a></li>
                                    <li><a href="javascript:;">해외</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll2">고객센터</a>
                            <div class="gnb_depth gnb_depth2_2" style="display: none;">
                                <ul class="submenu_list">
                                    <li><a href="notice_list.html">공지사항</a></li>
                                    <li><a href="javascript:;">문의하기</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll3">상품투어</a>
                            <div class="gnb_depth gnb_depth2_3" style="display: none; opacity: 1;">
                                <ul class="submenu_list">
                                    <li><a href="program.html">프로그램 소개</a></li>
                                    <li><a href="javascript:;">여행자료</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll4">티켓/가이드</a>
                            <div class="gnb_depth gnb_depth2_4" style="display: none; opacity: 1;">
                                <ul class="submenu_list">
                                    <li><a href="javascript:;">항공</a></li>
                                    <li><a href="javascript:;">호텔</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>
                <p class="closePop"><a href="javascript:;">닫기</a></p>
            </div>
            <!-- //header_cont -->
        </div>
    </header>

    <div id="container">
        <!-- location_area -->
        <div class="location_area customer">
            <div class="box_inner">
                <h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
                <p class="location">고객센터 <span class="path">/</span> 공지사항</p>
                <ul class="page_menu clear">
                    <li><a href="#" class="on">공지사항</a></li>
                    <li><a href="#">문의하기</a></li>
                </ul>
            </div>
        </div>
        <!-- //location_area -->

        <!-- bodytext_area -->
        <div class="bodytext_area box_inner">
            <ul class="bbsview_list">
                <li class="bbs_title">박물관 미션 투어 응모 당첨자 발표</li>
                <li class="bbs_hit">작성일 : <span>2018.08.09</span></li>
                <li class="bbs_date">조회수 : <span>235</span></li>
                <li class="bbs_content">
                    <div class="editer_content">
                        안녕하세요. 믿을 수 있는 여행정보, 투어리스트인투어입니다.<br>
                        박물관 미션투어에 관심과 참여 감사드립니다. <br>
                        선정되신 분들도 진심으로 축하드립니다. <br>
                        앞으로도 큰 관심 부탁드리며, 메일로도 안내 예정이니 참고하시기 바랍니다. <br>
                        감사합니다. <br><br>
                        [당첨자]<br>
                        김용* kimyong***@naver.com <br>
                        인봉* in2018a***@naver.com<br>
                        예경* yyhong***@naver.com<br>
                        한진* haha***@naver.com<br>
                        박수* pky**@naver.com<br>
                        명진* mma5**@nate.com<br>
                        김영* rtfg6*@naver.com<br>
                        서영* seo20**@gmail.com<br>
                        윤소* yoon2***@naver.com<br>
                        지은* ji***@daum.net
                    </div>
                </li>
            </ul>
            <p class="btn_line txt_right">
                <a href="javascript:;" class="btn_bbs">목록</a>
            </p>
            <ul class="near_list mt20">
                <li><h4 class="prev">다음글</h4><a href="javascript:;">추석 연휴 티켓/투어 배송 및 직접 수령 안내</a></li>
                <li><h4 class="next">이전글</h4><a href="javascript:;">이번 여름 휴가 제주 갈까? 미션 투어 (여행경비 50만원 지원)</a></li>
            </ul>
        </div>
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

<h2 class="hdd">빠른 링크 : 전화 문의,카카오톡,오시는 길,꼭대기로</h2>
<div class="quick_area">
    <ul class="quick_list">
        <li><a href="tel:010-7184-4403"><h3>전화 문의</h3><p>010-1234-5678</p></a></li>
        <li><a href="javascript:;"><h3>카카오톡 <em>상담</em></h3><p>1:1상담</p></a></li>
        <li><a href="javascript:;"><h3 class="to_contact">오시는 길</h3></a></li>
    </ul>
    <p class="to_top hide"><a href="#layout0" class="s_point">TOP</a></p>
</div>



</body></html>