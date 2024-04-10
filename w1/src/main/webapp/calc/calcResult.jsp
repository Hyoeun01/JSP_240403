<%--
  Created by IntelliJ IDEA.
  User: HYOEUN
  Date: 24. 4. 10.
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>NUM1 ${param.num1}</h1>
<h1>NUM2 ${param.num2}</h1>

<h1> SUM ${Integer.parseInt(param.num1)+Integer.parseInt(param.num2)}</h1>
</body>
</html>
