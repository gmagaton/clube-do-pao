<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2><spring:message code="tabela"/></h2>
<p/>
<spring:message code="tabela.datainicio"/>: <fmt:formatDate value="${tabela.dataInicio.time}" pattern="dd/MM/yyyy" />
<table class="table table-hover">
   	<thead>
   		<tr>
   			<th><spring:message code="tabela.data"/></th>
   			<th><spring:message code="tabela.dia"/></th>
   			<th><spring:message code="tabela.membro"/></th>
   		</tr>
   	</thead>
   	<tbody>
		<c:forEach items="${tabela.cronograma}" var="tabelaCronograma">
	        <tr>
	            <td><fmt:formatDate value="${tabelaCronograma.dataCronograma.time}" pattern="dd/MM/yyyy" /></td>
	            <td><spring:message code="${tabelaCronograma.dia}"/></td>
	            <td>${tabelaCronograma.nome}</td>
	        </tr>
		</c:forEach>
	</tbody>
</table>
<input type="button" name="<spring:message code="botao.imprimir"/>" value="<spring:message code="botao.imprimir"/>" onclick="window.print();" class="btn">