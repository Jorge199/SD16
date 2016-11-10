<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'request.label', default: 'Request')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="edit-request" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${requestInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${requestInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Editar Ficha</strong></h4>
					</div>
					<div class="panel-body">
						<g:form action="update" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<br>
								<button type="submit" class="btn btn-success" name="edit" value="${requestInstance?.id}">
  									<i class="fa fa-pencil"></i> Actualizar  
								</button>
							</fieldset>
						</g:form>	
				</div>
			</div>
		</div>
	</div>
</body>
		
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

</html>