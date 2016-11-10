<%@ page import="com.sd.uni.labpatologia.patient.PatientController" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="container-fluid">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Detalles del Paciente</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<g:if test="${patientInstance?.name}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}"  field="name"/>
							
								</g:if>
							</div>
                            <div class="col-md-6">
								<g:if test="${patientInstance?.lastName}">
								<label>Apellido<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}"  field="lastName"/>
							
								</g:if>
							</div>
                            <div class="col-md-6">
								<g:if test="${patientInstance?.document}">
								<label>C.I<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}"  field="document"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.sex}">
								<label>Sexo<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}"  field="sex"/>
							
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.birthDate}">
								<label>Fecha de Nac.<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}" field="birthDate"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.address}">
								<label>Dirección<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}"  field="address"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${patientInstance?.phone}">
								<label>Teléfono<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${patientInstance}" field="phone"/>
								</g:if>
							</div>
						
						</div>
						<g:form>
							</br>
							<fieldset class="buttons">
							<g:link class="btn btn-success" action="edit" id="${patientInstance?.id}"><i class="fa fa-pencil"></i> Editar</g:link>
							<g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'Eliminar')}" onclick="return confirm('${message(code: 'Estas seguro que quieres eliminarlo?')}');"  />
							</fieldset>
						</g:form>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>