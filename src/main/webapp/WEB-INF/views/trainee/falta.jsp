<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<caelum:page title="Falta">

	<form:form action="/trainee/faltas/${traineeId}" commandName="falta">
		<caelum:formFieldSpring label="Data:" id="data">
			<form:input type="date" path="data" />
		</caelum:formFieldSpring>

		<caelum:formFieldSpring label="Motivo:" id="motivo">
			<form:input path="motivo" />
		</caelum:formFieldSpring>

		<input type="submit" value="Gravar" />
	</form:form>
	
</caelum:page>