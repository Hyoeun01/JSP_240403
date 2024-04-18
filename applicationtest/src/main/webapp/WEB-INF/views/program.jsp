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
    <title> 프로그램 소개 | 상품투어 | 투어리스트인투어 </title>
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
            <h1><a href="/">Tourist in tour</a></h1>
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
                    <li><a href="/join">회원가입</a></li>
                </ul>
                <nav>
                    <ul class="gnb clear">
                        <li><a href="javascript:;" class="openAll1">여행정보</a>

                            <div class="gnb_depth gnb_depth2_1" style="display: none;">
                                <ul class="submenu_list">
                                    <li><a href="javascript:;">국내</a></li>
                                    <li><a href="javascript:;">해외</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll2">고객센터</a>
                            <div class="gnb_depth gnb_depth2_2" style="display: none;">
                                <ul class="submenu_list">
                                    <li><a href="/notice_list">공지사항</a></li>
                                    <li><a href="javascript:;">문의하기</a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="javascript:;" class="openAll3">상품투어</a>
                            <div class="gnb_depth gnb_depth2_3" style="display: none;">
                                <ul class="submenu_list">
                                    <li><a href="/program">프로그램 소개</a></li>
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
        <div class="location_area package">
            <div class="box_inner">
                <h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
                <p class="location">상품투어 <span class="path">/</span> 프로그램 소개</p>
                <ul class="page_menu clear">
                    <li><a href="javascript:;" class="on">프로그램 소개</a></li>
                    <li><a href="javascript:;">여행 자료</a></li>
                </ul>
            </div>
        </div>
        <!-- //location_area -->

        <!-- bodytext_area -->
        <div class="bodytext_area place_area box_inner">
            <ul class="program_list clear">
                <li>
                    <img class="img_place" src="img/img_place_01.jpg" alt="이응노 미술관">
                    <h3>이응노 미술관</h3>
                    <p class="subttl">2019.01 ~ 2019.03</p>
                    <div class="program_content">
                        <p>고암 이응노 화백의 예술세계와 작품들을 감상할 수 있다. <span class="subtxt">대전에 위치한 이응노 미술관에서는 대전과 파리, 한국과 프랑스, 아시아와 유럽의 커뮤니케이션이 일어난다.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_02.jpg" alt="김유정문학촌">
                    <h3>김유정문학촌</h3>
                    <p class="subttl">2019.01 ~ 2019.03</p>
                    <div class="program_content">
                        <p>강원도 춘천시에서는 김유정이 우리나라 제일의 소설가인 것처럼 정성을 다해 김유정 문학촌을 꾸몄다. <span class="subtxt">기념관은 물론이고 소설의 마지막 장면을 실제크기 동상으로 재연하기도 했다. 우리를 감동시킨 많은 다른 문학가, 예술인들도 해당 지자체에서 성의를 다해 기렸으면 하는 바램이다.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>
                </li>
                <li>
                    <img class="img_place" src="img/img_place_03.jpg" alt="책과 인쇄 박물관">
                    <h3>책과 인쇄 박물관</h3>
                    <p class="subttl">2019.01 ~ 2019.03</p>
                    <div class="program_content">
                        <p>생각보다 작은 공간이지만 활자가 문명에 끼친 어마어마한 영향력이 초판본들에서 느껴진다. <span class="subtxt">박물만 볼 수 있는 것이 아니라 아직까지도 그 시절에 인쇄 과정을 손수 체험 할 수 있는 시간을 제공하고 있다.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_04.jpg" alt="백사실 현통사">
                    <h3>백사실 현통사</h3>
                    <p class="subttl">2018.11 ~ 2018.12</p>
                    <div class="program_content">
                        <p>서울 종로구 부암동에서는 주택가에서 길 하나만 건너 들어가면 깨끗하고 맑은 계곡을 걸을 수 있다. <span class="subtxt">백사실 가는 길에 사찰도 있어주지만 더 들어가면 조선후기 별서 백석동천을 만날 수 있다.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_05.jpg" alt="통영국제음악당">
                    <h3>통영국제음악당</h3>
                    <p class="subttl">2019.01 ~ 2019.03</p>
                    <div class="program_content">
                        <p>작곡가 윤이상을 기리는 음악당으로 소리와 함께 수려한 경치도 즐길 수 있다. <span class="subtxt">봄과 가을에 통영국제음악제가 열리며 가을에는 윤이상국제음악콩쿠르가 열린다.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_06.jpg" alt="아침고요수목원">
                    <h3>아침고요수목원</h3>
                    <p class="subttl">2019.01 ~ 2019.02</p>
                    <div class="program_content">
                        <p>경기도 가평군 축령산에는 조용한 아침의 나라의 아기자기한 정원이 있다. <span class="subtxt">너무 거대하지 않으면서도 수려한 산림욕장을 원한다면 아침고요수목원을 산책하라.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_07.jpg" alt="제천 리솜포레스트">
                    <h3>제천 리솜포레스트</h3>
                    <p class="subttl">2019.02 ~ 2019.03</p>
                    <div class="program_content">
                        <p>제천에는 촬영지 이상의 자연 친화 팬션이 있다. <span class="subtxt">리솜 포레스트는 아름드리 피톤치드 정글속에 모던한 빌라 하나씩을 꽂아 놓은 듯한 구조를 하고 있다.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li><li>
                <img class="img_place" src="img/img_place_08.jpg" alt="정동진">
                <h3>정동진</h3>
                <p class="subttl">2019.04 ~ 2019.05</p>
                <div class="program_content">
                    <p>동해 바다를 가장 가까운 코스로 가고 싶다면 역시 정동진. <span class="subtxt">정동진역은 세계에서 가장 바닷가에 가까운 기차역으로 기네스북에 등재되어 있다고 한다.</span></p>
                </div>
                <p class="btn_more"><a href="javascript:;">더보기</a></p>

            </li>
                <li>
                    <img class="img_place" src="img/img_place_09.jpg" alt="센트럴파크">
                    <h3>센트럴파크</h3>
                    <p class="subttl">2019.04 ~ 2019.04</p>
                    <div class="program_content">
                        <p>센트럴파크는 뉴욕을 방문할 때 빼놓을 수 없는 코스이다. <span class="subtxt">여름이면 여름, 겨울이면 겨울 어느 때라도 실망시키지 않는 영화와 현실의 명소이다.</span> </p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_10.jpg" alt="석파정">
                    <h3>석파정</h3>
                    <p class="subttl">2019.06 ~ 2019.06</p>
                    <div class="program_content">
                        <p>흥선대원군 별서에 딸린 정자로서 서울미술관 내에 있다. <span class="subtxt">자연과 역사, 현대미술을 동시에 원한다면 석파정으로 오라.</span></p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_11.jpg" alt="뉴욕공립도서관">
                    <h3>뉴욕공립도서관</h3>
                    <p class="subttl">2019.07 ~ 2019.07</p>
                    <div class="program_content">
                        <p>뉴욕에는 미술관이나 박물관처럼 보이는 도서관이 있다. <span class="subtxt">외관 뿐 아니라 내부도 성이나 성당 못지 않은 중후한 멋을 뽐내는 이 곳은 주만들이 무료로 이용할 수 있는 도서관이다. </span> </p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
                <li>
                    <img class="img_place" src="img/img_place_12.jpg" alt="강천산 계곡">
                    <h3>강천산 계곡</h3>
                    <p class="subttl">2019.07 ~ 2019.08</p>
                    <div class="program_content">
                        <p>보성 녹차밭 근처에는 최초의 군립공원이 있다.<span class="subtxt">산으로 올라가는 길에는 맨발로 걸을 수 있는 황톳길이 있고 꼭대기에는 다리가 떨리는 구름다리가 있다.</span> </p>
                    </div>
                    <p class="btn_more"><a href="javascript:;">더보기</a></p>

                </li>
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