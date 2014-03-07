<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<body onload='document.loginForm.j_username.focus();'>
		<h2><spring:message code="login"/></h2>
		<c:if test="${not empty erro}">
			<div class="alert alert-warning">
				<spring:message code="login.invalido"/>
			</div>
		</c:if>
		<form name="loginForm" action="<c:url value='j_spring_security_check' />" method='POST'>
			<table>
				<tr>
					<td><spring:message code="login.usuario"/></td>
					<td><input type='text' name='j_username' value=''>
					</td>
				</tr>
				<tr>
					<td><spring:message code="login.senha"/></td>
					<td><input type='password' name='j_password' />
					</td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" name="<spring:message code="botao.acessar"/>"  value="<spring:message code="botao.acessar"/>"  class="btn"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>