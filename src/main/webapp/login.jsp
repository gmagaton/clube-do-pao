<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação</title>
    </head>
    <body>
        <c:if test="${param.erro ==  'invalido'}">
            Usuário e/ou senha inválidos!<br/><br/>
        </c:if>
 
        <form action="j_spring_security_check" method="post">
            Usuário: <input type="text" name="j_username" /><br />
            Senha: <input type="text" name="j_password"><br />
            <input type="submit" value="Efetuar Login">
        </form>
        <br /><br />
        <a href="index.jsp">Retornar para a Página Inicial</a>
    </body>
</html>