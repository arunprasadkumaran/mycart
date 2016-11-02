<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<spring:url value="/resources/css/login.css" var="loginCss" />
<spring:url value="/resources/js/jquery-2.2.4.js" var="jqueryJs" />
<link rel="stylesheet" type="text/css" href="${loginCss}"></link>
<script src="${jqueryJs}"></script>
</head>
<body>
	<%
		//allow access only if session exists
		String user = null;
		if (session.getAttribute("UserName") == null) {
			response.sendRedirect("login");
		} else
			user = (String) session.getAttribute("UserName");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("UserName"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
	%>
	<div class="landing-page">
		<center>
			Welcome
			<c:choose>
				<c:when test="${UserName !=null}">
  					 ${UserName}  |  <a href="logout">Log out</a>
				</c:when>
				<c:when test="${UserName ==null}">
 					 Guest  |  <a href="login">Login</a>
				</c:when>
			</c:choose>
		</center>
		<br> <br> <a href="browse">Browse Books</a>
	</div>
</body>
</html>