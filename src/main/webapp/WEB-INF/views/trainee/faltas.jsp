<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<caelum:page title="Falta">

	<form:form action="/trainee/faltas/${traineeId}" commandName="falta">
		<label for="name">Data:</label>
		<form:input type="date" path="data" />
		<form:errors path="data" />

		<label for="name">Motivo:</label>
		<form:input path="motivo" />
		<form:errors path="motivo" />

		<input type="submit" value="Gravar" />
	</form:form>
	
</caelum:page>