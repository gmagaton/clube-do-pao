<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<a href="${pageContext.request.contextPath}/tabela/nova">gerar nova tabela</a>
<p/>
<c:if test="${not empty tabelas}">
	<h2><spring:message code="lista_tabela.titulo"/></h2>
	<p/>
	<table class="table table-hover">
	   	<thead>
	   		<tr>
	   			<th><spring:message code="lista_tabela.data"/></th>
	   		</tr>
	   	</thead>
	   	<tbody>
			<c:forEach items="${tabelas}" var="tabela">
		        <tr>
		            <td>
		            	<a href="${pageContext.request.contextPath}/tabela/${tabela.id}">
		            		<fmt:formatDate value="${tabela.dataInicio.time}" pattern="dd/MM/yyyy" />
		            	</a>
		            </td>
		            <td>
			            <form:form commandName="tabela" method="DELETE" action="${pageContext.request.contextPath}/tabela/${tabela.id}">
							<input type="submit" value=<spring:message code="botao.remover"/> class="lnk"/>
						</form:form>
					</td>
		        </tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>