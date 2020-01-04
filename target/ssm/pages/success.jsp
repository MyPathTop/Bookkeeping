
<%--
  Created by IntelliJ IDEA.
  User: 李亚林
  Date: 2019/12/22
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试环境</h1>
    <c:forEach items="${userList}" var="user">
        ${user.userId}<br>
        ${user.userName}
    </c:forEach>
</body>
</html>
