<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
		<title>Documents</title>
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
		<link rel="stylesheet" href="css/estilos.css">
<title>Inicio</title>
</head>
<body>
<header>
		 	<div class="container">
		 		<h1>Enlistame</h1>
		 	</div>
		 	
		</header><!-- /header -->
	    
	    <div id="principal" class="container">
	    	<section class="main row">
	    		<article class="col-xs-12 col-sm-8 col-md-9">
	    			<p>Te permite llevar un control de los alimentos que tienes en casa y crear tu propio carro de la compra
	    			 antes de ir a comprar para saber que es lo que necesitas</p>
	    		</article>

	    		<aside class="col-xs-12 col-sm-4 col-md-3">	
	    			<h1>Principales Supermercados</h1>
	    			<ul>
	    				<li>Alcampo</li>
	    				<li>Mercadona</li>
	    				<li>Dia</li>
	    				<li>Carrefour</li>
	    				<li>Lidel</li>
	    			</ul>

	    		</aside>
	    	</section>

	    	<div class="row">
		    	<div class="col-xs-12 col-sm-6 col-md-3">
		    	  <button class="btn btn-block btn-default" onclick="Ocultar()">Login</button>
		    	</div>

		    	<div class="col-xs-12 col-sm-6 col-md-3">
		    	    	<button class="btn btn-block btn-default" onclick="Ocultar()">Registrate</button>
		    	</div>
	    		
	    	</div>

		    <div id ="secundario" class="container" >
		    	<section class="main row">
		    		<button class="btn btn-block btn-default" onclick="Mostrar_Ocultar()">Mostar de nuevo</button>
		    	</section>
		    	
		    </div>

	    </div>

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
	<script type="text/javascript">
		function Mostrar(){
			document.getElementById("principal").style.display = "block"
		}

		function Ocultar(){
			document.getElementById("principal").style.display = "none"
		}

		function Mostrar_Ocultar(){
			var principal = document.getElementById("principal");

			if(principal.style.display == "none"){
				Mostrar();
			}else{
				Ocultar();
			}
		}
	</script>
</html>