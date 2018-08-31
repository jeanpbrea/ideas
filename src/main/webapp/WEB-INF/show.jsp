<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> <c:out value="${idea.ideaname}"/></title>
	</head>
	<body>
		<h1><c:out value="${idea.ideaname}"/></h1>
		<p>Created By: <c:out value="${idea.creator}"/></p>
		<h2>Users who liked your idea:</h2>
		<table>
		  <tr>
		    <th>Name</th>
		  </tr>
		  <c:forEach items="${ideas}" var="i">
		  <tr>
		    <td><c:out value="${ideas.name}"/></td>
		  </c:forEach>
		</table>
		<a href="/edit/${idea.id}">Edit Idea</a>  |   <a href="/ideas">Return to Ideas</a>
	</body>
</html>