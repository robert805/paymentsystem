<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"">
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
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
  
  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  <script>
$(function() {
    $( "#datepicker" ).datepicker();
});
</script>
 <script>
$(function() {
    $( "#datepicker1" ).datepicker();
});
</script>
<script>
$(document).ready(function() {
  var plot1 = $.jqplot ('chart1', [[3,7,9,1,4,6,8,2,5]]);
});
</script>
<script type="text/javascript">
 function odliczanie(){
   var dzisiaj = new Date();

   var dzien = dzisiaj.getDate();
   if(dzien<10) dzien= "0"+ dzien;
   var miesiac = dzisiaj.getMonth() + 1;
   if(miesiac<10) miesiac="0" + miesiac;
   var rok = dzisiaj.getFullYear();
   if(rok < 10) rok = "0" + rok;
   var godzina = dzisiaj.getHours();
   if(godzina <10) godzina= "0" + godzina;
   var minuta = dzisiaj.getMinutes();
   if(minuta <10) minuta= "0" + minuta;
   var sekunda= dzisiaj.getSeconds();
   if(sekunda < 10) sekunda= "0" + sekunda
   document.getElementById("zegar").innerHTML= dzien + "/" +  miesiac + "/" + rok + " | " + godzina + ":" + minuta + ":" + sekunda ;
   setTimeout("odliczanie()", 1000);
   
}
 
   </script>

<title>Aktywność konta</title>
</head>
<body onload="odliczanie();">
 
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
                <a class="navbar-brand" href="index.html">Aktywność konta</a>
              <h7 class="navbar-brand"> Witaj ${username}</h7>  
             
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                   
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="profil"><i class="fa fa-user fa-fw"></i> Profil</a>
                        </li>
                        <li><a href="ustawienia.html"><i class="fa fa-gear fa-fw"></i> Ustawienia</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="hello"><i class="fa fa-sign-out fa-fw"></i> Wyloguj</a>
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
                            <a href="activities.html"><i class="fa fa-table fa-fw"></i> Aktywność konta</a>
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
 
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Wpłaty</h1>
                    
                            
                            
        
            <div class="panel panel-primary">
  <div class="panel-heading"><table><tr><td><h3>Aktualna data : </h3></td><td> <h3><div  id= "zegar"></div></h3></td> </tr></table></div>
  <div class="panel-body">
 
  </div>


            
                 
                        
                            
                     
                             
                            
                             
                            
                             
                       
                         </div>
                 </div>

</div>

<div ng-app= "aplikacja">
  <div ng-controller="kontrolertransakcji">
  
  	<div class="input-group">
  		
       		<span class="input-group-addon">Szukaj</span>
       		
       		<input type="text" class="form-control" ng-model="wyszukiwarka" >
       		
  		</div>
  
  <div class= "table-responsive">
  
 <table class="table table-hover">
    <thead>
      <tr>
        
        <th ng-repeat="naglowek in ['Nadawca', 'Odbiorca', 'Data zawarcia' , 'Kwota', 'Tytuł' , 'Potwierdzenie', 'Szczegóły transakcji']">
        {{naglowek}}
        </th>
        
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="transakcja in transakcje | filter: wyszukiwarka | orderBy:sortType:sortReverse">
          <td><div class="panel panel-primary">
  <div class="panel-body">
  <div style="text-align: center">   {{transakcja.sender.username}}</div>
  </div>
 </div>
 </td>  
 
        <td><div class="panel panel-primary">
  <div class="panel-body">
 <div style="text-align: center">  {{transakcja.recipent.username }} </div>
  </div>  
  </td>
    
         <td><div class="panel panel-primary">
  <div class="panel-body">
 <div style="text-align: center">  {{transakcja.date }} </div>
  </div>  
  </td>
    
 
    
    <td><div class="panel panel-primary">
  <div class="panel-body">
 <div style="text-align: center">  {{transakcja.amount}}  PLN</div>
  </div>  
  </td>
  
    <td><div class="panel panel-primary">
  <div class="panel-body">
 <div style="text-align: center">  {{transakcja.title}}  </div>
  </div>  
  </td>
  
  
  <td>
 <div> 
 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Adres Email</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="panel-primary">
      <div class="panel-heading">
   
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Wpisz adres email</h4>
      </div>
         </div>
      <div class="modal-body">
        <form:form action="pdfsend" method= "POST">
  Podaj adres email na który chcesz wysłać potwierdzenie przelewu:
  <hr />
   <div style= "text-align: center">
   <input  hidden name="transaction_id" value= "{{transakcja.id }}" />
     <input class="form-control"  name="emailadress"  /> <button  class="btn btn-primary"> Wyślij </button>
       </form:form>
      </div>
      <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
      </div>  </div>
    
   
  
      <div class="modal-footer">
       
      </div>
    </div>

  </div>

 
  </td>
  

    <td>
 <div> 
 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#{{transakcja.id}} ">Szczegóły transakcji</button>

<!-- Modal -->
<div id={{transakcja.id}} class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="panel-primary">
      <div class="panel-heading">
   
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Szczegóły transakcji</h4>
      </div>
         </div>
      <div class="modal-body">
       <h5> <b> Dane nadawcy:</h5> </b> <hr/>
       <h7> <b> Nazwa nadawcy: </b> </h7> {{transakcja.sender.userDetails.name}} {{transakcja.sender.userDetails.lastname}} <hr/>
       <h7> <b> Adres nadawcy: </b> </h7> {{transakcja.sender.userDetails.adress}} {{transakcja.sender.userDetails.name}} <hr/>
       <h7> <b> Kod pocztowy: </b> </h7> {{transakcja.sender.userDetails.adress}} <hr/>
       <h5> <b> Dane odbiorcy: </b> </h5> <hr/>
       <h7> <b> Nazwa nadawcy: </b> </h7> {{transakcja.recipent.userDetails.name}} {{transakcja.recipent.userDetails.lastname}} <hr/>
       <h7> <b> Adres nadawcy: </b> </h7> {{transakcja.recipent.userDetails.adress}} {{transakcja.recipent.userDetails.name}} <hr/>
       <h7> <b> Kod pocztowy: </b> </h7> {{transakcja.recipent.userDetails.adress}} <hr/>
       <h7> <b> Kwota: </b> </h7> {{transakcja.amount}} PLN <hr/>
       <h7> <b> Data zawarcia </b> </h7> {{transakcja.date}} <hr/>
      <h7> <b> Tytuł płatności</b> </h7> {{transakcja.title}} <hr/>
      </div>
      <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
      </div>  </div>
    
   
  
      <div class="modal-footer">
       
      </div>
    </div>

  </div>

 
  </td>
  
  
      </tr>
     
     </div>
    </tbody>
  </table>
  </div>
              </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
 
    </div>
  
  
  <script>
  var app = angular.module('aplikacja' , [] );
  
  app.controller('kontrolertransakcji' , [ '$scope' , function( $scope ){ 
  		
  		                                  
  	    $scope.transakcje = ${lista};
  }]);
  
  </script>
  

    <!-- /#wrapper -->
    
 <script>
function myFunction(wartosc) {
	var input = "input"
	var a = "but";
	var b = a + wartosc;
	var c = input + wartosc;
    var x = prompt("Podaj adres email odbiorcy do którego chcesz wysłać potwierdzenie w formacie PDF", document.getElementById(wartosc).value);

	document.getElementById(c).value = x;
}
</script>

   <!-- jQuery -->
    <!--script src="../css/vendor/jquery/jquery-1.12.4.js"></script-->
 

  
    
</body>
</html>