<%@page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>


<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${patientInstance?.name }"/>
		</div>
	</div>
		
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text"
			id="lastName" name="lastName" placeholder="Ingrese un Apellido" value="${patientInstance?.lastName }"/>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
			<input class="form-control" type="text"
			id="document" name="document" placeholder="Ingrese un Número de Cédula" value="${patientInstance?.document}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Dirección</label>
		<div class="form-group">
			<input class="form-control" type="text"
			id="address" name="address" placeholder="Ingrese una Dirección" value="${patientInstance?.address}" />
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<label>Teléfono</label> 
		<div class="form-group">
			<input class="form-control" type="text"
			id="phone" name="phone" placeholder="Ingrese un Número" value="${patientInstance?.phone}"
			/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Correo</label> 
		<div class="form-group">
			<input class="form-control" type="text"
			id="mail" name="mail" placeholder="ejemplo999@correo.com" value="${patientInstance?.mail }"/>
		</div>
	</div>
</div>
<div class="row">	
	<div class="col-md-6">
		<label>Sexo</label>
			<div class="form-group">
				<label class="radio-inline"> 
					<g:radio id="sex" name="sex" value="${SexEnum.MASCULINO}" checked="${patientInstance?.sex == SexEnum.MASCULINO }"/>
				 	${SexEnum.MASCULINO}
				</label>
				<label class="radio-inline"> 
					<g:radio id="sex" name="sex" value="${SexEnum.FEMENINO}" checked="${patientInstance?.sex == SexEnum.FEMENINO }"/>
				 	${SexEnum.FEMENINO}
				</label>
			</div>
	</div>
	
	<div class="col-md-6">
		<label>Fecha de Nacimiento</label>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
				<input class="form-control" type="text"
				id="birthDate" name="birthDate" placeholder="Seleccione la fecha" value="${formatDate(format: 'dd-MM-yyyy', date:patientInstance?.getBirthDate())}"/> 
				<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"> </span></span>
			</div>
		</div>
	</div>
</div>



