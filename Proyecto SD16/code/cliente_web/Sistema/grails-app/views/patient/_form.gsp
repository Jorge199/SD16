<%@page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="name"
			placeholder="Ingrese un Nombre" value="${patientInstance?.name }" />
		</div>
	</div>
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:textField class="form-control" required="" maxlength="50" name="lastName"
			placeholder="Ingrese un Apellido"
			value="${patientInstance?.lastName }" />
		</div>
	</div>


	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
		<g:field type="text" class="form-control" 
            name="document" 
			placeholder="Ingrese un Número de Cédula" data-mask="**.999.999"
			value="${patientInstance?.document}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Dirección</label>
		<div class="form-group">
		<g:textField class="form-control" name="address" maxlength="50"
			placeholder="Ingrese una Dirección"
			value="${patientInstance?.address}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Teléfono</label> 
		<div class="form-group">
		<input type="text" class="form-control"
			id="phoneNum" maxlength="20" placeholder="Ingrese un Número"
			placeholder="Ingrese un Número" data-mask="(9999) 999-999"
			name="phone" value="${patientInstance?.phone}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Correo</label> 
		<div class="form-group">
		<g:field type="email" class="form-control" placeholder="ejemplo999@correo.com" 
		maxlength="50" name="mail" value="${patientInstance?.mail }"/>
	</div>
	
	<div class="col-md-6">
		<label class="col-md-4 form-label">Sexo</label>
		<div class="col-md-4">
			<div class="form-group">
				<label class="radio-inline"> 
					<g:radio name="sex" value="${SexEnum.MASCULINO}" checked="${patientInstance?.sex == SexEnum.MASCULINO }"/>
				 	${SexEnum.MASCULINO}
				</label>
				<label class="radio-inline"> 
					<g:radio name="sex" value="${SexEnum.FEMENINO}" checked="${patientInstance?.sex == SexEnum.FEMENINO }"/>
				 	${SexEnum.FEMENINO}
				</label>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<label>Fecha de Nacimiento</label>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
			<input type='text' class="form-control" name="birthDate"
				value="${formatDate(format: 'dd-MM-yyyy', date:patientInstance.getBirthDate())}" /> <span
				class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"> </span>
			</span>
			</div>
		</div>
	</div>
</div>

</div>
