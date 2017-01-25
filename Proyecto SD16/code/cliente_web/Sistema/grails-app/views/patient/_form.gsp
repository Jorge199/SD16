<%@page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>


<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${patientInstance?.name }"/>
		</div>
	</div>
		
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50"
			id="lastName" name="lastName" placeholder="Ingrese un Apellido" value="${patientInstance?.lastName }"/>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="10"
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
			<input class="form-control" type="text" maxlength="19"
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
				<input class="form-control" type="text" maxlength="10"
				id="birthDate" name="birthDate" placeholder="Seleccione la fecha" value="${formatDate(format: 'dd-MM-yyyy', date:patientInstance?.getBirthDate())}"/> 
				<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"> </span></span>
			</div>
		</div>
	</div>
</div>
<!-- formato a telefono y documento -->
  	<script type="text/javascript">	
		$(function(){
			$('#phone').number(true, 0 ,',','-');
		});
		
	</script>
	<script type="text/javascript">
		$('#document').on('input', function() {
			if(!isNaN($("#document").val())){
			    var doc = $(this).val().replace(/[^\d]/g, '')
			    if (doc.length == 7) {
			      doc = doc.replace(/(\d{1})(\d{3})(\d{3})/, "$1.$2.$3");
			    } else if (doc.length == 6) {
			      doc = doc.replace(/(\d{3})(\d{3})/, "$1.$2");
			    }
			    $(this).val(doc)
			}
		 });
	</script>
	
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


