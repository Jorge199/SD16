<!DOCTYPE html>
<html>
<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'request.label', default: 'Request')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
</head>
<body>
	
	<div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Actualizar ficha</strong></h4>
					</div>
					<div class="panel-body">
						<g:form action="update" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<br> <br>
								<div class="col-xs-12" align="center">
										<button type="submit" class="btn btn-primary" name="edit" value="${requestInstance?.id}">
		  									<i class="fa fa-save"></i> Guardar  
										</button>
										<a class="btn btn-default" href="/Sistema/request/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>
								
								</div>
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Moment -->
	<script src=" ${request.contextPath}/template/js/moment.js"></script>
	<script src=" ${request.contextPath}/template/js/es.js"></script>

	<!-- Transition -->
	<script src=" ${request.contextPath}/template/js/transition.js"></script>

	<!-- Collapse -->
	<script src=" ${request.contextPath}/template/js/collapse.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>


	<!-- Bootstrap datetimepicker -->
	<script
		src=" ${request.contextPath}/template/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src=" ${request.contextPath}/template/js/bootstrap-datetimepicker.es.js"></script>

	<link rel="stylesheet"
		href="${request.contextPath}/template/css/bootstrap-datetimepicker.min.css" />
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
				format : 'DD-MM-YYYY',
				locale : 'es',
			});
		});
	</script>
</body>
</html>