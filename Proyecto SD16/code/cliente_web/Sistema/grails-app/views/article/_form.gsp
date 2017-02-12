<%@ page contentType="text/html;charset=UTF-8"%>

<div class="row">
	<div class="col-md-6">
		<div class="form-group">
			<label>Nombre<span class="required-indicator">*</span></label> 
				<input class="form-control" type="text" maxlength="50"
				id="name" name="name" placeholder="Ingrese un Nombre" value="${articleInstance?.name }" />
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<label>Unidades*</label> 
				<input class="form-control" type="text" maxlength="40" 
				id="units" name="units" placeholder="Ingrese las unidades" value="${articleInstance?.units}" />
		</div>
	</div>
</div>

<div class="row">
<div class="col-md-6">
		<div class="form-group">
			<label>Descripción</label> 
                        <g:textArea class="form-control" rows="5" cols="40" class="form-control"
				name="description" maxlength="100" id="description"
				placeholder="Ingrese sus observaciones"
				value="${articleInstance?.description}" />
		</div>
	</div>
</div>

