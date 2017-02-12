
<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text"  maxlength="50" pattern="^[a-zA-Z ]+$"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${doctorInstance?.name }"
			title='No se deben poner numeros o caracteres especiales'/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label> 
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50" pattern="^[a-zA-Z ]+$"
			id="last_name" name="last_name" placeholder="Ingrese un Apellido" value="${doctorInstance?.lastName }" 
			title='No se deben poner numeros o caracteres.' />
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="10"
			id="ci" name="ci" placeholder="Ingrese un número de Cédula" value="${doctorInstance?.ci}"/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Sexo<span class="required-indicator">*</span></label>
			<div class="form-group">
				<label class="radio-inline"> 
					<g:radio id="sex" name="sex" value="${SexEnum.MASCULINO}" checked="${doctorInstance?.sex == SexEnum.MASCULINO }"/>
				 	${SexEnum.MASCULINO}
				</label>
				<label class="radio-inline"> 
					<g:radio id="sex" name="sex" value="${SexEnum.FEMENINO}" checked="${doctorInstance?.sex == SexEnum.FEMENINO }"/>
				 	${SexEnum.FEMENINO}
				</label>
			</div>
	</div>
	
</div>

<div class="row">
<div class="col-md-6">
		<label>Especialidad</label> 
		<div class="form-group">
			<input class="form-control" type="text" maxlength="20"
			id="speciality" name="speciality" placeholder="Ingrese una Especialidad" value="${doctorInstance?.speciality}"/>
		</div>
	</div>
	<div class="col-md-6">
		<label>Teléfono</label> 
		<div class="form-group">
			<input class="form-control" type="text" maxlength="19"
			id="phone" name="phone" placeholder="Ingrese un Número" value="${doctorInstance?.phone}"/>
		</div>
	</div>
	
	
</div>

<div class="row">
<div class="col-md-6">
		<label>Correo</label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50" 
			id="email" name="email" placeholder="Ingrese un correo" value="${doctorInstance?.email}" />
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
<!-- formato a telefono y documento -->
  	<script type="text/javascript">	
		$(function(){
			$('#phone').number(true, 0 ,',','-');
		});
		
	</script>
	<script type="text/javascript">
		$('#ci').on('input', function() {
			if(!isNaN($("#ci").val())){
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
	

