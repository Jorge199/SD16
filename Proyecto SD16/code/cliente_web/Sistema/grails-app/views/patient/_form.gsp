<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="name" value="${patientInstance?.name }"/>
	</div>
        <div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="lastName" value="${patientInstance?.lastName }"/>
	</div>
        <div class="col-md-6">
		<label>C.I<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="document" value="${patientInstance?.document}"/>
	</div>
	<div class="col-md-6">
		<label>Sexo<span class="required-indicator">*</span></label>
		<g:select class="form-control" required="" name="sex" from="${['Masculino', 'Femenino']}"value="${patientInstance?.sex}"/>
	</div>
	<div class="col-md-6">
		<label>Fecha de Nac.<span class="required-indicator">*</span></label>
		<g:textField class = "form-control" required="" name="birthDate"  value="${patientInstance?.birthDate}"/>
	</div>
	<div class="col-md-6">
		<label>Dirección<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="address" value="${patientInstance?.address}"/>
	</div>
	<div class="col-md-6">
		<label>Teléfono<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="phone" value="${patientInstance?.phone}"/>
	</div>
</div>