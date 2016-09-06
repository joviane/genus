<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<caelum:page title="Faltas">
	<h3>Faltas de ${traineeNome}</h3>
	
	<table class="table">
		<thead>
			<tr>
				<th>Data</th>
				<th>Motivo</th>
				<th>Seguidas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="falta" items="${faltas}">
				<tr>
					<td>${falta.data}</td>
					<td>${falta.motivo}</td>
					<td>${falta.seguidas}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</caelum:page>