<%@ page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.StatusEnum" %>
<form id="myFormRequest">
<div class="row">
	<div class=col-md-12>
		<div class="col-md-4">
			<label>Fecha de Ingreso <span class="required-indicator">*</span></label>
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' class="form-control" name="date" required=""
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
						<g:field type="text" name="code" readonly="readonly" class="form-control" value="${requestInstance?.code}" required=""/>
					</div>
					</div>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<div class="col-sm-4">
						<div class="form-group">
							<g:textField type="number" class="form-control"  max="20" name="code_cortes" required=""
							placeholder="Nro de cortes" />
							</div>
						</div>
						<div class="col-sm-4">
						<div class="form-group">
							<g:textField type="number" class="form-control"  max="20" name="code_laminas" 
							placeholder="Nro de laminas"/>
						</div>
						</div>
					</sec:ifAnyGranted>
					
				</g:if>
				<g:elseif test="${requestInstance?.status==StatusEnum.PROCESO }">
					<div class="col-sm-4">
					<div class="form-group">
						<g:field type="text" name="code" readonly="readonly" required="" class="form-control" value="${requestInstance?.code}"/>
					</div>
					</div>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<div class="col-sm-4">
						<div class="form-group">
							<g:textField type="number" class="form-control"  max="20" name="code_laminas" required=""
							placeholder="Nro de laminas"/>
						</div>
						</div>
					</sec:ifAnyGranted>
				</g:elseif>
				<g:else>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<g:textField class="form-control"  max="20" name="code"
							placeholder="Ingrese un codigo" value="${requestInstance?.code}" required=""/>
					</sec:ifAnyGranted>
					<sec:ifAnyGranted roles='ROLE_SECRETARIA'>
						<g:textField class="form-control"  max="20" name="code" readonly="readonly"
							placeholder="Ingrese un codigo" value="${requestInstance?.code}" required="" />
					</sec:ifAnyGranted>
				</g:else>
			</div>
		</div>
	</div>
	
	
	
	<div class=col-md-12>
		<div class="col-md-4">
				<label>Paciente <span class="required-indicator">*</span></label>
				<div class="form-group">
				<div class="input-group">
				<g:select  class="form-control selectpicker many-to-one" data-live-search="true" name="patientId" from="${patients}" value="${requestInstance?.patient?.id}"
				optionKey="id" optionValue="fullName" required=""
				noSelection="${['':'Seleccione un paciente..']}"/>
				<label type="button" class="btn btn-primary input-group-addon" data-toggle="modal"
							data-target="#createPatient">
							<i class="fa fa-plus"></i>
				</label>
				</div>
				</div>
				</div>
		
		<div class="col-md-4">
			<label>Doctor <span class="required-indicator">*</span></label>
			<div class="form-group">
			<div class="input-group">
				<g:select class="form-control selectpicker many-to-one" data-live-search="true" name="doctorId" from="${doctors}"  value="${requestInstance?.doctor?.id}"
				optionKey="id" optionValue="fullName" required=""
				noSelection="${['':'Seleccione un doctor..']}"
				/>
				
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
			<g:select  class="form-control selectpicker many-to-one" name="studyTypeId" from="${studies}" value="${requestInstance?.studyType?.id}"
			optionKey="id" optionValue="name" required=""
			noSelection="${['':'Seleccione un estudio..']}" />
			</div>
		</div>
	</div>
	
	<div class="col-md-12">
		<div class="col-md-6">
			<label>Observaciones <span class="required-indicator">*</span></label>
			<div class="form-group">
			<g:textArea class="form-control" rows="5" cols="40" class="form-control"
				name="note" maxlength="250" required=""
				placeholder="Ingrese sus observaciones"
				value="${requestInstance?.note}" />
				</div>
		</div>
	</div>
</div>
<div class="col-xs-12" align="center">
	<g:if test="${action == 'save'}">
	   <button type="submit" class="btn btn-primary" onclick="callAjax1()"><i class="fa fa-save"></i> Guardar </button>
	</g:if><g:else>
	   <button type="submit" class="btn btn-primary" name="edit" value="${requestInstance?.id}" onclick="callAjax1()">
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
			<form id="myFormDoctor">
				<g:render template="/doctor/form"/>
			
					<fieldset class="buttons">
						<br><br><div class="col-xs-10">
							<div class="text-right">
							<button  type="submit"  class="btn btn-primary" onclick="callAjax()"><i class="fa fa-save"></i> Guardar</button>
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
			<form id="myFormPatient">
				<g:render template="/patient/form"/>
			
					<fieldset class="buttons">
						<br><br><div class="col-xs-10">
							<div class="text-right">
							<button  type="submit"  class="btn btn-primary" onclick="callAjax2()"><i class="fa fa-save"></i> Guardar</button>
							</div></div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<head>
    <g:javascript plugin="jquery" library="jquery" src="jquery/jquery-1.7.2.js"/>
    <!-- Para boton guardar de doctor -->
    <script>
        function callAjax(){
        	    $.ajax({
                	type:"POST",
                    url : "${createLink(controller: 'doctor', action: 'save')}",
                    data :   $("#myFormDoctor").serialize() , // do I need to pass data if im GET ting?
                    dataType: 'json',
                    success : function(data){
                       //doing stuff
                       //end success
                    	 $("#myFormDoctor").submit();
                    },
                });
        }
    </script>
    <!-- Para boton guardar de ficha -->
     <script>
        function callAjax1(){
            if(action = 'save'){
        	    $.ajax({
                	type:"POST",
                    url : "${createLink(controller: 'request', action: 'save')}",
                    data :   $("#myFormRequest").serialize() , // do I need to pass data if im GET ting?
                    dataType: 'json',
                    success : function(data){
                       //doing stuff
                       //end success
                    	 $("#myFormRequest").submit();
                    },
                });
            }else{
            	 $.ajax({
                 	type:"POST",
                     url : "${createLink(controller: 'request', action: 'update')}",
                     data :   $("#myFormRequest").serialize() , // do I need to pass data if im GET ting?
                     dataType: 'json',
                     success : function(data){
                        //doing stuff
                        //end success
                     	 $("#myFormRequest").submit();
                     },
                 });

                }     
        }
    </script>
    <!-- Para boton guardar de paciente -->
    <script type="text/javascript">
    function callAjax2(){
	    $.ajax({
        	type:"POST",
            url : "${createLink(controller: 'patient', action: 'save')}",
            data :   $("#myFormPatient").serialize() , // do I need to pass data if im GET ting?
            dataType: 'json',
            success : function(data){
               //doing stuff
               //end success
            	 $("#myFormPatient").submit();
            },
        });
	}
    </script>
</head>


