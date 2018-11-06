<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
<title>Create Pizza</title>
</head>
 
<body>
<div>
 
    <h2>Create Pizza</h2>
    <form:form commandName="pizza">
      <input type="hidden" name="_flowExecutionKey" 
          value="${flowExecutionKey}"/>
 
      <b>Size: </b><br/>
          <form:radiobutton path="size" label="Small (12-inch)" value="SMALL"/><br/>
        <form:radiobutton path="size" label="Medium (14-inch)" value="MEDIUM"/><br/>
        <form:radiobutton path="size" label="Large (16-inch)" value="LARGE"/><br/>
        <form:radiobutton path="size" label="Ginormous (20-inch)" value="GINORMOUS"/><br/>
      <br/>
 
      <b>Toppings: </b><br/>
      <form:checkboxes path="toppings" items="${toppingsList}" 
                       delimiter="<br/>"/><br/><br/>
 
 
      <input type="submit" class="button" 
          name="_eventId_addPizza" value="Continue"/>
      <input type="submit" class="button" 
          name="_eventId_cancel" value="Cancel"/>          
    </form:form>
</div>
</body>
</html>