<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<caelum:page title="Instrutores">
	<h3>Lista de instrutores</h3>
	
	<form action="/trainee/buscaPorStatus" method="post">
		<select name="status">
			<c:forEach items="${viewHelper.statusList()}" var="status">
				<option value="${status.name}"
					${trainee.progress.status.name == status.name?"selected":""}>
					${status.name}</option>
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
				<tr>
					<td>${trainee.name}</td>
					<td>${trainee.contact}</td>
					<td>
						<select onchange="troca(${trainee.id},this)" id="status">
							<c:forEach items="${viewHelper.statusList()}" var="status">
								<option value="${status.name}"
									${trainee.progress.status.name == status.name?"selected":""}>
									${status.name}</option>
							</c:forEach>
						</select>
					</td>
					<td class=${trainee.faltas.size()>2 ? "perigo" : ""}>
						<select>
							<c:forEach items="${trainee.faltas}" var="falta">
								<option>${falta}</option>
							</c:forEach>
						</select>
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
	
	<script type="text/javascript">
		function troca(id, sel) {
			var infoRequest = { 
					method: 'PATCH',
					headers: { "Content-Type" : 'application/json'},
					body: JSON.stringify({
						status : sel.value,
						traineeId : id
					})
			};
			var request = new Request('/trainee/changeStatus', infoRequest);
			fetch(request);
		}
	</script>
</caelum:page>