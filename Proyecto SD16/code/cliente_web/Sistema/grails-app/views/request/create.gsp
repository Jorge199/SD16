
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'request.label', default: 'Request')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
	<!-- controlar error -->
		<div id="create-request" class="content scaffold-create" role="main">
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
		<!-- panel -->
			<div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Registrar Ficha</strong></h4>
					</div>
					<div class="panel-body">
						<g:form action="save" >
							<fieldset class="form">
							<!-- formulario -->
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
							</br>
								<button type="submit" class="btn btn-primary" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}">
  									<i class="fa fa-floppy-o"></i> Crear  
								</button>
							</fieldset>
						</g:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		 <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
	</body>
</html>
