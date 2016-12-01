
<div class="row">

	<div class="col-md-6">
		<label>Nombre y Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:textField class="form-control" required="" name="name"
			value="${userInstance?.name }"
			placeholder="Ingrese un Nombre y Apellido" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Nombre de Usuario<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:textField class="form-control" required="" name="userName"
			value="${userInstance?.userName }"
			placeholder="Ingrese un nombre de Usuario" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Constraseña<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:passwordField class="form-control" required="" name="password" id="pass1" value=""
			placeholder="Ingrese la contraseña" />
		</div>
	</div>
	<div class="col-md-6">
		<label>Repita la Constraseña<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:passwordField class="form-control" required="" name="password2" oninput="check(this)" value=""
			placeholder="Vuelva a ingresar la contraseña" />
		</div>
	</div>

	<div class="col-md-3">
				<label>Rol <span class="required-indicator">*</span></label>
				<div class="form-group">
				<g:select id="updater" class="form-control" name="rolId" from="${rols}" value="${userInstance?.rol?.id}"
				optionKey="id" optionValue="name" required=""
				noSelection="${['':'Seleccione un rol..']}"/>
				</div>
		</div>
	<div class="col-md-3" id="update" style="display: none">
		<label>Matricula<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:field class="form-control" type="number"
			name="registrationNumber" value="${userInstance?.registrationNumber}" />
		</div>
	</div>
</div>
