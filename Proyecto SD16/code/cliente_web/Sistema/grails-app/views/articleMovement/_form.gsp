<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.sd.uni.labpatologia.util.MovementTypeEnum"%>

<div class="row">
    <div class="col-md-6">
       
            <label>Articulo <span class="required-indicator">*</span></label>
             <div class="form-group">
             <div id="data-article">
            <select class="select-article form-control" name="articleId" id="articleId">
						<option value="${ArticleMovementInstance?.article?.id}">Selecciona un articulo</option>
			</select>
			</div>
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
                <input type="text" class="form-control numeric" maxlength="10"
                min="1" max="2147483646"  
                placeholder="Ingrese la cantidad" name="quantity" id="quantity"
                value="${articleMovementInstance?.quantity}" />
            </div>
        </div>
    </div>
    
    <!-- Para selector de doctor -->
    <script type="text/javascript">
	    	$(".select-article").select2({
				language: 'es',
	    		  ajax: {
	    		    url: "${createLink(controller: 'article', action: 'selectArticle')}",
	    		    dataType: 'json',
	    		    delay: 250,
	    		    data: function (params) {
	    		      return {
	    		        q: params.term, 
	    		        page: 0
	    		      };
	    		    },
	    		    processResults: function (data) {
	    		        return {
	    		            results: $.map(data, function(obj) {
	    		                return { id: obj.id, text: obj.name };
	    		            })
	    		        };
	    		    },
	    		    cache: true
	    		  },
	    		  escapeMarkup: function (markup) { return markup; }, 
	    		  minimumInputLength: 1,
	    	}).on("change", function (e) {
	    	    $(this).valid(); //jquery validation script validate on change
	    	}).on("select2:open", function() { //correct validation classes (has=*)
	    	    if ($(this).parents("[class*='has-']").length) { //copies the classes
	    	        var classNames = $(this).parents("[class*='has-']")[0].className.split(/\s+/);

	    	        for (var i = 0; i < classNames.length; ++i) {
	    	            if (classNames[i].match("has-")) {
	    	                $("body > .select2-container").addClass(classNames[i]);
	    	            }
	    	        }
	    	    } else { //removes any existing classes
	    	        $("body > .select2-container").removeClass (function (index, css) {
	    	            return (css.match (/(^|\s)has-\S+/g) || []).join(' ');
	    	        });            
	    	    }
	    	});
   
	   
    </script>
    <style>
		.select2-container--default .select2-selection--single{
		    height: 32px;
		}	
	</style>