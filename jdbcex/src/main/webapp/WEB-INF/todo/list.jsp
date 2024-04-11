<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 11.
  Time: 오전 11:09
  To change this template use File | Settings | File Templates.

  톰캣을 실행하거나 모두배보 후에 /todo/list를 호출하면 목록 확인 가능
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo List</h1>
<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>

            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE" : "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>

</body>
</html>
