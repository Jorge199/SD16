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
								<br>
								<button type="submit" class="btn btn-success" name="edit" value="${requestInstance?.id}">
  									<i class="fa fa-pencil"></i> Guardar  
								</button>
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
</body>
</html>