<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Stylesheet" href="estilo.css" type="text/css" media="screen" />

<meta name="viewport" content="width=1065" />
<title>Eletrônica Franzé</title>
</head>

<body class="signup three">


<%@ include file="wrapper.html" %> 


  <div class="statement">
    <h2></h2>


</div>

<!-- Here starts the container --->
<div class="container">

  <h3>Listagem de Aparelhos</h3>
  <div class="extra">

<%@ page import="bean.Aparelho" %>
<%@ page import="DAO.AparelhoDAO" %>
<%@ page import="java.util.List" %>
<%
	//Busca o atributo lista de aparelhos do request
	List<Aparelho> aparelhos = (List<Aparelho>) request.getAttribute("aparelhos");
	
	//Se o atributo estiver nulo, sera listado a partir do banco
	if(aparelhos == null){
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		aparelhos = aparelhoDAO.listar();
	}
	
	request.setAttribute("aparelhos", aparelhos);
%>			
				
	<c:if test="${aparelhos != null}">
		<table border='1'>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Modelo</th>
				<th>Marca</th>
				<th>Serie</th>
				<th>Defeito</th>
				<th>Observacoes</th>
			</tr>
		
			<c:forEach var="aparelho" items="${aparelhos}">
				<tr>	
					<td><c:out value="${aparelho.id }"/></td>
					<td><c:out value="${aparelho.nome}"/></td>
					<td><c:out value="${aparelho.modelo}"/></td>
					<td><c:out value="${aparelho.marca}"/></td>
					<td><c:out value="${aparelho.serie}"/></td>
					<td><c:out value="${aparelho.defeito}"/></td>
					<td><c:out value="${aparelho.observacoes}"/></td>
					<td><a href="EditarAparelho.jsp?id=${aparelho.id }&nome=${aparelho.nome }&modelo=${aparelho.modelo }&marca=${aparelho.marca }&serie=${aparelho.serie }&defeito=${aparelho.defeito }&observacoes=${aparelho.observacoes }  ">Editar</a></td>
					<td><a href="RemoverAparelho.jsp?id=${aparelho.id }&nome=${aparelho.nome }&modelo=${aparelho.modelo }&marca=${aparelho.marca }&serie=${aparelho.serie }&defeito=${aparelho.defeito }&observacoes=${aparelho.observacoes }  ">Remover</a></td>
				</tr>
			</c:forEach>
	
		</table>
	</c:if>

	

  </div>
  
</div>
 


<%@ include file="footer.html" %>



</body>
</html>