
<div class="row">

	<div class="col-md-6">
		<label>Nombre y Apellido<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="name"
			value="${userInstance?.name }"
			placeholder="Ingrese un Nombre y Apellido" />
	</div>
	<div class="col-md-6">
		<label>Nombre de Usuario<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="userName"
			value="${userInstance?.userName }"
			placeholder="Ingrese un nombre de Usuario" />
	</div>
	<div class="col-md-6">
		<label>Constraseña<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="password"
			placeholder="Ingrese la contraseña" />
	</div>
	<div class="col-md-6">
		<label>Repita la Constraseña<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="password2"
			placeholder="Vuelva a ingresar la contraseña" />
	</div>

	<div class="col-md-4">
				<label>Rol <span class="required-indicator">*</span></label>
				<g:select  class="form-control" name="rolId" from="${rols}" value="${userInstance?.rol?.id}"
				optionKey="id" optionValue="name" required=""
				noSelection="${[1:'Seleccione un rol..']}"/>
		</div>
	<div class="col-md-3">
		<label>Matricula<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required=""
			name="registrationNumber" value="${userInstance?.registrationNumber}" />
	</div>







</div>
