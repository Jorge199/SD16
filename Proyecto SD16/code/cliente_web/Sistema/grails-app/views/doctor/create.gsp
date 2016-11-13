
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'doctor.label', default: 'Doctor')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Registrar Doctor</strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:form action="save">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-10">
								<div class="text-right">
									<button type="submit" class="btn btn-primary " name="create"
										value="${message(code: 'default.button.create.label', default: 'Create')}">
										<i class="fa fa-floppy-o"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/doctor/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>
								</div>
							</div>

						</fieldset>
					</g:form>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Jasny-Bootstrap JavaScript -->
	<script src=" ${request.contextPath}/template/js/jasny-bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#phoneNum").mask("(999) 999-9999");
	</script>
	
</body>
</html>
