
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
        <div class="container-fluid">
        	<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${patientInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${patientInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Editar datos del Paciente</strong></h4>
					</div>
					<div class="panel-body">
							<div class="row">
							<div class="col-md-6">
								<g:if test="${patientInstance?.name}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}"  name="name"/>
							
								</g:if>
							</div>
                            <div class="col-md-6">
								<g:if test="${patientInstance?.lastName}">
								<label>Apellido<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}"  name="lastName"/>
								</g:if>
							</div>
                            <div class="col-md-6">
								<g:if test="${patientInstance?.document}">
								<label>C.I<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}"  name="document"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.sex}">
								<label>Sexo<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}" name="sex"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.birthDate}">
								<label>Fecha de Nac.<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}" name="birthDate"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.address}">
								<label>Dirección<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}"  name="address"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.phone}">
								<label>Teléfono<span class="required-indicator">*</span></label>
								<g:textField class="form-control" bean="${patientInstance}" name="phone"/>
								</g:if>
							</div>
						</div>
						<g:form method="post" >
							<g:hiddenField name="id" value="${patientInstance?.id}" />
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
