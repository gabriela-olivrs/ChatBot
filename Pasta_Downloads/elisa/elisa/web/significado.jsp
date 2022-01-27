<%@page import="java.util.ArrayList"%>
<%@page import="dao.funcao"%>
<%@page import="java.util.List"%>
<%@page import="model.Significado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/tabelas.CSS" rel="stylesheet" type="text/css" />
        <title>Significados</title>
    </head>
    <header> 
    </header>
    <nav>
        <a href="index.html">Home</a>
    </nav>
    <h1>Visualização da Tabela Significados</h1> 
    <%
        funcao funcaoDao = new funcao();
        List<Significado> listaSignificado = funcaoDao.getSignificado();
        request.setAttribute("listaSignificado", listaSignificado);
    %>
</body>
<table>
    <th>Id</th><th>Significado</th>
        <c:forEach items = "${listaSignificado}" var = "significado">
        <tr>
            <td>${significado.getId()}</td>
            <td>${significado.getSignificado()}</td>
        </tr>
    </c:forEach>
</table>
<br>
<div>
    <form action="sig" method="post">
        <label>Significado:</label><input type="text"
                                          name="significado"> 
        <br> <br> <br> 
        <input type="submit" name="inserirr"
               value="Inserir">
    </form>
</div>
</html>
