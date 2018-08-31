
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create A Idea</title>
	</head>
	<body>
	<fieldset>
	<h1>Create a new Idea</h1>
    <p><form:errors path="idea.*"/></p>
    <form:form method="POST" action="/createidea" modelAttribute="newidea">
        <p>
            <form:label path="ideaname">Course Name:</form:label>
            <form:errors path="ideaname"/>
            <form:input path="ideaname"/>
        </p>
       	<form:input type="hidden" path="creator" value="${user.name}"/>
        <input type="submit" value="Create"/>
    </form:form>
	</fieldset>