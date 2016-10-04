<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<caelum:page title="Instrutores">
	<h2>Novo treinamento para - ${trainee.name}</h2>

	<form:form action="/training/trainee/${trainee.id}" commandName="infoTraining" >
		<caelum:formFieldSpring id="comments" label="Comentários">
			<form:textarea path="comments" rows="30" cols="150"/>
		</caelum:formFieldSpring>
		
		<form:hidden path="trainingId" value="${trainingId}"/>
	
		<input type="submit" value="Finalizar treino" class="btn btn-primary" />
	</form:form>
</caelum:page>