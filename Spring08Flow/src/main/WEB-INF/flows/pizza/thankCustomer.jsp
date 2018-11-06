<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:output omit-xml-declaration="yes" />
    <jsp:directive.page contentType="text/html;charset=UTF-8" />
    <head><title>Spizza</title></head>
    <body>
        <h2>Thank you for your order!</h2>
        <![CDATA[
        <a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>
        ]]>
    </body>
</html>