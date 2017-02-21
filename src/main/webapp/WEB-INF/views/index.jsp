<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<caelum:page title="Login">
	<h1>Treinamento de instrutores Caelum</h1>
	<form:form action="/user">
		<input type="submit" class="btn btn-primary" value="Login (via Github)" />
	</form:form>
</caelum:page>