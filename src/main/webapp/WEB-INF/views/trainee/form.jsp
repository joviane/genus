<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<caelum:page title="Instrutores" listActive="active">
	<h3>Lista de instrutores</h3>
	
	<form action="/trainee/buscaPorStatus" method="post">
		<select name="status">
			<c:forEach items="${viewHelper.statusList()}" var="status">
				<option value="${status.name}" ${trainee.progress.status.name == status.name ? "selected":""}>
					<fmt:message key ="${status.name}" />
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="Buscar"/>
	</form>
	
	<form action="/trainee/buscaPorPeriodo" method="post">
		<input type="date" name="inicio" />
		<input type="date" name="fim" />
		<input type="submit" value="Buscar"/>
	</form>
	
	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Contato</th>
				<th>Status</th>
				<th>Faltas</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="trainee" items="${trainees}">
				<tr class=${trainee.faltas.size() > 2 ? "perigo" : ""}>
					<td>${trainee.name}</td>
					<td>${trainee.contact}</td>
					<td>
						<select onchange="troca(${trainee.id},this)" id="status">
							<c:forEach items="${viewHelper.statusList()}" var="status">
								<option value="${status.name}" ${trainee.progress.status.name == status.name?"selected":""}>
									<fmt:message key ="${status.name}" />
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<a href="/report/faltas/${trainee.id}">${trainee.faltas.size()}</a>
					</td>
					<td>
						<a href="/training/trainee/${trainee.id}">Novo treino</a> |
						<a href="/trainee/faltas/${trainee.id}">Faltou</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>Novo instrutor em treinamento</h3>

	<form:form action="/trainee" commandName="trainee">
		<caelum:formFieldSpring label="Nome:" id="name">
			<form:input path="name" />
		</caelum:formFieldSpring>

		<caelum:formFieldSpring label="Contato:" id="contact">
			<form:input path="contact" />
		</caelum:formFieldSpring>

		<caelum:formFieldSpring label="Assunto:" id="subject">
			<form:input path="subject" />
		</caelum:formFieldSpring>

		<input type="submit" value="Gravar" />
	</form:form>
	
	<script type="text/javascript">
		function troca(id, sel) {
			var infoRequest = 
				JSON.stringify({
					status : sel.value,
					traineeId : id
				});
			var request = new XMLHttpRequest();
			var token = document.getElementsByName("_csrf")[0].value;
			var header = "X-CSRF-Token";
			request.open("PATCH", "/trainee/changeStatus");
			request.setRequestHeader("Content-Type", "application/json");
			request.setRequestHeader(header, token);
			request.send(infoRequest);
		}
	</script>
</caelum:page>