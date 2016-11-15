
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
		<g:passwordField class="form-control" required="" name="password" id="pass1" value="${userInstance?.password }"
			placeholder="Ingrese la contraseña" />
	</div>
	<div class="col-md-6">
		<label>Repita la Constraseña<span class="required-indicator">*</span></label>
		<g:passwordField class="form-control" required="" name="password2" oninput="check(this)" value="${userInstance?.password }"
			placeholder="Vuelva a ingresar la contraseña" />
	</div>

	<div class="col-md-3">
				<label>Rol <span class="required-indicator">*</span></label>
				<g:select id="updater" class="form-control" name="rolId" from="${rols}" value="${userInstance?.rol?.id}"
				optionKey="id" optionValue="name" required=""
				noSelection="${['':'Seleccione un rol..']}"/>
		</div>
	<div class="col-md-3" id="update">
		<label>Matricula<span class="required-indicator">*</span></label>
		<g:field class="form-control" type="number"
			name="registrationNumber" value="${userInstance?.registrationNumber}" />
	</div>







</div>
