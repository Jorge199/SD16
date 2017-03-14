
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text"  maxlength="50" pattern="^[a-zA-Z ]+$"
			id="name" name="name" placeholder="Ingrese un Nombre" value="${diagnosticInstance?.name }"/>
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Descripción<span class="required-indicator">*</span></label> 
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50" pattern="^[a-zA-Z ]+$"
			id="description" name="description" placeholder="Ingrese una Descripción" value="${diagnosticInstance?.description }" />
		</div>
	</div>
</div>


