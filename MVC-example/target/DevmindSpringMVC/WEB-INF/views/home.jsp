<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Bine ai venit in lumea Spring MVC!</h1>

<P>Timpul pe server este: ${serverTime}.</p>

<%--	acesta este un action form care inregistreaza un user name--%>
<form action="user" method="post">
	<p>Username: </p> <input type="text" name="userName">
	<p>e-mail: </p>	<input type="email" name="email">
	<p>Telefon: </p> <input type="tel" name="phone">
	<p>Data nasterii: </p>	<input type="date" name="birthDate">
	<br><br>
	<input type="submit" value="Login">
</form>
</body>
</html>