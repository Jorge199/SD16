
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'laboratory.label', default: 'Laboratory')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
        <div class="container-fluid">
        	<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${laboratoryInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${laboratoryInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Editar Información del Laboratorio</strong></h4>
					</div>
					<div class="panel-body">
							<div class="row">
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.name}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${laboratoryInstance}"  name="name"/>
							
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.address}">
								<label>Direcciòn<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${laboratoryInstance}"  name="address"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.email}">
								<label>Correo<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${laboratoryInstance}" name="email"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.phone}">
								<label>Telèfono<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${laboratoryInstance}" name="phone"/>
								</g:if>
							</div>
						</div>
						<g:form method="post" >
							<g:hiddenField name="id" value="${laboratoryInstance?.id}" />
							</br>
							<fieldset class="buttons">
								<g:actionSubmit class="btn btn-success" action="update" value="${message(code: 'Actualizar')}" />
								<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'Eliminar')}" formnovalidate="" onclick="return confirm('${message(code: 'Estas seguro que quieres eliminarlo?')}');" />
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
		
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

</html>