
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text"  maxlength="50" pattern="^[a-zA-Z ]+$"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${diagnosticInstance?.name }"
			title='No se deben poner numeros o caracteres especiales'/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Descripción</label> 
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50" pattern="^[a-zA-Z ]+$"
			id="description" name="description" placeholder="Ingrese una Descripción" value="${diagnosticInstance?.description }" 
			title='No se deben poner numeros o caracteres.' />
		</div>
	</div>
</div>