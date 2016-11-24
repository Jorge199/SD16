
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'report.label', default: 'Report')}" />
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
						<strong>Generar Informe</strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:form action="save">
					
						<fieldset class="form">
							
							<g:render template="form" />

						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary" name="create"
										value="${reportInstance?.request?.id}">
										<i class="fa fa-floppy-o"></i> Guardar
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
	<br><br><br><br>
</body>
</html>
