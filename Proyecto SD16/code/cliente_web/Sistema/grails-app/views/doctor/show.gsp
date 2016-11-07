<%@ page import="com.sd.uni.labpatologia.doctor.DoctorController" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'doctor.label', default: 'Doctor')}" />
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
						<h4><strong>Detalles del Doctor</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<g:if test="${doctorInstance?.name}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${doctorInstance}"  field="name"/>
							
								</g:if>
							</div>
                                                        <div class="col-md-6">
								<g:if test="${doctorInstance?.last_name}">
								<label>Apellido<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${doctorInstance}"  field="last_name"/>
							
								</g:if>
							</div>
                                                        <div class="col-md-6">
								<g:if test="${doctorInstance?.ci}">
								<label>C.I<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${doctorInstance}"  field="ci"/>
							
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${doctorInstance?.address}">
								<label>Direcciòn<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${doctorInstance}"  field="address"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${doctorInstance?.email}">
								<label>Correo<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${doctorInstance}" field="email"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${doctorInstance?.phone}">
								<label>Telèfono<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${doctorInstance}" field="phone"/>
								</g:if>
							</div>
						
						</div>
						<g:form>
							</br>
							<fieldset class="buttons">
							<g:link class="btn btn-success" action="edit" id="${doctorInstance?.id}"><i class="fa fa-pencil"></i> Editar</g:link>
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