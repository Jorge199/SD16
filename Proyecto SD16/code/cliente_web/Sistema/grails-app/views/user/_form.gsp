
<div class="row">

	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="name" value="${userInstance?.name }"/>
	
	<div class="col-md-6">
		<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'rol', 'error')} required">
	
		<label for="rol"> Rol <span class="required-indicator">*</span></label>
			<g:message code="user.rol.label" default="Rol" />
			<span class="required-indicator">*</span>
		</label>
		<g:select id="rol" name="rolId" from="${rols}" optionKey="id" optionValue="name" required="" value="${userInstance?.rol?.id}" class="many-to-one"/>
	
	<div class="col-md-6">
		<label>Constraseña<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="password" value="${userInstance?.password}"/>
	</div>
	
	</div>
	
	
</div>
