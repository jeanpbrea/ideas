<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>The Great Ideas ....we think</title>
	</head>
	<body>
	<h1>Welcome, <c:out value="${user.name}"/></h1>
	<p><a href="/logout">Logout</a></p>
	<p>All the Ideas:</p>
		<table>
		  <tr>
		    <th>Idea</th>
		    <th>Created by</th> 
		    <th>Likes</th>
		    <th>Action</th>
		  </tr>
		  <c:forEach var = "row" items="${ideas}">
		  <tr>
		    <td><a href="/show/${row.id}">${row.ideaname}</a></td> 
		    <td>${row.creator}</td>
		    <td></td>
		    <td><a href="/join/${row.id}"></a></td>
		  </tr>
		  </c:forEach>
		</table>
		<a href=/ideas/new>Create an Idea</a>
	</body>
</html>