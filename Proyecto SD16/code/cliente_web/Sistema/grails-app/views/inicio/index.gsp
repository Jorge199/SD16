<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template"/>
		<title>Bienvenido al Laboratorio</title>
		 <!-- Bootstrap Core CSS -->
		  <link href="${request.contextPath}/template/css/bootstrap.min.css?v=1" rel="stylesheet">
	 
	    <!-- Custom CSS -->
	     <link href="${request.contextPath}/template/css/sb-admin.css?v=1" rel="stylesheet">
	  
	    <!-- Morris Charts CSS -->
	     <link href="${request.contextPath}/template/css/plugins/morris.css?v=1" rel="stylesheet">
	    
	    <!-- Custom Fonts -->
	     <link href="${request.contextPath}/template/css/font-awesome.min.css?v=1" rel="stylesheet">
	   
		</head>
	<body>
		
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           <center> Acceso Directo <small>(Principales funciones del sistema)</small></center>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-area-chart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">26</div>
                                        <div>Estadisticas</div>
                                    </div>
                                </div>
                            </div>
                            <a href="/Sistema/estadistica/index">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver Detalle</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-flask fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">12</div>
                                        <div>Nuevas Muestras</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver Detalle</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-child fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">124</div>
                                        <div>Pacientes</div>
                                    </div>
                                </div>
                            </div>
                            <a href="/Sistema/paciente/crear">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver Detalle</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-medkit fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">13</div>
                                        <div>Insumos</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">Ver Detalle</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
             <!-- /.row -->

 
     <!-- jQuery -->
     <script src=" ${request.contextPath}/template/js/jquery.js"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src=" ${request.contextPath}/template/js/plugins/morris/raphael.min.js"></script>
    <script src=" ${request.contextPath}/template/js/plugins/morris/morris.min.js"></script>
    <script src=" ${request.contextPath}/template/js/plugins/morris/morris-data.js"></script>
   
			
	</body>
	 
</html>