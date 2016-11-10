
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
        <div class="container-fluid">
        	<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Editar Información del Usuario</strong></h4>
					</div>
					<div class="panel-body">
							<div class="row">
							<div class="col-md-6">
								<g:if test="${userInstance?.name}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${userInstance}"  name="name"/>
							
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${userInstance?.password}">
								<label>Direcciòn<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${userInstance}"  name="password"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${userInstance?.rol}">
								<label>Contraseña<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${userInstance}" name="rol"/>
								</g:if>
							</div>
							
						</div>
						<g:form method="post" >
							<g:hiddenField name="id" value="${userInstance?.id}" />
							</br>
							<fieldset class="buttons">
								<g:actionSubmit class="btn btn-primary" action="update" value="${message(code: 'Actualizar')}" />
		
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
		
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

</html>

