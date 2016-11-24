<%@ page contentType="text/html;charset=UTF-8"%>

<div class="row">
	<div class="col-md-6">
		<div class="form-group">
			<label>Nombre<span class="required-indicator">*</span></label> <input
				type="text" class="form-control" required=""
				placeholder="Ingrese un Nombre" maxlength="50" name="name"
				value="${articleInstance?.name }" />
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<label>Descripcion<span class="required-indicator">*</span></label> <input
				type="text" class="form-control" required=""
				placeholder="Ingrese una descripcion" maxlength="50"
				name="description" value="${articleInstance?.description }" />
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<label>Unidades</label> <input type="text" class="form-control"
				maxlength="20" title='Ingrese Unidad'
				placeholder="Ingrese las unidades" name="units"
				value="${articleInstance?.units}" />
		</div>
	</div>
</div>