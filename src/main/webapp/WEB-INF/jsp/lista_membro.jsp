<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<a href="${pageContext.request.contextPath}/membro/novo">novo membro</a>
<p/>
<c:if test="${not empty membros}">
	<h2><spring:message code="lista_membro.titulo"/></h2>
	<p/>
	<table class="table table-hover">
	   	<thead>
	   		<tr>
	   			<th><spring:message code="membro.nome" /></th>
	   			<th><spring:message code="membro.email" /></th>
	   			<th><spring:message code="membro.disponibilidade" /></th>
	   			<th><spring:message code="lista_membro.acoes" /></th>
	   		</tr>
	   	</thead>
	   	<tbody>
			<c:forEach items="${membros}" var="membro">
		        <tr>
		            <td><a href="${pageContext.request.contextPath}/membro/${membro.id}">${membro.nome}</a></td>
		            <td>${membro.email}</td>
		            <td>${membro.disponibilidade}</td>
		            <td>
			            <form:form commandName="membro" method="DELETE" action="${pageContext.request.contextPath}/membro/${membro.id}">
							<input type="submit" value="Remover" class="lnk"/>
						</form:form>
					</td>
		        </tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>