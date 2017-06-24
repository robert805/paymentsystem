<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<!-- Bootstrap Core CSS -->
    <link href="../css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/dist/css/sb-admin-2.css" rel="stylesheet">
    
    <!-- Morris Charts CSS -->
    <link href="../css/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
          
<title>User Login Index</title>
</head>
<body>

   <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Panel startowy</a>
                  <h7 class="navbar-brand"> Witaj ${username}</h7>  
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="profil.html"><i class="fa fa-user fa-fw"></i> Profil</a>
                        </li>
                        <li><a href="ustawienia.html"><i class="fa fa-gear fa-fw"></i> Ustawienia</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Wyloguj</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Szukaj...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Pulpit</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Transakcje<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                   <li>
                                    <a href="transactionadd">Wykonaj Przelew</a>
                                </li>
                                
                                <li>
                                    <a href="transactionsender">Wpłaty</a>
                                </li>
                                <li>
                                    <a href="transactionrecipent">Wypłaty</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="activities.html"><i class="fa fa-table fa-fw"></i> Historia konta</a>
                        </li>
                        <li>
                            <a href="portfel.html"><i class="fa fa-edit fa-fw"></i> Portfel</a>
                        </li>

                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>


        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Profil</h1>
                 
                 <div class="panel-group">


                 
                  <div class="panel panel-primary">
                  <div class="panel panel-heading"><h1>Dane użytkownika profilu: </h1></div>
                    <div class="panel body">
                   
                    <table class="table">
                    <thead>
                    <tr>
                    <th>Dane użytkownika</th>
                   
                    </tr>
                    </thead>
            <tbody>
			<tr>  
			<td> <div class="panel panel-success">
                  <div class="panel panel-heading">Imie:</div>
                    <div class="panel body">
                     ${userDetails.name} 
                 </div>
                 </div> </td> 
			<td><div class="panel panel-success">
                  <div class="panel panel-heading">Nazwisko:</div>
                    <div class="panel body">
                    ${userDetails.lastname}
                 </div>
                 </div></td> 
			<td><div class="panel panel-success">
                  <div class="panel panel-heading">Wiek:</div>
                    <div class="panel body">
                     ${userDetails.age} 
                 </div>
                 </div></td>
		    <td><div class="panel panel-success">
                  <div class="panel panel-heading">Telefon:</div>
                    <div class="panel body">
                    ${userDetails.phone} 
                 </div>
                 </div></td>
		    <td><div class="panel panel-success">
                  <div class="panel panel-heading">Adres Email:</div>
                    <div class="panel body">
                    ${username}
                 </div>
                 </div></td>
		     </tr>	
		</tbody>
		    <thead>
                    <tr>
                    <th>Adres</th>
                  
                  
                    </tr>
                    </thead>
                      <tbody>
			<tr>  
			<td><div class="panel panel-success">
                  <div class="panel panel-heading">Adres:</div>
                    <div class="panel body">
                  ${userDetails.adress}
                 </div>
                 </div></td> 
			<td><div class="panel panel-success">
                  <div class="panel panel-heading">Kod pocztowy:</div>
                    <div class="panel body">
                  ${userDetails.postalcode}
                 </div>
                 </div></td> 
			<td><div class="panel panel-success">
                  <div class="panel panel-heading">Województwo:</div>
                    <div class="panel body">
                  ${userDetails.voivodeship}
                 </div>
                 </div></td>
		  
		     </tr>	
		</tbody>
              </table>
               </div>
               </div>
               
            <div class="panel panel-primary">
                  <div class="panel panel-heading"><h1>Ustawienia edycji profilu:</h1></div>
                    <div class="panel body">
              
                 
             <a href="profiledit" class="btn btn-primary btn-outline btn-block">Edytuj profil</a>
             <a href="passwordedit" class="btn btn-primary btn-outline btn-block">Zmiana hasla</a>
             <a href="register" class="btn btn-primary btn-outline btn-block">Dodaj pytanie pomocnicze</a>
          
                    </div>
                 </div>
                    
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    
        <!-- jQuery -->
    <script src="../css/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../css/vendor/raphael/raphael.min.js"></script>
    <script src="../css/vendor/morrisjs/morris.min.js"></script>
    <script src="../css/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../css/dist/js/sb-admin-2.js"></script>
    
</body>
</html>