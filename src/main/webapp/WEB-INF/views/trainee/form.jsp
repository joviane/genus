<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<caelum:page title="Instrutores">
	<h3>Lista de instrutores</h3>
	
	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Contato</th>
				<th>Status</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="trainee" items="${trainees}">
				<tr>
					<td>${trainee.name}</td>
					<td>${trainee.contact}</td>
					<td>${trainee.progress.status}</td>
					<td><a href="/training/trainee/${trainee.id}">Novo treino</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>Novo instrutor em treinamento</h3>

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
</caelum:page>