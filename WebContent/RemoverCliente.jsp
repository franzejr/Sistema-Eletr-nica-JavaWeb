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

  <h3>Remover Cliente</h3>
  <div class="extra">
	
				
	<form	action="RemoverClienteServlet" method="post" name="basicform"	id="basicform" >
	
		<fieldset>
			<label for="nome">ID:</label>
			<input	type="text" name="id"	id="id" value="<%= request.getParameter("id") %>" />
		</fieldset>
	
	
		<fieldset>
			<label for="nome">Nome:</label>
			<input	type="text" name="nome"	id="nome" value="<%= request.getParameter("nome") %>" />
		</fieldset>
		
		<fieldset>
			<label for="modelo" >Endereco:</label>
			<input type="text" name="endereco" id="endereco" value="<%= request.getParameter("endereco") %>" />
		</fieldset>
		
		<fieldset>
			<label for="telefoneFixo" >Telefone Fixo:</label>
			<input type="text" id="marca" name="telefoneFixo" value="<%= request.getParameter("telefoneFixo") %>" />
		</fieldset>
		
		<fieldset>
			<label for="celular" >Celular:</label>
			<input type="text" id="celular" name="celular" value="<%= request.getParameter("celular") %>" />
		</fieldset>
		
		
		
		<input type="submit" value="Remover Cliente"></input>
		
		
		
	</form>
	

  </div>
  
</div>
 


<%@ include file="footer.html" %>



</body>
</html>