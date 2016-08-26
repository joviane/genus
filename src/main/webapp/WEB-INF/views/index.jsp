<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<caelum:page title="Login">
	<div class="container" ng-show="!home.authenticated">
		<div>
			With Github: <a href="/login/github">click here</a>
		</div>
	</div>
</caelum:page>