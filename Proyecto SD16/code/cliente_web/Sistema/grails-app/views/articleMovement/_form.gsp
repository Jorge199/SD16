<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.sd.uni.labpatologia.util.MovementTypeEnum"%>

<div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <label>Articulo <span class="required-indicator">*</span></label>
            <g:select class="form-control selectpicker many-to-one" 
            id="articleId" type="text"
            data-live-search="true" name="articleId" from="${articles}"
            value="${ArticleMovementInstance?.article?.id}" optionKey="id" optionValue="name" 
            noSelection="${['':'Seleccione un articulo..']}" />
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <label for="movementType"> <g:message
                    code="Tipo de movimiento" /> <span class="required-indicator">*</span>
            </label>
                <g:select name="movementType" class="form-control"
                id="movementType" type="text"
                from="${MovementTypeEnum.values()}"
                value="${articleMovementInstance?.movementType}" optionKey="key"
                noSelection="${['':'Seleccione un tipo de movimiento..']}"/>
           </div>
    </div>
</div>
	<div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Cantidad</label> 
                <input type="number" class="form-control"
                min="1" max="2147483646"  
                placeholder="Ingrese la cantidad" name="quantity" id="quantity"
                value="${articleMovementInstance?.quantity}" />
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