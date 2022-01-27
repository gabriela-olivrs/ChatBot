<%@page import="model.Frase"%>
<%@page import="dao.funcaoFrase"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.funcao"%>
<%@page import="java.util.List"%>
<%@page import="model.Significado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/tabelas.CSS" rel="stylesheet" type="text/css" />
    <title>Respostas</title>
</head>
<header>
</header>
<nav>
    <a href="index.html">Home</a>
    </a>
</nav>

 <h1>Visualização da tabela Frases</h1> 
    <%
        funcaoFrase funcao = new funcaoFrase();
        List<Frase> listaFrase = funcao.getFrase();
        request.setAttribute("listaFrase", listaFrase);
    %>
    <table>
         <th>Id</th><th>Frase Vinculada à Resposta</th>
         <c:forEach items = "${listaFrase}" var = "frase">
        <tr>
            <td>${frase.getId()}</td>
            <td>${frase.getFrase()}</td>
        </tr>
        </c:forEach>
    </table>
    <div>
        <form action="resp" method="post">
            <label for="txtResposta">Frase:</label>
            <select name="resp">
                 <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "71184084");
                        Statement st = conn.createStatement();
                        String query = "select * from frase";
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()) {
                %>
                 <option><%=rs.getString("id")%> <label for="txtSignificado"><%=rs.getString("frase")%></label></option>
                <%
                        }

                    } catch (Exception e) {
                    }


                %>
            </select>
            <br><br><br>
            <input type="submit" name="inserirr"
				 value="Inserir">
        </form>
 </div>
</body>

</html>
