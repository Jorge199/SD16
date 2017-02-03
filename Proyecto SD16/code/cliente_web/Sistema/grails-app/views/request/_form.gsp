<%@ page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.StatusEnum" %>

<form id="myFormRequest" onsubmit="return saveDataRequest();">
<div class="row">
	<div class=col-md-12>
		<div class="col-md-4">
			<label>Fecha de Ingreso <span class="required-indicator">*</span></label>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker2'>
				<input type='text' class="form-control" name="date" id="date" placeholder="Selecciona una fecha"
					value="${formatDate(format: 'dd-MM-yyyy', date:requestInstance.getDate())}" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"> </span>
				</span>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<label>Codigo <span class="required-indicator">*</span></label>
			<div>
				<g:if test="${requestInstance?.status == StatusEnum.RECIBIDO }">
					<div class="col-sm-4">
					<div class="form-group">
						<input type="text" name="code" id="code" readonly="readonly" class="form-control" value="${requestInstance?.code}"/>
					</div>
					</div>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<div class="col-sm-4">
						<div class="form-group">
							<input type="number" class="form-control"  maxlength="20" name="code_cortes" id="code_cortes"
							placeholder="Nro de cortes" />
							</div>
						</div>
						<div class="col-sm-4">
						<div class="form-group">
							<input type="number" class="form-control"  maxlength="20" name="code_laminas" id="code_laminas"
							placeholder="Nro de laminas"/>
						</div>
						</div>
					</sec:ifAnyGranted>
					
				</g:if>
				<g:elseif test="${requestInstance?.status==StatusEnum.PROCESO }">
					<div class="col-sm-4">
					<div class="form-group">
						<input type="text" name="code" id="code" maxlength="20" readonly="readonly" class="form-control" value="${requestInstance?.code}"/>
					</div>
					</div>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<div class="col-sm-4">
						<div class="form-group">
							<input type="number" class="form-control"  maxlength="20" name="code_laminas" id="code_laminas"
							placeholder="Nro de laminas"/>
						</div>
						</div>
					</sec:ifAnyGranted>
				</g:elseif>
				<g:else>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<input class="form-control"  maxlength="20" name="code" id="code"
							placeholder="Ingrese un codigo" value="${requestInstance?.code}"/>
					</sec:ifAnyGranted>
					<sec:ifAnyGranted roles='ROLE_SECRETARIA'>
						<input class="form-control"  maxlength="20" name="code" readonly="readonly" id="code"
							placeholder="Ingrese un codigo" value="${requestInstance?.code}" />
					</sec:ifAnyGranted>
				</g:else>
			</div>
		</div>
	</div>
	
	
	
	<div class=col-md-12>
		<div class="col-md-4">
				<label>Paciente <span class="required-indicator">*</span></label>
				<div class="form-group">
				<div class="input-group" id="data-patient">
				<g:if test="${action == 'save'}">
					<select class="select-patient form-control" name="patientId" id="patientId">
						<option value="${requestInstance?.patient?.id}">Selecciona un paciente</option>
					</select>
				</g:if>
				<g:else>
					<select class="select-patient form-control" name="patientId" id="patientId">
						<option value="${requestInstance?.patient?.id}">${requestInstance?.patient?.name} ${requestInstance?.patient?.lastName}</option>
					</select>
				</g:else>
				<label  type="button" class="btn btn-primary input-group-addon" data-toggle="modal"
							data-target="#createPatient">
							<i class="fa fa-plus"></i>
				</label>
				</div>
				</div>
				</div>
		
		<div class="col-md-4">
			<label>Doctor <span class="required-indicator">*</span></label>
			<div class="form-group">
			<div class="input-group" id="data-doctor">
				<g:if test="${action == 'save'}">
					<select id="doctorId" class="select-doctor form-control" name="doctorId" >
						<option value="${requestInstance?.doctor?.id}">Selecciona un doctor</option>
					</select>
				</g:if>
				<g:else>
					<select class="select-doctor form-control" name="doctorId" id="doctorId">
						<option value="${requestInstance?.doctor?.id}">${requestInstance?.doctor?.name} ${requestInstance?.doctor?.lastName}</option>
					</select>
				</g:else>
				<label type="button" class="btn btn-primary input-group-addon" data-toggle="modal"
							data-target="#createDoctor">
							<i class="fa fa-plus"></i>
				</label>
				</div>
				</div>
		</div>
		
		<div class="col-md-4">
			<label>Tipo de Estudio <span class="required-indicator">*</span></label>
			<div class="form-group">
			<g:select  class="form-control many-to-one" name="studyTypeId" from="${studies}" value="${requestInstance?.studyType?.id}"
			optionKey="id" optionValue="name" id="studyTypeId"
			noSelection="${['':'Seleccione un estudio..']}" />
			</div>
		</div>
	</div>
	
	<div class="col-md-12">
		<div class="col-md-6">
			<label>Observaciones <span class="required-indicator"></span></label>
			<div class="form-group">
			<g:textArea class="form-control" rows="5" cols="40" class="form-control"
				name="note" maxlength="250" id="note"
				placeholder="Ingrese sus observaciones"
				value="${requestInstance?.note}" />
				</div>
		</div>
	</div>
</div>
<div class="col-xs-12" align="center">
	<g:if test="${action == 'save'}">
	   <button type="submit" class="btn btn-primary" onclick="callRequest()"><i class="fa fa-save"></i> Guardar </button>
	</g:if><g:else>
	   <button type="submit" class="btn btn-primary" name="edit" value="${requestInstance?.id}" onclick="callRequest()">
		<i class="fa fa-save"></i> Guardar </button>
	</g:else>
	
	<a class="btn btn-default" href="/Sistema/request/list"
	role="button"><i class="fa fa-times"></i> Cancelar</a>
							
</div>
							
</form>
<!-- Modal doctor -->
<div class="modal fade" id="createDoctor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Registrar Doctor</h4>
			</div>
			<div class="modal-body">
			<form id="myFormDoctor" onsubmit="return saveDataDoctor();">
				<g:render template="/doctor/form"/>
			
					<fieldset class="buttons">
						<br><br><div class="col-xs-10">
							<div class="text-right">
							<button  type="submit"  class="btn btn-primary" onclick="callDoctor()"><i class="fa fa-save"></i> Guardar</button>
							</div></div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Modal paciente -->
<div class="modal fade" id="createPatient" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Registrar Paciente</h4>
			</div>
			<div class="modal-body">
			<form id="myFormPatient" onsubmit="return saveDataPatient();">
				<g:render template="/patient/form"/>
			
					<fieldset class="buttons">
						<br><br><div class="col-xs-10">
							<div class="text-right">
							<button  type="submit"  class="btn btn-primary" onclick="callPatient()"><i class="fa fa-save"></i> Guardar</button>
							</div></div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<head>
	<style>
		.select2-container--default .select2-selection--single{
		    height: 32px;
		    width: 297px; 
		}	
	</style>
    <!-- Para boton guardar de paciente -->
    <script>
        function callPatient(){
            if($("#myFormPatient").valid()){
        	    $.ajax({
                	type:"POST",
                    url : "${createLink(controller: 'patient', action: 'save')}",
                    data :   $("#myFormPatient").serialize() , 
                    dataType: 'json',
                    success : function(data){
                    	 $("#myFormPatient").submit();
                    },
                });
            }
        }
    </script>
    <!-- Para boton guardar de doctor -->
    <script>
        function callDoctor(){
        	if($("#myFormDoctor").valid()){
        	    $.ajax({
                	type:"POST",
                    url : "${createLink(controller: 'doctor', action: 'save')}",
                    data :   $("#myFormDoctor").serialize() , 
                    dataType: 'json',
                    success : function(data){
                    	 $("#myFormDoctor").submit();
                    },
                });
        	}
        }
    </script>
    <!-- Para boton guardar de ficha -->
     <script>
        function callRequest(){
        	if($("#myFormRequest").valid()){
            if(action = 'save'){
        	    $.ajax({
                	type:"POST",
                    url : "${createLink(controller: 'request', action: 'save')}",
                    data :   $("#myFormRequest").serialize() , 
                    dataType: 'json',
                    success : function(data){
                    	 $("#myFormRequest").submit();
                    },
                });
            }else{
            	 $.ajax({
                 	type:"POST",
                     url : "${createLink(controller: 'request', action: 'update')}",
                     data :   $("#myFormRequest").serialize() , 
                     dataType: 'json',
                     success : function(data){
                     	 $("#myFormRequest").submit();
                     },
                 });

                }     
        }
        }
    </script>
    
    <!-- Para boton guardar de paciente -->
    <script type="text/javascript">
   
    </script>
    
    <!-- Para selector de doctor -->
    <script type="text/javascript">
	    	$(".select-doctor").select2({
				language: 'es',
	    		  ajax: {
	    		    url: "${createLink(controller: 'doctor', action: 'selectDoctor')}",
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
	    		                return { id: obj.id, text: obj.name + ' ' + obj.lastName };
	    		            })
	    		        };
	    		    },
	    		    cache: true
	    		  },
	    		  escapeMarkup: function (markup) { return markup; }, 
	    		  minimumInputLength: 1,
	    	});
   
	   
    </script>
     <!-- Para selector de paciente -->
    <script type="text/javascript">
	    	$(".select-patient").select2({
		    	language: 'es',
	    		  ajax: {
	    		    url: "${createLink(controller: 'patient', action: 'selectPatient')}",
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
	    		                return { id: obj.id, text: obj.name + ' ' + obj.lastName };
	    		            })
	    		        };
	    		    },
	    		    cache: true
	    		  },
	    		  escapeMarkup: function (markup) { return markup; }, 
	    		  minimumInputLength: 1,
	    	});
	   
    </script>
</head>


