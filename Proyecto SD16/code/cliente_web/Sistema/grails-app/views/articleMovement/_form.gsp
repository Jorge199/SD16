<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.sd.uni.labpatologia.util.MovementTypeEnum"%>

<div class="row">
    <div class="col-md-6">
        <div class="form-group">
            <label>Articulo <span class="required-indicator">*</span></label>
            <g:select class="form-control selectpicker many-to-one"
            data-live-search="true" name="articleId" from="${articles}"
            value="${ArticleMovementInstance?.article?.id}" optionKey="id"
                optionValue="name" required=""
            noSelection="${['':'Seleccione un articulo..']}" />
        </div>
    </div>
    <!--<div class="col-md-6">
    <label>Tipo de movimiento<span class="required-indicator">*</span></label> <input
    type="text" class="form-control" required="" placeholder="Ingrese el tipo de movimiento"
    maxlength="50"
    name="movementType" value="${articleMovementInstance?.movementType }" />
</div>-->
    <div class="col-md-6">
        <div class="form-group">
            <label for="movementType"> <g:message
                    code="Tipo de movimiento" /> <span class="required-indicator">*</span>
                </label>
                <g:select name="movementType" class="form-control selectpicker"
                from="${MovementTypeEnum.values()}"
                value="${articleMovementInstance?.movementType}" optionKey="key"
                    required=""
                noSelection="${['':'Seleccione un tipo de movimiento..']}">
                </g:select>

                        <!--<label class="radio-inline"> 
            <g:radio name="movementType" value="${MovementTypeEnum.ENTRADA}" checked="${ArticleMovementInstance?.movementType == MovementTypeEnum.ENTRADA }"/>
            ${MovementTypeEnum.ENTRADA}
        </label>
        <label class="radio-inline"> 
            <g:radio name="movementType" value="${MovementTypeEnum.SALIDA}" checked="${ArticleMovementInstance?.movementType == MovementTypeEnum.SALIDA }"/>
            ${MovementTypeEnum.SALIDA}
        </label>-->
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Cantidad</label> <input type="number" class="form-control"
                min="1" max="2147483646" title='IngreseCantidad' required=""
                placeholder="Ingrese la cantidad" name="quantity"
                value="${articleMovementInstance?.quantity}" />
            </div>
        </div>
    </div>