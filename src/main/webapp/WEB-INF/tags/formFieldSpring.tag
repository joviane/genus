<%@ tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ attribute name="id" required="false" %>
<%@ attribute name="label" required="false" %>

<div class="form-group">
	<label for="${id}" class="col-sm-2 control-label">${label}</label>
	<p class="bg-danger">
		<form:errors path="${id}" />
	</p>
	<div class="col-sm-10">
		<jsp:doBody/>
	</div>
</div>