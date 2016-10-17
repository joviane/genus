<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<caelum:page title="Instrutores">
	<h2>Novo treinamento para - ${trainee.name}</h2>

	<form:form action="/training/trainee/${trainee.id}" commandName="infoTraining" >
		<caelum:formFieldSpring id="comments" label="Comentários">
			<form:textarea path="comments" rows="30" cols="150"/>
		</caelum:formFieldSpring>
		
		<form:hidden path="trainingId" value="${trainingId}"/>
	
		<input type="submit" value="Finalizar treino" class="btn btn-primary" />
	</form:form>

	<script type="text/javascript">
		document.getElementById("comments").onkeydown = function(e) {
			var TAB = 9;
			if (e.keyCode == TAB) {
				e.preventDefault();
				insertAtCaret(this, '\t');
			}
		};

		function insertAtCaret(txtarea, text) {
			var scrollPos = txtarea.scrollTop;
			var strPos = 0;
			var br = ((txtarea.selectionStart || txtarea.selectionStart == '0') ? "ff"
					: (document.selection ? "ie" : false));
			if (br == "ie") {
				txtarea.focus();
				var range = document.selection.createRange();
				range.moveStart('character', -txtarea.value.length);
				strPos = range.text.length;
			} else if (br == "ff")
				strPos = txtarea.selectionStart;

			var front = (txtarea.value).substring(0, strPos);
			var back = (txtarea.value).substring(strPos, txtarea.value.length);
			txtarea.value = front + text + back;
			strPos = strPos + text.length;
			if (br == "ie") {
				txtarea.focus();
				var range = document.selection.createRange();
				range.moveStart('character', -txtarea.value.length);
				range.moveStart('character', strPos);
				range.moveEnd('character', 0);
				range.select();
			} else if (br == "ff") {
				txtarea.selectionStart = strPos;
				txtarea.selectionEnd = strPos;
				txtarea.focus();
			}
			txtarea.scrollTop = scrollPos;
		};
	</script>
</caelum:page>