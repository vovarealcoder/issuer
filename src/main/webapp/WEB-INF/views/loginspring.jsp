<%--
  Created by IntelliJ IDEA.
  User: vova
  Date: 20.05.19
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty error}">
    ${error}
</c:if>
<form name="login_form" method="post" action="<c:url value="/login"/>">
    <label>
        <input type="text" name="login" value=""/>
    </label>
    <label>
        <input type="password" name="password" value=""/>
    </label>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" name="submit" value="login"/>
</form>
</body>
</html>
