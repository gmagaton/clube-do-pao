<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${not empty sucesso}">
	<div class="alert alert-success">${sucesso}</div>
</c:if>
<c:if test="${not empty erro}">
	<div class="alert alert-warning">${erro}</div>
</c:if>
<h2>Gerar Tabela</h2>
<p/>
<form method="post" action="${pageContext.request.contextPath}/tabela">
	<input type="text" id="data" name="data" />
	<input type="submit" value="Gerar" class="btn" />
</form>

Data Inicial: ${tabela.dataInicio.time}
<table class="table table-hover">
   	<thead>
   		<tr>
   			<th>data</th>
   			<th>dia</th>
   			<th>membro</th>
   		</tr>
   	</thead>
   	<tbody>
		<c:forEach items="${tabela.cronograma}" var="tabelaCronograma">
	        <tr>
	            <td>${tabelaCronograma.dataCronograma.time}</td>
	            <td>${tabelaCronograma.dia}</td>
	            <td>${tabelaCronograma.nome}</td>
	        </tr>
		</c:forEach>
	</tbody>
</table>