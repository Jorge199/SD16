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
			<label>Unidades</label> 
				<input class="form-control" type="text" maxlength="10" 
				id="units" name="units" placeholder="Ingrese las unidades" value="${articleInstance?.units}" />
		</div>
	</div>
</div>

<div class="row">
<div class="col-md-6">
		<div class="form-group">
			<label>Descripcion<span class="required-indicator">*</span></label> 
				<!--<input class="form-control" type="text" maxlength="50"
				id="description" name="description" placeholder="Ingrese una descripcion" value="${articleInstance?.description }" />-->
                        <g:textArea class="form-control" rows="5" cols="40" class="form-control"
				name="description" maxlength="100" id="description"
				placeholder="Ingrese sus observaciones"
				value="${articleInstance?.description}" />
		</div>
	</div>
</div>

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