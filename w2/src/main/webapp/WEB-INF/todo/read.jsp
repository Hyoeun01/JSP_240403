<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 11.
  Time: 오후 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<%--등록과 비슷하지만 tno를 보여주거나 form태그대신 아래쪽에 링크를 통해 수정/삭제 기능으로 이동하는 기능이 있음--%>
<div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
</div>
<div>
    <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
    <a herf="/todo/list">List</a>
</div>
</body>
</html>
