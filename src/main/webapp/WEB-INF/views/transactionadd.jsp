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
                    <h1 class="page-header">Dokonaj przelewu:</h1>
                    
                            
                            
        
            <div class="panel panel-primary">
  <div class="panel-heading"><table><tr><td><h3>Aktualna data : </h3></td><td> <h3><div  id= "zegar"></div></h3></td> </tr></table></div>
  <div class="panel-body">
 
  </div>


            
                 
                        
                            
                     
                             
                            
                             
                            
                             
                       
                         </div>
                 </div>

</div>
<form:form  action= "transaction" method = "POST"> 
  <table class="table">
    <thead>
      <tr>
        
       
        <th>Odbiorca</th>
        <th>Kwota</th>
      </tr>
    </thead>
    <tbody>
    
      <tr>
          <td>
              <div class="panel panel-primary">
              <div class="panel-body">
              <div style="text-align: center">  <input class="form-control" placeholder= "Email odbiorcy:" name="name1" required/></div>
              </div>
              <div style="text-align: center" class="form-error"> ${error} </div>
              </div>
         </td> 
 
          <td>
              <div class="panel panel-primary">
              <div class="panel-body">
              <div style="text-align: center"> <input class="form-control" placeholder= "Kwota:" name="amount" required/> </div>
              </div> 
             <div style="text-align: center" class="form-error">${komunikat} </div>
              </div> 
           </td>
           
          <td>
           <div class="panel panel-primary">
              <div class="panel-body">
            <div style="text-align: center">   <button class="btn btn-primary"> Zaapcektuj</button> </div>
                </div> 
                
              </div> 
           </td>
          
         
          
      </tr>
      
      

      

     
    </tbody>
  </table>
  
  <table class="table">
  <thead>

  <th>
  Tytuł operacji:
  </th>

  </thead>
  <tbody>
        <tr>
         <td>
       <div class="panel panel-primary">
              <div class="panel-body">
              <div style="text-align: center"> <input class="form-control" placeholder= "Tytuł operacji:" name="title_operation" required/> </div>
              </div> 
              </div> 
     
      
      </td>
      </tr>
      <tr>
        <td>
           
            <div style="text-align: center" class="form-error">  <b><h1><img src="${adreszdjecia}" width= "80" ${hidden}>  ${komunikat1} </h1> </b> </div>
            
           </td>
           </tr>
      </tbody>
  </table>
  
  
  
   </form:form>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
          



    </div>
  
    <!-- /#wrapper -->


   <!-- jQuery -->
    <!--script src="../css/vendor/jquery/jquery-1.12.4.js"></script-->
 

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