<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="membro"/></h2>
<c:if test="${not empty sucesso}">
	<div class="alert alert-success">${sucesso}</div>
</c:if>
<c:if test="${not empty erro}">
	<div class="alert alert-warning">${erro}</div>
</c:if>
<body onload='document.membroForm.nome.focus();'>
	<fieldset>
		<form:form name="membroForm" commandName="membro" method="PUT" action="${pageContext.request.contextPath}/membro/${membro.id}">
			<form:errors path="*" cssClass="alert alert-error" element="div" />
				
			<form:hidden path="id" />
	
			<form:label path="nome"><spring:message code="membro.nome"/></form:label>
			<form:input path="nome" placeholder="" />
			<form:errors path="nome" />
			
			<form:label path="email"><spring:message code="membro.email"/></form:label>
			<form:input path="email" placeholder=""/>
			<form:errors path="email"/>
			
			<form:label path="disponibilidade"><spring:message code="membro.disponibilidade"/></form:label>
			<form:checkbox path="disponibilidade.segundafeira"/> <spring:message code="disponibilidade.segundafeira"/><p>
			<form:checkbox path="disponibilidade.tercafeira"/> <spring:message code="disponibilidade.tercafeira"/><br/>
			<form:checkbox path="disponibilidade.quartafeira"/> <spring:message code="disponibilidade.quartafeira"/><br/>
			<form:checkbox path="disponibilidade.quintafeira"/> <spring:message code="disponibilidade.quintafeira"/><br/>
			<form:checkbox path="disponibilidade.sextafeira"/> <spring:message code="disponibilidade.sextafeira"/><br/>
			
			<p/>
			<input type="submit" value="<spring:message code="botao.salvar"/>" class="btn" />
		</form:form>
	</fieldset>
</body>
