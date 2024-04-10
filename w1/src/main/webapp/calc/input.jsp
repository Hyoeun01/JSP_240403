<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 9.
  Time: 오후 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--form 태그 : 입력양식 . 사용자가 입력하는 내용들을 전송하는 용도
input태그 : 문자나 숫자 등을 입력. type 속성을 이용해서 숫자, 문자, 시간 등 입력가능
button태그 : 화면에 버튼을 보여주고 form태그의 전송을 목적으로 하는 경우 type="submit" 지정
SEND라고 적힌 버튼을 클릭시 form태그 내에 사용자가 입력한 값을 input태그의 name속성값과 함께 전송한다.--%>
<form action="calcResult.jsp" method="post">
    <input type ="number" name = "num1">
    <input type ="number" name = "num2">
    <button type = "submit">SEND</button>
</form>
</body>
<%-- 프로젝트 실행 후 브라우저에 /calc/input.jsp 입력시 화면을 GET방식으로 볼 수 있다--%>
</html>
