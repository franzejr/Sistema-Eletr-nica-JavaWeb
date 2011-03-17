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

  <h3>Listagem de Clientes</h3>
  <div class="extra">

<%@ page import="bean.Cliente" %>
<%@ page import="DAO.ClienteDAO" %>
<%@ page import="java.util.List" %>
<%
	//Busca o atributo lista de aparelhos do request
	List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
	
	//Se o atributo estiver nulo, sera listado a partir do banco
	if(clientes == null){
		ClienteDAO clienteDAO = new ClienteDAO();
		clientes = clienteDAO.listar();
	}
	
	request.setAttribute("clientes", clientes);
%>			
				
	<c:if test="${clientes != null}">
		<table border='1'>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Endereco</th>
				<th>Telefone Fixo</th>
				<th>Celular</th>
			</tr>
		
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td><c:out value="${cliente.id}"/></td>	
					<td><c:out value="${cliente.nome}"/></td>
					<td><c:out value="${cliente.endereco}"/></td>
					<td><c:out value="${cliente.telefoneFixo}"/></td>
					<td><c:out value="${cliente.celular}"/></td>
					<td><a href="EditarCliente.jsp?id=${cliente.id}&nome=${cliente.nome}&endereco=${cliente.endereco}&telefoneFixo=${cliente.telefoneFixo}&celular=${cliente.celular}" >Editar</a></td>
					<td><a href="RemoverCliente.jsp?id=${cliente.id}&nome=${cliente.nome}&endereco=${cliente.endereco}&telefoneFixo=${cliente.telefoneFixo}&celular=${cliente.celular}" >Remover</a></td>
				</tr>
			</c:forEach>
	
		</table>
	</c:if>

	

  </div>
  
</div>
 


<%@ include file="footer.html" %>



</body>
</html>