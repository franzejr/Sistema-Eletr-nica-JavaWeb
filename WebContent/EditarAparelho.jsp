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

  <h3>Editar Aparelho</h3>
  <div class="extra">
	
				
	<form	action="EditarAparelhoServlet" method="post" name="basicform"	id="basicform" >
	
	
		<fieldset>
			<label for="nome">ID:</label>
			<input	type="text" name="id" value="<%= request.getParameter("id") %>" />
		</fieldset>
	
		<fieldset>
			<label for="nome">Nome:</label>
			<input	type="text" name="nome"	id="nome" value="<%= request.getParameter("nome") %>" />
		</fieldset>
		
		<fieldset>
			<label for="modelo" >Modelo:</label>
			<input type="text" name="modelo" id="modelo" value="<%= request.getParameter("modelo") %>" />
		</fieldset>
		
		<fieldset>
			<label for="serie" >Serie:</label>
			<input type="text" name="serie" id="serie" value="<%= request.getParameter("serie") %>" />
		</fieldset>
		
		<fieldset>
			<label for="telefoneFixo" >Marca:</label>
			<input type="text" id="marca" name="marca" value="<%= request.getParameter("marca") %>" />
		</fieldset>
		
		<fieldset>
			<label for="celular" >Defeito:</label>
			<input type="text" id="defeito" name="defeito" value="<%= request.getParameter("defeito") %>" />
		</fieldset>
		
		<fieldset>
			<label for="observacoes">Observacoes</label>
			<textarea id="observacoes" rows="4" cols="40" name="observacoes" value="<%=request.getParameter("observacoes") %>"></textarea>
		</fieldset>
		
		<input type="reset" value="Apagar"></input>
		<input type="submit" value="Editar Aparelho"></input>
		
		
		
	</form>
	

  </div>
  
</div>
 


<%@ include file="footer.html" %>



</body>
</html>