
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
	<div class="container-fluid" >
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
					 
					
   					
   					<div id="searchbox"> 
					<label>Buscar :
   					<g:remoteField  update="updateMe" id="searching" class="form-control"  name= "searching" paramName ="text" url="[action:'showResult', controller:'user']"/>
					</label>
					</div>
					<p></p>
					<p></p>
					
					<!--END BUSCAR -->
					
					
					<div class="dataTable_wrapper" >
						<div class="row" >
							<div class="col-sm-12" >
								
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
										
										<g:render template="/user/showResult"  id="updateMe">
											</g:render>
									</tbody>
								</table>
								
								<div class="panel-body">
									<g:form action="list">
										<g:hiddenField name="text" value="${text}" />
										<g:if test="${page > 0}">
											<fieldset class="buttons col-sm-1">
												<button type="submit" class="btn btn-default" name="page" value="${page - 1}">
													<i class="fa fa-arrow-left"></i> Anterior 
												</button>
											</fieldset>
										</g:if>
										<g:if test="${siguiente > 0}">
											<fieldset class="buttons col-sm-1">
												<button type="submit" class="btn btn-default" name="page" value="${page + 1}">
													<i class="fa fa-arrow-right"></i> Siguiente 
												</button>
											</fieldset>
										</g:if>
									</g:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script>
$( document ).ready(function() {
	$('#searching').on('propertychange input', function (e) {
		var bla = $('#searching').val();
	    if (val.lenght<3) {
	    	$('#searching').delay();
	    }
	});

});



function ajaxSearch(str) {
	
	 if(str.length>5){
		 alert("entro")
	 }
  
}
</script>


<script>
function letterDelimiter(str) {
	
	$(".container-fluid").css("color", "#000000");
  
}
</script>
	
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>