<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
span.error {
    color: red;
}

label.error {
    color: red;
}

input.error {
    background-color: #ffcccc;
}

div.errors {
    background-color: #ffcccc;
    border: 2px solid red;
}

</style>
</head>
<body>

	<form action="/spitter/register" method="POST">
		First Name: <input type="text" name="firstName" /><br /> Last Name: <input
			type="text" name="lastName" /><br /> Username: <input type="text"
			name="username" /><br /> Password: <input type="password"
			name="password" /><br /> <input type="submit" value="password" />
	</form>
<hr>
	<sf:form method="POST" commandName="spitter" action="/spitter/register">
    First Name: <sf:input path="firstName" />
		<br />
		  <sf:errors path="*" cssClass="error"/><br/>
		  <label for="firstName" class="error">First Name</label></br>
    Last Name: <sf:input path="lastName" />
		<br />
    Email: <sf:input path="email"/>
		<br />
    Username: <sf:input path="username" />
		<br />
    Password: <sf:password path="password" />
		<br />
		<input type="submit" value="Register" />
	</sf:form>
	
	<hr>
	<%-- <form id="spitter" action="/spitter/register" method="POST">
		First Name: <input id="firstName" name="firstName" type="text" value="J" /><br />
		<sf:errors path="firstName" cssClass="error" />	<br /> 
		Last Name: <input id="lastName" name="lastName" type="text"value="B" /><br /> 
		<sf:errors path="lastName" cssClass="error" />	<br /> 
		Email: <input id="email" name="email" type="text" value="jack" /><br /> 
		Username: <input id="username" name="username" type="text" value="jack" /><br /> 
		Password: <input id="password" name="password" type="password" value="" /><br /> 
		<input type="submit" value="Register" />
	</form>
 --%>
	
	<h1><s:message code="spittr.welcome" /></h1>
	
	

	<s:url value="/spitter/register" var="registerUrl" />
<a href="${registerUrl}">Register</a>


 <s:url value="/spitter/register" var="registerUrl" scope="request" />

<s:url value="/spittles" var="spittlesUrl">
    <s:param name="max" value="60" />
    <s:param name="count" value="20" />
</s:url>

<a href="${spittlesUrl}">spittlesUrl</a>

<s:url value="/spitter/{spittleId}" var="spitterUrll">
    <s:param name="spittleId" value="20" />
</s:url>
<a href="${spittlesUrll}">spittlesUrll</a> 








<s:url value="/spittles"  htmlEscape="true">
    <s:param name="max" value="60" />
    <s:param name="count" value="20" />
</s:url>


<s:url value="/spittles" var="spittlesJSUrl" javaScriptEscape="true">
    <s:param name="max" value="60" />
    <s:param name="count" value="20" />
</s:url>

<script>
    var spittlesUrl = "${spittlesJSUrl}"
</script>


<s:escapeBody htmlEscape="true">
<h1>Hello</h1>
</s:escapeBody>
</html>