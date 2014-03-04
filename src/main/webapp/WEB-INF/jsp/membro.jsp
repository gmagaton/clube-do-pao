<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="Membro"/></h2>
<div>${msg}</div>
<fieldset>
	<form:form commandName="membro" method="PUT" action="${pageContext.request.contextPath}/membro/${membro.id}">
		<form:errors path="*" cssClass="alert alert-error" element="div" />
			
		<form:hidden path="id" />

		<form:label path="nome"><spring:message code="Membro.nome"/></form:label>
		<form:input path="nome" placeholder="" />
		<form:errors path="nome" />
		
		<form:label path="email"><spring:message code="Membro.email"/></form:label>
		<form:input path="email" placeholder=""/>
		<form:errors path="email"/>
		
		<form:label path="disponibilidade"><spring:message code="Membro.disponibilidade"/></form:label>
		<form:checkbox path="disponibilidade.segundafeira"/> <spring:message code="Disponibilidade.segundafeira"/><p>
		<form:checkbox path="disponibilidade.tercafeira"/> <spring:message code="Disponibilidade.tercafeira"/><br/>
		<form:checkbox path="disponibilidade.quartafeira"/> <spring:message code="Disponibilidade.quartafeira"/><br/>
		<form:checkbox path="disponibilidade.quintafeira"/> <spring:message code="Disponibilidade.quintafeira"/><br/>
		<form:checkbox path="disponibilidade.sextafeira"/> <spring:message code="Disponibilidade.sextafeira"/><br/>
		
		<p/>
		<input type="submit" value="<spring:message code="acao.salvar"/>" class="btn" />
	</form:form>
</fieldset>
