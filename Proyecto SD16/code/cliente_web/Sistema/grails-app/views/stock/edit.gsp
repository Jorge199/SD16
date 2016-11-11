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
					<g:form action="save" id="creararticulo" >
						<div class="panel-body">
						<div class="row">

						    <div class="col-md-6">
								<label>
									Nombre
									<span class="required-indicator">*</span>
								</label>
								
								<g:textField class="form-control" required="" name="name" maxlength="60" value="${articleInstance?.name}"/>
								
							</div>
							 <div class="col-md-6">
									<label>
										Cantidad
										<span class="required-indicator">*</span>
									</label>
									<g:textField class="form-control" required="" maxlength="10" name="units" value="${articleInstance?.units}"/>
							</div>
						</div>
						<div class="row">
						      <div class="col-md-6">
									<label>
										Descripcion
										<span class="required-indicator">*</span>
									</label>
									<g:textField class="form-control" required="" minlength="2" maxlength="50" name="description" value="${articleInstance?.description}" />
								</div>
						      <div class="col-md-6">
									<label>
										Cantidad en Stock
										<span class="required-indicator">*</span>
									</label>
									<g:textField class="form-control" required=""  maxlength="10" name="count_stock" value="${articleInstance?.count_stock}"/>
								</div>
						</div>
						<br>
						<button class="btn btn-primary"><i class="fa fa-floppy-o"></i> Guardar</button>
					</div>	

							<g:hiddenField name="id" value="${articleInstance?.id}" />
					</g:form>
				</div>
				
			</div>
		</div>
		<!-- jQuery -->
    <script src=" ${request.contextPath}/template/js/jquery.js"></script>
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
	</body>
</html>