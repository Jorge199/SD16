<div class="row">
	<div class="col-md-6">
	<!-- selector paciente -->
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'patient', 'error')} required">
			<label for="patient">
			<g:message code="Paciente" />
			<span class="required-indicator">*</span>
			</label>
		<g:select id="patient" name="patientId" from="${patients}" optionKey="id" optionValue="name" required="" value="${requestInstance?.patient?.id}" class="many-to-one"/>
		</div>	
	</div>
	<div class="col-md-6">
	<!-- selector estudio -->
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'studyType', 'error')} required">
			<label for="studyType">
			<g:message code="Tipo de estudio" />
			<span class="required-indicator">*</span>
			</label>
		<g:select id="studyType" name="studyTypeId" from="${studies}" optionKey="id" optionValue="name" required="" value="${requestInstance?.studyType?.id}" class="many-to-one"/>
		</div>
	</div>
	<div class="col-md-6">
	<!-- selector doctor -->
		<div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'doctor', 'error')} required">
			<label for="doctor">
			<g:message code="Doctor" />
			<span class="required-indicator">*</span>
			</label>
		<g:select id="doctor" name="doctorId" from="${doctors}" optionKey="id" optionValue="name" required="" value="${requestInstance?.doctor?.id}" class="many-to-one"/>
		</div>
		</div>
	<div class="col-md-6">
		<label>Observacion<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="note" value="${requestInstance?.note}"/>
	</div>
</div>