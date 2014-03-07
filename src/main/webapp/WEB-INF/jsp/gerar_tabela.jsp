<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${not empty sucesso}">
	<div class="alert alert-success">${sucesso}</div>
</c:if>
<c:if test="${not empty erro}">
	<div class="alert alert-warning">${erro}</div>
</c:if>
<h2><spring:message code="gerar_tabela.titulo"/></h2>
<p/>
<body onload='document.loginForm.data.focus();'>
	<fieldset>
		<form name="loginForm" method="post" action="${pageContext.request.contextPath}/tabela">
			<label><spring:message code="gerar_tabela.datainicio"/></label>
			<input type="text" id="data" name="data" />
			<p/>
			<input type="submit" value="<spring:message code="gerar_tabela.gerar"/>" class="btn" />
		</form>
	</fieldset>
</body>