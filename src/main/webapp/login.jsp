<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<spring:url value="/resources/css/login.css" var="loginCss" />
		<spring:url value="/resources/js/jquery-2.2.4.js" var="jqueryJs" />
		<link rel="stylesheet" type="text/css" href="${loginCss}"></link>
		<script src="${jqueryJs}"></script>
		<script>
			$(document).ready(function() {
				$('.message a').click(function() {
					$('form').animate({
						height : "toggle",
						opacity : "toggle"
					}, "slow");
				});
			});
		</script>
	</head>
	<body>
		<div class="login-page">
			<div class="form">
				<form:form id="loginForm" name="loginForm" class="login-form"
					method="post" action="login" modelAttribute="loginBean">
					<p class="message">	${message} </p>
					<form:input id="userName" name="userName" path="userName" />
					<form:password id="password" name="password" path="password" />
					<button type="submit">login</button>
					<p class="message">
						Not registered? <a href="#">Create an account</a>
					</p>
				</form:form>
			</div>
		</div>
	</body>
</html>