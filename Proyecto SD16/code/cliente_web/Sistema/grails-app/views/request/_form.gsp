<%@ page import="com.sd.uni.labpatologia.util.StatusEnum" %>
<div class="row">

	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'patient', 'error')} required">
			<label for="patient">
			<g:message code="Paciente*" class="required-indicator"/>
			</label>
			<g:select  name="patientId" from="${patients}" value="${requestInstance?.patient}"
			optionKey="id" optionValue="name" required="" class="many-to-one"
		  	required=""/>
		</div>
	</div>
	
	<div class="col-md-6">
		<div class="form-group">
		<label for="date">
			<g:message code="Fecha*" class="required-indicator"/>
			<g:textField  required="" name="date" value="${requestInstance?.date}"/>
		</label>
		</div>	
	</div>

	<br></br>
	
	<div class="col-md-6">
		<label for="code">
			<g:message code="Codigo*" class="required-indicator"/>
			<g:textField  required="" name="code" value="${requestInstance?.code}"/>
		</label>
	</div>
	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'studyType', 'error')} required">
			<label for="studyType">
			<g:message code="Tipo de estudio" />
			<span class="required-indicator">*</span>
			</label>
			<g:select  name="studyTypeId" from="${studies}" value="${requestInstance?.studyType}"
			optionKey="id" optionValue="name" required="" class="many-to-one"
			required=""/>
		</div>
	</div>
	
	<br></br>
	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'doctor', 'error')} required">
			<label for="doctor">
			<g:message code="Doctor" />
			<span class="required-indicator">*</span>
			</label>
			<g:select name="doctorId" from="${doctors}"  value="${requestInstance?.doctor}"
			optionKey="id" optionValue="name" required="" class="many-to-one"/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label for="note">
			<g:message code="Observacion*" class="required-indicator"/>
			<g:textField  required="" name="note" value="${requestInstance?.note}"/>
		</label>
	</div>
	
	<br></br>

	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'status', 'error')} required">
			<label for="status">
			<g:message code="Estado" />
			<span class="required-indicator">*</span>
			</label>
			<g:select name="status" from="${StatusEnum.values()}" value="${StatusEnum}" optionKey="key"
			required=""></g:select>
		</div>
	</div>


</div>
