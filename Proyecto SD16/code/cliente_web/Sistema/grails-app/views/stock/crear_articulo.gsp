<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body>
        <div class="container-fluid">
        	<div class="row">
        	
			            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Registrar Articulo</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
						    <div class="col-md-6">
								<label>
									Nombre
									<span class="required-indicator">*</span>
								</label>
								
								<g:textField class="form-control" name="name"/>
								
							</div>
							 <div class="col-md-6">
									<label>
										Cantidad
										<span class="required-indicator">*</span>
									</label>
									<g:textField class="form-control" name="units"/>								
<%--									<g:textField class="form-control" name="last_name" required="" value="${patientInstance?.last_name}"/>--%>
							</div>
						</div>
						<div class="row">
						      <div class="col-md-6">
									<label>
										Descripcion
										<span class="required-indicator">*</span>
									</label>
									<g:textField class="form-control" name="description"/>									
<%--									<g:textField class="form-control" name="name" required="" value="${patientInstance?.name}"/>--%>
								
								</div>
						      <div class="col-md-6">
									<label>
										Cantidad en Stock
										<span class="required-indicator">*</span>
									</label>
									<g:textField class="form-control" name="count_stock"/>
<%--									<g:textField class="form-control" name="name" required="" value="${patientInstance?.name}"/>--%>
								
								</div>						
						</div>
						<br>
						<button class="btn btn-primary"><i class="fa fa-floppy-o"></i> Crear</button>
					</div>	
						
				</div>
				
			
			
			
        	
			</div>
		</div>
		<!-- jQuery -->
    <script src=" ${request.contextPath}/template/js/jquery.js"></script>
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
								
	</body>
</html>