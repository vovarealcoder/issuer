<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vova
  Date: 10.05.19
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${currentUser}</p>
<c:if test="${not empty currentUser.name}">
    <p> Hello ${currentUser.name}</p>
</c:if>
<c:if test="${empty currentUser.name}">
    <p> wrong auth</p>
</c:if>
</body>
</html>
