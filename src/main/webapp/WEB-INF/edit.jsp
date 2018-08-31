<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit <c:out value="${idea.ideaname}"/></title>
	</head>
	<body>
	<fieldset>
	<h3>Edit <c:out value="${idea.ideaname}"/></h3>
		<p><form:errors path = "idea.*"/></p>
		<form:form method="POST" action="/edit/${idea.id}" modelAttribute="editidea">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="ideaname">Name:</form:label>
				<form:errors path="ideaname"/>
				<form:input value="${idea.ideaname}" path="ideaname"/>
			</p>
			<form:input type="hidden" path="creator" value="${user.name}"/>
			<input type="submit" value="Submit"/>
		</form:form>
	</fieldset>
	<a href="/delete/${idea.id}">Delete</a>   |     <a href="/ideas">Return to Ideas</a>
	</body>
</html>