<%@ page import="com.sd.uni.labpatologia.report.ReportController"%>

<div class="container-fluid">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>
					<strong>Registrar Informe</strong>
				</h4>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-4">
						<label> Código <span class="required-indicator"></span>

						</label>

					</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-8"></div>


				</div>
				<br>

				<button class="btn btn-primary">
					<i class="fa fa-floppy-o"></i> Crear
				</button>
				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#createReport">
			</div>

		</div>

	</div>
</div>

<!-- jQuery -->
<script src=" ${request.contextPath}/template/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
