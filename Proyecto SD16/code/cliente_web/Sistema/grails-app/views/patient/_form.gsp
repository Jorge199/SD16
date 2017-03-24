
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>


<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${patientInstance?.name }"/>
		</div>
	</div>
		
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50"
			id="lastName" name="lastName" placeholder="Ingrese un Apellido" value="${patientInstance?.lastName }"/>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="15"
			id="document" name="document" placeholder="Ingrese un Número de Cédula" value="${patientInstance?.document}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Dirección</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50"
			id="address" name="address" placeholder="Ingrese una Dirección" value="${patientInstance?.address}" />
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<label>Teléfono</label> 
		<div class="form-group">
			<input class="form-control numeric" type="text" maxlength="17"
			id="phone" name="phone" placeholder="Ingrese un Número" value="${patientInstance?.phone}"
			/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Correo</label> 
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50"
			id="mail" name="mail" placeholder="ejemplo999@correo.com" value="${patientInstance?.mail }"/>
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-6">
		<label>Sexo<span class="required-indicator">*</span></label>
			<div class="form-group">
				<div class="col-md-3"> 
					<g:radio id="sex" name="sex" value="${SexEnum.MASCULINO}" checked="${patientInstance?.sex == SexEnum.MASCULINO }"/>
				 	${SexEnum.MASCULINO}
				</div>
				<div class="col-md-3"> 
					<g:radio id="sex" name="sex" value="${SexEnum.FEMENINO}" checked="${patientInstance?.sex == SexEnum.FEMENINO }"/>
				 	${SexEnum.FEMENINO}
				</div>
			</div>
	</div>
	
	<div class="col-md-6">
		<label>Fecha de Nacimiento</label>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker4'>
				<input class="form-control" type="text" maxlength="10"
				id="birthDate" name="birthDate" placeholder="Seleccione la fecha" value="${formatDate(format: 'dd-MM-yyyy', date:patientInstance?.getBirthDate())}"/> 
				<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"> </span></span>
			</div>
		</div>
	</div>
</div>

 
	

	


