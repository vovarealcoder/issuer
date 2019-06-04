<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<p>${message}</p>
<c:forEach items="${sessionScope}" var="entry">
    ${entry.key} = ${entry.value}<br>
</c:forEach>

<p>${currentUser}</p>
<c:if test="${not empty currentUser.name}">
    <p> Hello ${currentUser.name}</p>
</c:if>
<c:if test="${empty currentUser.name}">
    <p><spring:message code="wrong"/></p>
</c:if>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" id="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
</body>
</html>
