<!doctype html>
<html lang="en">
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Demo</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
</head>
<base href="/" />
<body>
	<form:form action="/login">
		<button type="submit" class="button">Login</button>
	</form:form>
	<form:form action="/logout">
		<button type="submit" class="button">Logout</button>
	</form:form>
	<p>Logged in as ${user}</p>
	<a href="/trainee">Lista de trainee</a>
</body>
</html>