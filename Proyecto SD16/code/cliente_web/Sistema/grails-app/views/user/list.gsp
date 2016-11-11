
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body >
	<div class="container-fluid"   >
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Lista de Usuarios</strong>
					</h4>
				</div>
				<div class="panel-body" >
					<g:if test="${flash.message}">
						<div class="message" role="status">
							${flash.message}
						</div>
					</g:if>
					
					<!--EL BUSCAR -->
					 
					
   					
   					<div id="searchbox">Buscar:

   					<g:remoteField  update="updateMe" class="search-box"  name= "searching" paramName ="text" url="[action:'list', controller:'user']"/>
					
					</div>
					
					<!--END BUSCAR -->
					
					
					<div class="dataTable_wrapper" >
						<div class="row" >
							<div class="col-sm-12" >
								<div id="updateMe"  >
								<table   id="list-report" class="table table-striped table-bordered" cellspacing="0" width="100%">
									<thead >
										<tr>
											<g:sortableColumn property="name" title="Nombre" />
											<g:sortableColumn property="password" title="Contraseña" />
											<g:sortableColumn property="rol" title="Rol" />
											<g:sortableColumn property="doctor" title="doctor" />
											<g:sortableColumn property="matricula" title="Matricula" />
											
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody id="updateMe">
										
										<g:render template="/user/showResults"  id="updateMe">
											</g:render>
									</tbody>
								</table>
								</div>
								
								<div class="pagination"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script>
function ajaxSearch(str) {
	
	 if(str.length>5){
		 alert("entro")
	 }
  
}
</script>


<script>
function letterDelimiter(str) {
	
	 if(str.length>5){
		 alert("entro")
	 }
  
}
</script>
	
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>