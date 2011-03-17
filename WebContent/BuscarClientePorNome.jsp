<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

  <h3>Busca de Clientes</h3>
  <div class="extra">
			
			

		
		
		<form	action="BuscarClientesPorNomeServlet" method="get" name="basicform"	id="basicform" >
	
	
			
				<fieldset>
					<label for="nome">Nome:</label>
					<input	type="text" name="nome"	id="nome" />
				</fieldset>
				
		
		
		
		<input type="reset" value="Apagar"></input>
		<input type="submit" value="Buscar Cliente"></input>
		
		
		
	</form>

  </div>
  
</div>
 


<%@ include file="footer.html" %>



</body>
</html>