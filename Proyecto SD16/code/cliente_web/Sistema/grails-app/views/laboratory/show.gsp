<%@ page import="com.sd.uni.labpatologia.laboratory.LaboratoryController" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'laboratory.label', default: 'Laboratory')}" />
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
						<h4><strong>Información del Laboratorio</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.name}">
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${laboratoryInstance}"  field="name"/>
							
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.address}">
								<label>Direcciòn<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${laboratoryInstance}"  field="address"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.email}">
								<label>Correo<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${laboratoryInstance}" field="email"/>
								</g:if>
							</div>
							<div class="col-md-6">
								<g:if test="${laboratoryInstance?.phone}">
								<label>Telèfono<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${laboratoryInstance}" field="phone"/>
								</g:if>
							</div>
						
						</div>
						<g:form>
							</br>
							<fieldset class="buttons">
							<g:link class="btn btn-success" action="edit" id="${laboratoryInstance?.id}"><i class="fa fa-pencil"></i> Editar</g:link>
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
