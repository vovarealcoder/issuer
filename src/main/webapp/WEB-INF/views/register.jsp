<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>
</head>
<body>
<%--@elvariable id="regUser" type="ru.issuer.web.model.RegisterModel"--%>
<form:form method="post" modelAttribute="regUser" action="register">
					<span class="login100-form-title">
						Member Login
					</span>


                <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                    <form:errors path="login" cssClass="alert-validate"/>
                    <form:input class="input100" path="login" placeholder="login"/>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <form:errors path="password" cssClass="alert-validate"/>
                    <form:password class="input100" path="password" placeholder="Password"/>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <form:errors path="passwordRetype" cssClass="alert-validate"/>
                    <form:password class="input100" path="passwordRetype" placeholder="passwordRetype"/>
                </div>

    <div class="wrap-input100 validate-input" data-validate="Password is required">
        <form:errors path="name" cssClass="alert-validate"/>
        <form:input class="input100" path="name" placeholder="Name"/>
    </div>

    <div class="wrap-input100 validate-input" data-validate="Password is required">
        <form:errors path="email" cssClass="alert-validate"/>
        <form:input class="input100" path="email" placeholder="EMAIL"/>
    </div>

                <div class="container-login100-form-btn">
                    <input type="submit" class="login100-form-btn" value="Register"/>

                </div>
            </form:form>


</body>
</html>