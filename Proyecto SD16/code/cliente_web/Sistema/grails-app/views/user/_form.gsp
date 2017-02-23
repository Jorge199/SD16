
<div class="row">

	<div class="col-md-6">
		<label>Nombre y Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50"
			id="name" name="name" placeholder="Ingrese un Nombre y Apellido" value="${userInstance?.name }"/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Nombre de Usuario<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50"
			id="userName" name="userName" placeholder="Ingrese un nombre de Usuario" value="${userInstance?.userName }"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-6" id="updatePass" style="display: none">
		<label>Constraseña<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="password" maxlength="16" 
			id="pass1" name="password"  placeholder="Ingrese la contraseña" value="${userInstance?.password}"/>
		</div>
	</div>
	
	<div class="col-md-6" id="confirmPass" style="display: none">
		<label>Repita la Constraseña<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="password" maxlength="16"
			id="password2" name="password2" placeholder="Vuelva a ingresar la contraseña" value="${userInstance?.password}"
			oninput="check(this)"/>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-3">
		<label>Rol <span class="required-indicator">*</span></label>
		<div class="form-group">
			<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR'>
				<g:select class="form-control" type="text" 
				id="updater" name="rolId" from="${rols}" value="${userInstance?.rol?.id}"
				optionKey="id" optionValue="name" 
				noSelection="${['':'Seleccione un rol..']}"/>
			</sec:ifAnyGranted>
			<sec:ifAnyGranted roles='ROLE_DOCTOR'>
				<g:select class="form-control" type="text" 
				id="updater" name="rolId" from="${rolsWithoutAdmin}" value="${userInstance?.rol?.id}"
				optionKey="id" optionValue="name" 
				noSelection="${['':'Seleccione un rol..']}"/>
			</sec:ifAnyGranted>
		</div>
	</div>
	
	<div class="col-md-3" id="update" style="display: none">
		<label>Matricula<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control numeric" type="text" maxlength="10"
			id="registrationNumber" name="registrationNumber" value="${userInstance?.registrationNumber}" />
		</div>
	</div>
</div>

<!-- estilo a la validacion -->
  	<style>
		input.error{
		    border: 2px dotted #FF0000; 
		}
		form label.error{
		    font-size: 1em;
		    color: #FF0000;
		    font-weight: bold;
		    display: inline-table;
		}
  	</style>
