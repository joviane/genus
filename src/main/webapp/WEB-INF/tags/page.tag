<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="title" %>
<%@attribute name="listActive" required="false" %>
<%@attribute name="reportActive" required="false" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/page.css">
		<title>${title}</title>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<!-- SE ESTIVER LOGADO -->
	
					<div class="col-sm-3 col-md-2 sidebar">
						<ul class="nav nav-sidebar">
							<li role="presentation" class="${listActive}"><a href="/trainee">Instrutores em treinamento</a></li>
							<li role="presentation" class="${reportActive}"><a href="/report/relatorioTrainees">Relatórios</a></li>	
						</ul>
						<ul class="nav nav-sidebar">
							<li><a href="/logout">Logout</a></li>
						</ul>
					</div>
				<!-- FIM -->
				
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<jsp:doBody/>
				</div>
			</div>
		</div>
	</body>
</html>
