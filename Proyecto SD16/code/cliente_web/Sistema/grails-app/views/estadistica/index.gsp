<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="layout" content="template">

    <title>Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="${request.contextPath}/template/css/bootstrap.min.css?v=1" rel="stylesheet">
   
    <!-- Custom CSS -->
    <!-- Bootstrap Core CSS -->
    <link href="${request.contextPath}/template/css/sb-admin.css?v=1" rel="stylesheet">
  
    <!-- Morris Charts CSS -->
    <link href="${request.contextPath}/template/css/plugins/morris.css?v=1" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${request.contextPath}/template/css/font-awesome.min.css?v=1" rel="stylesheet">
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	                
   <div class="container-fluid">
		<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Estadistica</strong></h4>
					</div>
				<div class="panel-body">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Ejemplo</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-4">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> Ejemplo</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                                <div class="text-right">
                                    <a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> Ejemplo</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-line-chart"></div>
                                <div class="text-right">
                                    <a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> Ejemplo</h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-bar-chart"></div>
                                <div class="text-right">
                                    <a href="#">View Details <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
			</div>
          </div>
         </div>
            <!-- /.container-fluid -->


    <!-- jQuery -->
    <script src=" ${request.contextPath}/template/js/jquery.js"></script>
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
     <script src=" ${request.contextPath}/template/js/plugins/morris/raphael.min.js"></script>
     <script src=" ${request.contextPath}/template/js/plugins/morris/morris.min.js"></script>
     <script src=" ${request.contextPath}/template/js/plugins/morris/morris-data.js"></script>
  

    <!-- Flot Charts JavaScript -->
    <!--[if lte IE 8]><script src="js/excanvas.min.js"></script><![endif]-->
     <script src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.js"></script>
     <script src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
     <script src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.resize.js"></script>
     <script src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.pie.js"></script>
     <script src=" ${request.contextPath}/template/js/plugins/flot/flot-data.js"></script>

</body>

</html>
