<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
  
          
<title>Sklep</title>
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
                      
 						<li >  <!--style="display:none;"-->
                       <a href="shop.html"><i class="fa fa-book fa-fw"></i> Sklep</a>
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
                    <h1 class="page-header">Sklep</h1>
                 
              
        <table class="table">
    <a href="shopregister" class="btn btn-primary btn-block">Zarejestruj nowy sklep</a></br></br></br>      
    <tbody>
 <c:forEach var="listValue" items="${shops}"> 
         
          <tr>
          <td><div class="panel panel-primary">
          <div class="panel-heading"> <div style="text-align: center"><h4>Nazwa:  ${listValue.name}</h4></div></div>
   <div class="panel-body">
      <table>
 		 <thead  style="margin-bottom:16px;">
 		   <th></th>
          <th><h3>Dane kontaktowe:</h3></th>
          <th><h3>Opcje sklepu:</h3></th>
          </thead>
          <tbody>
        <tr>
        
          <td>
        <img src="http://imageog.flaticon.com/icons/png/512/2/2772.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF" width=500>
          </td>
          <td>
         
              
 				 Adres:  ${listValue.address} </br> 
 				 Kod pocztowy:  ${listValue.postalcode}</br>
  			     Województwo: ${listValue.voivodeship}</br>
 				 Telefon:  ${listValue.phone}
   			 <hr/>
				<h5>Link sklepu odbierania danych</h5>
   				 ${listValue.link_send_data}
    		 <hr/>
              <h5>Unikalny numer identyfikacyjny sklepu:  ${listValue.shop_id} </h5>
    		  
   				
        </td>
        
        <td>
         <div  class="panel">
 
                    <div class="panel body">
             
               <form action="shopedit" method ="POST">
               <input name="shop_id" hidden value="${listValue.shop_id}">
                 <button class="btn btn-primary">Edytuj dane sklepu</button> </br></br></br>
               </form>  
           
             <form:form action="shopcardadd" method="POST">
             <input hidden value= "${listValue.shop_id}" name="shop_id" />
             <button class="btn btn-primary">Dodaj karty podarunkowe</button> </br></br></br>
             </form:form>
             
               <form:form action="shopstatistic" method="POST">
             <input hidden value= "${listValue.shop_id}" name="shop_id" />
             <button class="btn btn-primary">Sprawdz statystyki sklepu</button> </br></br></br>
             </form:form>
          
                    </div>
                 </div>
              
        </td>
      </tr>
</tbody>
     	</div>
     	     </table>
  </div>
  </div>
  
  </td>
   </tr>
     </table>
 </c:forEach>

  
  
    
    {shop_id
    }
    


    
</body>
</html>