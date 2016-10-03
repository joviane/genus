<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<caelum:page title="Detalhes">
	<h3>Treinos de ${listaHorasDetalhadas.get(0).traineeNome}</h3>
	<table class="table">
		<thead>
			<tr>
				<th>Dias</th>
				<th>Total de horas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="detalhes" items="${listaHorasDetalhadas}">
				<tr>
					<td>${detalhes.dia}</td>
					<td>${detalhes.tempoGasto}</td>
					<td><pre>${detalhes.comments}</pre></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</caelum:page>