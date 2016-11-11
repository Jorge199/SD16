
<div class="row">

	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="name" value="${userInstance?.name }"/>
	
	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'rol', 'error')} required">
	
		<label>Rol<span class="required-indicator">*</span></label>
		
		<g:select class="form-control" id="rol" name="rolId" from="${rols}" optionKey="id" optionValue="name" required="" value="${userInstance?.rol?.id}"/>
		</div>
	</div>
	<div class="col-md-6">
		<label>Constraseña<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="password" value="${userInstance?.password}"/>
	</div>
	
	
	<div class="col-md-6">
		<label>¿Eres doctor?<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="doctor" value="${userInstance?.doctor}"/>
	</div>
	
	
	<div class="col-md-6">
		<label>Matricula<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="matricula" value="${userInstance?.matricula}"/>
	</div>
	
	
	
	
	
	
	
</div>
