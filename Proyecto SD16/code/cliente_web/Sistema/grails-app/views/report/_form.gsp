<%@ page import="com.sd.uni.labpatologia.util.DiagnosticEnum"%>
<%@ page import="java.text.SimpleDateFormat"%>
<head>
<ckeditor:resources />
</head>

				<h4><p style="text-align: center">INFORME DE ANATOMIA PATOLOGICA</p></h4>

<fieldset>
	<legend>Datos de la Solicitud</legend>

	<div class="col-md-6">
		<label> Código:</label>

		${reportInstance?.request?.code}
		<g:hiddenField class="form-control" name="requestId"
			value="${reportInstance?.request?.id}" />
		<g:hiddenField class="form-control" name="statisticId"
			value="${reportInstance?.statistic?.id}" />
		<g:hiddenField class="form-control" name="isProcessed"
			value="${reportInstance?.isProcessed}" />
	</div>
	<div class="col-md-6">
		<label>Fecha de Solicitud:</label>
		<g:formatDate date="${reportInstance?.request?.date}"
			format='dd/MM/yyyy' />
	</div>
</fieldset>
<br>
<fieldset>
	<legend>Datos del Doctor</legend>

	<div class="col-md-6">
		<label> Nombre y Apellido:</label>
		${reportInstance?.request?.doctor?.name +" "+ reportInstance?.request?.doctor?.lastName}
	</div>
	<g:if test="${!reportInstance?.request?.doctor?.speciality.isEmpty()}">
		<div class="col-md-6">
			<label> Especialidad:</label>
			${reportInstance?.request?.doctor?.speciality}
		</div>
	</g:if>
	<g:if test="${!reportInstance?.request?.doctor?.phone.isEmpty()}">
		<div class="col-md-6">
			<label> Teléfono:</label>
			${reportInstance?.request?.doctor?.phone}
		</div>
	</g:if>

</fieldset>
<br>
<fieldset>
	<Legend>Datos del Paciente</Legend>


	<div class="col-md-6">
		<label> Nombre y Apellido:</label>
		${reportInstance?.request?.patient?.name +" "+ reportInstance?.request?.patient?.lastName}
	</div>
	<g:if test="${reportInstance?.request?.patient?.sex}">
		<div class="col-md-6">
			<label> Sexo:</label>
			${reportInstance?.request?.patient?.sex}

		</div>
	</g:if>


	<g:if test="${reportInstance?.request?.patient?.birthDate}">
		<div class="col-md-6">
			<label> Edad:</label>
			${reportInstance?.age}
			<g:hiddenField class="form-control" name="age" required=""
				value="${reportInstance?.age}" />

		</div>
	</g:if>
	<g:if test="${reportInstance?.request?.patient?.phone}">
		<div class="col-md-6">
			<label> Teléfono:</label>
			${reportInstance?.request?.patient?.phone}
		</div>
	</g:if>
	<g:if test="${reportInstance?.request?.patient?.mail}">
		<div class="col-md-6">
			<label> Correo:</label>
			${reportInstance?.request?.patient?.mail}
		</div>
	</g:if>
</fieldset>
<br>
<fieldset>
	<legend>Datos del Informe</legend>
	<div class="col-md-4">
		<label> Fecha del Informe:</label>
		<g:formatDate date="${new Date()}" class="form-control" name="date"
			type="date" value="${reportInstance?.date}" />
	</div>
	<div class="col-md-4">
		<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
			<label for="diagnostic"> <g:message code="Diagnostico" /> <span
				class="required-indicator">*</span>
			</label>
			<g:select name="diagnostic" id="diagnostic" class="form-control"
				from="${DiagnosticEnum.values()}"
				value="${reportInstance?.diagnostic}" optionKey="key" 
				noSelection="${['SIN_INDICIOS':'Seleccione un diagnostico..']}"></g:select>
		</div>
	</div>
	<div class="col-md-4">
		<label>Descripción</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="25" id="diagnosticDetail"
			id="diagnosticDetail" name="diagnosticDetail" placeholder="Descripción del Diagnóstico" value="${reportInstance?.diagnosticDetail}" />
		</div>
	</div>
	<div class="col-md-12">
		<label> Informe <span class="required-indicator">*</span>
		</label>
		<div class="form-group">
		<textarea class="form-control" rows="10" id="observations" name="observations" placeholder="Ingrese el Informe">
			<g:if test="${null!=reportInstance?.observations}">
				${reportInstance?.observations}
			</g:if>
			<g:else>
MACROSCOPÍA

Tipo de Estudio: ${reportInstance?.request?.studyType?.name}
	
Material/es: ${reportInstance?.request?.specimen}

DIAGNÓSTICO
			</g:else>
			</textarea>
		</div>
	</div>

</fieldset>
<div class="row"></div>

<script type="text/javascript">
$(document).ready(function () {
$(document).on('mousedown', '.cke_button__print', function(){
	alert("asd");
	CKEDITOR.instances.editor.setData( "<p>This is the editor data.</p>" );
    
    CKEDITOR.tools.callFunction(16,this);return false;

});


});
$(window).on('afterprint', function(){
	alert("asd");

});
	</script>
	
	

   
   
<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
