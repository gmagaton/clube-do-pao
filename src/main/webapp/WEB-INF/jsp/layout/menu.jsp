<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav">
	<li><a href="${pageContext.request.contextPath}/membro"><spring:message code="menu.membros" /></a></li>
	<li><a href="${pageContext.request.contextPath}/tabela"><spring:message code="menu.tabelas" /></a></li>
	<sec:authorize access="isAuthenticated()">
		<li><a href="${pageContext.request.contextPath}/logout"><spring:message code="menu.logout" /></a></li>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<li><a href="${pageContext.request.contextPath}/login"><spring:message code="menu.login" /></a></li>
	</sec:authorize>
</ul>
