<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 21.
  Time: 오전 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello, world!</title>

    <style>
        .center-float {
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <%--        <h1>Header</h1>--%>
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                                <a class="nav-link" href="#">Link</a>
                                <a class="nav-link" href="#">Features</a>
                                <a class="nav-link" href="#">Pricing</a>
                                <a class="nav-link" disabled>Disabled</a>
                            </div>
                        </div>
                    </div>
                </nav>

            </div>
        </div>
        <div class="row content">
            <%--        <h1>Content</h1>--%>
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Special title treatment</h5>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Tno</th>
                                <th scope="col">Title</th>
                                <th scope="col">Writer</th>
                                <th scope="col">DueDate</th>
                                <th scope="col">Finished</th>
                            </tr>
                            </thead>
                            <tbody>
<%--                        페이징 처리. 서버에서 전달받은 모델 인스턴스를 불러와서 화면에서 이용하기--%>
                            <c:forEach items="${responseDTO.dtoList}" var="dto">
                                <tr>
                                    <th scope="row"><c:out value="${dto.tno}"/></th>
                                    <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none"><c:out value="${dto.title}"/></a></td>
                                    <td><c:out value="${dto.writer}"/></td>
                                    <td><c:out value="${dto.dueDate}"/></td>
                                    <td><c:out value="${dto.finished}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tr></tr>
                        </table>
<%--                        페이징 부트스트랩 컴포넌트요소 넣기--%>
                        <div class="center-float">
                            <ul class="pagination flex-wrap">
                                <c:if test="${responseDTO.prev}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.start - 1}">이전</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                    <li class="page-item ${responseDTO.page == num? "active":""} "><a class="page-link" data-num ="${num}">${num}</a> </li>
                                </c:forEach>

                                <c:if test="${responseDTO.next}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.end + 1}">다음</a>
                                    </li>
                                </c:if>
                            </ul>
                            <script>
                                // pagination 클래스를 이용해서 요소 선택후 이벤트 핸들러 추가
                                document.querySelector(".pagination").addEventListener("click", function (e) { // e: event
                                    // 기본적인 기능을 방지하는 함수
                                    e.preventDefault()
                                    e.stopPropagation()

                                    const target = e.target

                                    // tagName 이 A가 아니라면 함수를나가고
                                    if (target.tagName !== 'A') {
                                        return
                                    }
                                    // tagName 이 A이면
                                    // 현재 페이지의 번호를 가지고오기
                                    const num = target.getAttribute("data-num")

                                    // 해당 페이지로 이동 > 스프링의 백엔드 서버에 호출하면 서버가 응답해서 해당페이지로 리다이렉트
                                    // pageRequestDTO에 담아서 호출하면, 서버가 PageResponseDTO에 담아서 화면에 보내고, 화면은 해당 인스턴스 이용해서 화면에 출력
                                    self.location=`/todo/list?page=\${num}` // 백틱을 이용해서 템플릿 처리
                                },false)
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">

    </div>
    <div class="row footer">
        <%--        <h1>Footer</h1>--%>
        <div class="row fixed-bottom" style="z-index:-100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>