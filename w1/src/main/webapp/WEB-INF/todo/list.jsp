<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 10.
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%-- <%@ : jsp에서 자바코드를 사용할수있게 하는것 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>

<html>
<head>
    <title>Title</title>
  <style>
    table, td, tr {
      border: 1px solid black;
      border-collapse: collapse;
    }
  </style>
</head>
<body>
<h1>List Page</h1>
<%-- ${ } : EL 표현식
${list} --%>
<table>
  <tr>
    <th>TNO</th>
    <th>TITLE</th>
    <th>DUEDATE</th>
    <th>FINISHED</th>
  </tr>

  <%--  JSTL에서의 반복문 처리는 <c:forEach>를 이용하고, 배열이나 리스트를 처리할 수 있다 --%>
  <c:forEach var="dto" items="${list}">
    <tr>
      <td>${dto.getTno()}</td>
      <td>${dto.getTitle()}</td>
      <td>${dto.getDueDate()}</td>
      <td>${dto.isFinished()}</td>
    </tr>
  </c:forEach>
</table>

<%--4/9 내용--%>
<%--list.size() : 리스트의 개수--%>
<%-- test="조건식" --%>
<c:if test="${list.size() % 2 == 0}">
  짝수
</c:if>
<c:if test="${list.size() % 2 == 1}">
  홀수
</c:if>

<c:choose>
  <c:when test="${list.size() % 2 == 0}">
    짝수
  </c:when>
  <c:otherwise>
    홀수
  </c:otherwise>
</c:choose>

<%--반복문이나 제어문을 처리할 때 새로운 변수가 필요하면 set을 사용한다--%>
<c:set var ="target" value = "10"></c:set>
<ul>
  <c:forEach var="num" begin="1" end="10">
    <c:if test="${num == target}">
      num is target
    </c:if>
  </c:forEach>
</ul>

</body>
</html>
