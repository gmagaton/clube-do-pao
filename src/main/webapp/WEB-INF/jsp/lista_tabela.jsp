<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<a href="${pageContext.request.contextPath}/tabela/nova">gerar nova tabela</a>
<p/>
<h2>Lista de Tabelas</h2>
<p/>
<table class="table table-hover">
   	<thead>
   		<tr>
   			<th>data da tabela</th>
   		</tr>
   	</thead>
   	<tbody>
		<c:forEach items="${tabelas}" var="tabela">
	        <tr>
	            <td>
	            	<a href="${pageContext.request.contextPath}/tabela/${tabela.id}">
	            		${tabela.dataInicio.time}
	            	</a>
	            </td>
	            <td>
		            <form:form commandName="tabela" method="DELETE" action="${pageContext.request.contextPath}/tabela/${tabela.id}">
						<input type="submit" value="Remover" class="lnk"/>
					</form:form>
				</td>
	        </tr>
		</c:forEach>
	</tbody>
</table>