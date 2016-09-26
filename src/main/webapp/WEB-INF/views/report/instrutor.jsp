<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<caelum:page title="Treinos">
	<h3>Relatorio de Treinos</h3>
	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>
				<th>N de treinos</th>
				<th>Total de horas</th>
				<th>Detalhes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="hora" items="${listaHoras}">
				<tr>
					<td>${hora.nome}</td>
					<td>${hora.numeroTreinos}</td>
					<td>${hora.totalTempo}</td>
					<td>
						<a href="/report/treinos/${hora.nome}">Treinos</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</caelum:page>