<%@page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" maxlength="50" name="name"
			placeholder="Ingrese un Nombre" value="${patientInstance?.name }" />
	</div>
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" maxlength="50" name="lastName"
			placeholder="Ingrese un Apellido"
			value="${patientInstance?.lastName }" />
	</div>


	<div class="col-md-6">
		<label>C.I</label>
		<g:field type="number" class="form-control" 
                        min="100000" max="100000000"  name="document"
			placeholder="Ingrese un Número de Cédula"
			value="${patientInstance?.document}" />
	</div>
	<div class="col-md-6">
		<label>Dirección</label>
		<g:textField class="form-control" name="address" maxlength="50"
			placeholder="Ingrese una Dirección"
			value="${patientInstance?.address}" />
	</div>
	<div class="col-md-6">
		<label>Teléfono</label> <input type="text" class="form-control"
			id="phoneNum" maxlength="20" placeholder="Ingrese un Número"
			placeholder="Ingrese un Número" data-mask="(9999) 999-999"
			name="phone" value="${patientInstance?.phone}" />
	</div>
	<div class="col-md-3">
		<label class="col-md-4 form-label">Sexo</label>
		<div class="col-md-9">

			<g:if
				test="${SexEnum.valueOf("FEMENINO").equals(patientInstance?.sex)}">
				<label class="radio-inline"> <input id="sex"
					value="MASCULINO" name="sex" type="radio"
					value="${patientInstance?.sex}"> ${SexEnum.MASCULINO}</label>
				<label class="radio-inline"> <input id="sex"
					value="FEMENINO" name="sex" type="radio"
					value="${patientInstance?.sex}" checked> ${SexEnum.FEMENINO}</label>
			</g:if>
			<g:elseif
				test="${SexEnum.valueOf("MASCULINO").equals(patientInstance?.sex)}">
				<label class="radio-inline"> <input id="sex"
					value="MASCULINO" name="sex" type="radio"
					value="${patientInstance?.sex}" checked> ${SexEnum.MASCULINO}</label>
				<label class="radio-inline"> <input id="sex"
					value="FEMENINO" name="sex" type="radio"
					value="${patientInstance?.sex}"> ${SexEnum.FEMENINO}</label>
			</g:elseif>
			<g:else>
				<label class="radio-inline"> <input id="sex"
					value="MASCULINO" name="sex" type="radio"
					value="${patientInstance?.sex}"> ${SexEnum.MASCULINO}</label>
				<label class="radio-inline"> <input id="sex"
					value="FEMENINO" name="sex" type="radio"
					value="${patientInstance?.sex}"> ${SexEnum.FEMENINO}</label>

			</g:else>
		</div>
	</div>
	<div class="col-md-3">
		<label>Fecha de Nacimiento</label>
		<div class='input-group date' id='datetimepicker1'>
			<input type='text' class="form-control" name="birthDate"
				value="${patientInstance?.birthDate}" /> <span
				class="input-group-addon"> <span
				class="glyphicon glyphicon-calendar"> </span>
			</span>
		</div>
	</div>
</div>