<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="/trainee" commandName="trainee" >
		<label for="name">Nome:</label>
		<form:input path="name" />
		<form:errors path="name" />
		
		<label for="name">Contato:</label>
		<form:input path="contact" />
		<form:errors path="contact" />
		
		<label for="name">Assunto:</label>
		<form:input path="subject" />
		<form:errors path="subject" />
		
		<input type="submit" value="Gravar" />
	</form:form>
</body>
</html>