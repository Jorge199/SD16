
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text"  maxlength="50" pattern="^[a-zA-Z ]+$"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${doctorInstance?.name }"
			title='No se deben poner numeros o caracteres especiales'/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label> 
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50" pattern="^[a-zA-Z ]+$"
			id="last_name" name="last_name" placeholder="Ingrese un Apellido" value="${doctorInstance?.lastName }" 
			title='No se deben poner numeros o caracteres.' />
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="15"
			id="ci" name="ci" placeholder="Ingrese un número de Cédula" value="${doctorInstance?.ci}"/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Sexo<span class="required-indicator">*</span></label>
			<div class="form-group">
				<div class="col-md-3"> 
					<g:radio id="sex" name="sex" value="${SexEnum.MASCULINO}" checked="${doctorInstance?.sex == SexEnum.MASCULINO }"/>
				 	${SexEnum.MASCULINO}
				</div>
				<div class="col-md-3"> 
					<g:radio id="sex" name="sex" value="${SexEnum.FEMENINO}" checked="${doctorInstance?.sex == SexEnum.FEMENINO }"/>
				 	${SexEnum.FEMENINO}
				</div>
			</div>
	</div>
	
</div>

<div class="row">
<div class="col-md-6">
		<label>Especialidad</label> 
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="20"
			id="speciality" name="speciality" placeholder="Ingrese una Especialidad" value="${doctorInstance?.speciality}"/>
		</div>
	</div>
	<div class="col-md-6">
		<label>Teléfono</label> 
		<div class="form-group">
			<input class="form-control numeric" type="text" maxlength="17"
			id="phone" name="phone" placeholder="Ingrese un Número" value="${doctorInstance?.phone}"/>
		</div>
	</div>
	
	
</div>

<div class="row">
<div class="col-md-6">
		<label>Correo</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50" 
			id="email" name="email" placeholder="ejemplo999@correo.com" value="${doctorInstance?.email}" />
		</div>
	</div>
	<div class="col-md-6">
		<label>Dirección</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50" 
			id="address" name="address" placeholder="Ingrese una Dirección" value="${doctorInstance?.address}" />
		</div>
	</div>
</div>

	

