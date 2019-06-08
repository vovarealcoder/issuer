<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login V1</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="<c:url value="/resources/images/icons/favicon.ico"/>"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/animate/animate.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/css-hamburgers/hamburgers.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/select2/select2.min.css"/>">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="<c:url value="/resources/images/img-01.png"/>" alt="IMG">
            </div>

            <%--@elvariable id="user" type="ru.issuer.dao.model.Users"--%>
            <form:form method="post" modelAttribute="user" action="login1" class="login100-form validate-form">
					<span class="login100-form-title">
						<spring:message code="memberLogin"/>
					</span>
                <form:errors path="login" cssClass="alert-validate"/>

                <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                    <spring:message code="login" var="loginMessage"/>
                    <form:input class="input100" path="login" placeholder="${loginMessage}"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>
                <form:errors path="password" cssClass="alert-validate"/>
                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <spring:message code="password" var="passMessage"/>
                    <form:password class="input100" path="password" placeholder="${passMessage}"/>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <spring:message code="submit" var="submitMessage"/>
                    <input type="submit" class="login100-form-btn" value="${submitMessage}"/>

                </div>

                <div class="text-center p-t-12">
						<span class="txt1">
							<spring:message code="forgot"/>
						</span>
                    <a class="txt2" href="#">
                        <spring:message code="loginPass"/>
                    </a>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="#">
                        <spring:message code="register"/>
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form:form>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="<c:url value="/resources/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/vendor/bootstrap/js/popper.js"/>"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/vendor/select2/select2.min.js"/>"></script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/vendor/tilt/tilt.jquery.min.js"/>"></script>
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="<c:url value="/resources/js/main.js"/>"></script>

</body>
</html>