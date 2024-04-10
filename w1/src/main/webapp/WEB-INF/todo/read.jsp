<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 10.
  Time: 오후 7:03
  To change this template use File | Settings | File Templates.
--%>

<%--TodoReadController에서 보내준 TodoDTO객체를 dto라는 이름으로 받아서 EL을 통해서 출력한다--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${dto.tno}</div>
<div>${dto.title}</div>
<div>${dto.dueDate}</div>
<div>${dto.finished}</div>

</body>
</html>
