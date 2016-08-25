<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo treinamento para - ${trainee.name}</title>
</head>
<body>
	<h2>Novo treinamento para - ${trainee.name}</h2>

	<form:form action="/training/trainee/${trainee.id}" commandName="infoTraining" >
		<form:errors path="*"/>
		<label for="comments">Comentários:</label>
		<form:textarea path="comments" rows="40" cols="150"/>
		<form:errors path="comments" />
		<form:hidden path="trainingId" value="${trainingId}"/>
	
		<input type="submit" value="Finalizar treino" />
	</form:form>
</body>
</html>