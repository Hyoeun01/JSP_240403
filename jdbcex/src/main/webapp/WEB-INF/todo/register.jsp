<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 11.
  Time: 오전 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "/todo/register" method="post">
    <div>
        <%--placeholder: 칸 안에 힌트 추가하기--%>
        <input type = "text" name ="title" placeholder="INSERT TITLE">
    </div>
    <div>
        <input type ="date" name="dueDate">
    </div>
    <div>
        <button type="reset">RESET</button>
        <button type="submit">SUBMIT</button>
    </div>
</form>

</body>
</html>
