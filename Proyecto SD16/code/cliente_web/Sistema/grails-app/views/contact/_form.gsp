<div class="col-md-6">

	<div>
		<label>Nombre y Apellido<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50"
			id="userName" name="userName" placeholder="Ingrese un Nombre y Apellido" value="${userName}" disabled/>
		</div>
	</div>
	
	<div>
		<label>Teléfono<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control numeric" type="text" maxlength="17"
			id="phone" name="phone" placeholder="Ingrese un Número"/>
		</div>
	</div>
	
	<div>
		<label>Correo<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control" type="text" maxlength="50"
			id="email" name="email" placeholder="ejemplo999@correo.com"/>
		</div>
	</div>
	
	<div>
		<label>Asunto<span class="required-indicator">*</span></label>
		<div class="form-group">
			<input class="form-control letter" type="text" maxlength="50"
			id="subject" name="subject" placeholder="Ingrese su asunto"/>
		</div>
	</div>
	
	<div>
		<label>Mensaje <span class="required-indicator">*</span></label>
		<div class="form-group">
		<g:textArea class="form-control" rows="5" cols="40" class="form-control"
			id="message" name="message" maxlength="250"
			placeholder="Ingrese su mensaje" />
			</div>
	</div>
	
</div>

