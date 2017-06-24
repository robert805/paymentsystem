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
                       <a href="shop.html"><i class="fa fa-edit fa-fw"></i> Sklep</a>
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
                    <h1 class="page-header">Pulpit</h1>
                 
                   
        

  
  
  <div ng-app>
  
  <div class="input-group">
  		
       		<span class="input-group-addon">Szukaj</span>
       		
       		<input type="text" class="form-control" ng-model="wyszukiwarka" >
       		
  		</div>
  		
  <div class="table-responsive">
   
  <table class="table table-hover">
  
  <tr ng-repeat='tabela in [ 
  
   {
   
     "shop_id" : "10531"
     "price" : "204"
     "quantity" : "3"
     "transaction_id" : "15"
     
   }
  
  		{
            "ikona" : "http://st2.depositphotos.com/4177785/11778/v/450/depositphotos_117787168-stock-illustration-dollar-coin-icon.jpg",
            "opis" : "Jeśli chcesz sprawdzić stan swojego konta lub dodać środki",
            "link" : "portfel",
            "tag" : "portfel"
        },
        {
            "ikona" : "https://image.freepik.com/darmowe-ikony/profil-u%C5%BCytkownika-ikona_318-33925.jpg",
            "opis" : "Aby uzupełnić lub edytować profil, zmienić ustawienia związane z bezpieczeństwem takie jak zmiana hasła oraz ustawienia pytań pomocnicznych przejdz do zakładki profil" ,
            "link" : "profil",
            "tag" : "profilustawienia"
        },
        {
            "ikona" : "https://image.freepik.com/darmowe-ikony/administracja-czas-zegar-i-kalendarz-oraz-symbol-organizacji-narz%C4%99dzia_318-60956.jpg",
            "opis" : "Aby sprawdzić aktywność konta takie jak edycja konta, zmiana ustawień profilu, datę założenia konta, zmiana ustawień hasła, historię konta",
            "link" : "activities",
            "tag" : "aktywnośćhistoria"
        },
        {
            "ikona" : "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR9Jdxy4-_vrHkLYIizKl1jhkfJjVtJMc_5-WePCiZqY5bk_p0-",
            "opis" : "Aby dokonać transakcji, przelać środki na konto użytkownika systemu należy przejść do zakładki transakcje" ,
            "link" : "transactionadd",
            "tag" : "przelewtransakcja"
        },
        {
            "ikona" : "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSe4_PhAegJMSEe7NFFqAc7usNBrUM6c_pGNIOghwBotbm3iBc-",
            "opis" : "Aby sprawdzić przeprowadzone transakcje, wyszukać transakcji, wysłać potwierdzenie przelewu, sprawdzić szczegóły transakcji" ,
            "link" : "transactionsender",
            "tag" : "listatransakcji"
        },
        {
            "ikona" : "https://thumbs.dreamstime.com/z/zmiana-przygotowywa-prostego-ikona-wektor-42607777.jpg",
            "opis" : "Aby zmienić aktualnie posiadane hasło przejdź do opcji Zmiana Hasła klikając w" ,
            "link" : "passwordedit",
            "tag" : "zmianahasła"
        },
         {
            "ikona" : "https://image.freepik.com/darmowe-ikony/znak-zapytania-na-czarnym-tle-ko%C5%82owym_318-41916.jpg",
            "opis" : "Aby ustawić pytanie pomocnicze przejdz do opcji Dodaj Pytanie Pomocnicze klikając w" ,
            "link" : "passwordedit",
            "tag" : "pytaniepomocnicze"
        },
         {
            "ikona" : "http://img.freepik.com/darmowe-ikony/skrzynka-odbiorcza-interfejs-download-zaloguj_318-75275.jpg?size=338&ext=jpg",
            "opis" : "Aby sprawdzić odebrane transakcje wejdz w opcję Wypłaty klikając w" ,
            "link" : "transactionrecipent",
            "tag" : "transakcjeodebrane"
        },
         {
            "ikona" : "http://us.123rf.com/450wm/martialred/martialred1507/martialred150700771/42614150-automatyczna-linia-ikona-sztuki-cykliczne-p%C5%82atno%C5%9Bci-dla-aplikacji-i-stron-internetowych.jpg?ver=6
",
            "opis" : "Aby ustawić transakcję cykliczną wejdż w opcję Ustaw transakcję cykliczną klikając w" ,
            "link" : "transactionrecipent",
            "tag" : "transakcjacykliczna"
        }
  ]|filter:wyszukiwarka'>
  <td>
  
  <img src={{tabela.ikona}} width=100>
 
  </td>
  <td>
  <h4> {{tabela.opis}}  <a href="{{tabela.link}}">link tutaj</a></h4>
  </td>
  </tr>
  
</table>
</div>
                  
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
          

    </div>
    <!-- /#wrapper -->
    


    
</body>
</html>