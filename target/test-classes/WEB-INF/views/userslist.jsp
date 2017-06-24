<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>UsersList</title>
</head>






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
        
        <th ng-repeat="naglowek in ['Adres ID', 'Login', 'Password' , 'Balance', 'Status aktywności', 'Uprawnienia', 'Informacje o koncie', 'Zmiana aktywności konta', 'Zmiana uprawnień konta', 'Usuń konto:']">
        {{naglowek}}
        </th>
        
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="uzytkownik in uzytkownicy | filter: wyszukiwarka | orderBy:sortType:sortReverse">
          
  <div class="panel-body">
  <div style="text-align: center">  <td>{{uzytkownik.user_id}}</td></div>
  </div>


 
  <div style="text-align: center">  <td>{{uzytkownik.username}}</td></div>
 

  <div style="text-align: center">  <td>{{uzytkownik.password}}</td></div>


  <div style="text-align: center">  <td>{{uzytkownik.balance}}</td></div>
 

  <div style="text-align: center">  <td>{{uzytkownik.active}}</td></div>



  <div style="text-align: center">  <td>{{uzytkownik.user_role_id}}</td></div>
<td>
<div> 

 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#{{uzytkownik.user_id}} ">Dane konta</button>

<!-- Modal -->
<div id={{uzytkownik.user_id}} class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="panel-primary">
      <div class="panel-heading">
   
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Dane konta:</h4>
      </div>
         </div>
      <div class="modal-body">
       <h5> <b> Dane nadawcy:</h5> </b> <hr/>
       <h7> <b> Imię użytkownika: </b> </h7> {{uzytkownik.userDetails.name}}  <hr/>
       <h7> <b> Nazwisko użytkownika: </b> </h7> {{uzytkownik.userDetails.lastname}} <hr/>
       <h7> <b> Adress: </b> </h7>  {{uzytkownik.userDetails.adress}} <hr/>
       <h7> <b> Kod pocztowy: </b> </h7> {{uzytkownik.userDetails.postalcode}} <hr/>
       <h7> <b> Adres email: </b> </h7> {{uzytkownik.username}} <hr/>
       <h7> <b> Środki: </b> </h7> {{uzytkownik.balance}} PLN <hr/>
       <h7> <b> Data zawarcia </b> </h7> {{transakcja.date}} <hr/>
       <input name="gracz" value = {{gracz}}> 
       {{gracz}}
      </div>
      <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
      </div>  </div>
    
   
  
      <div class="modal-footer">
       
      </div>
    </div>
</td>

 <td>
 <div> 
 <button type="button" class="btn" data-toggle="modal" data-target="#myModal">Zmiana aktywności konta</button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="panel-primary">
      <div class="panel-heading">
   
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Zmień status aktywności</h4>
      </div>
         </div>
      <div class="modal-body">
       
        <form:form action="changeaccountstatus" method= "POST">
 
  <hr />
   <div style= "text-align: center">
   <input  hidden name="username" value= "{{uzytkownik.username}}" />
   
     <select class="form-control"  name="status" > 
       <option value="true"> Aktywny</option>
      <option value="false"> Nieaktywny </option>

     </select>
          <button  class="btn btn-primary"> Zatwierdz </button>
       </form:form>
    
      <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
      </div>  </div>
    </div>
     </div>
  
      <div class="modal-footer">
       
      </div>
    </div>

  </div>

 
  </td>


<td>
 <div> 
 <button type="button" class="btn btn-success" data-toggle="modal" data-target="#{{uzytkownik.user_id}}1" >Zmiana uprawnień</button>

<!-- Modal -->
<div id="{{uzytkownik.user_id}}1" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="panel-success">
      <div class="panel-heading">
   
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Zmień uprawnień konta</h4>
      </div>
         </div>
      <div class="modal-body">
       
        <form:form action="changeaccountrole" method= "POST">
 
  <hr />
   <div style= "text-align: center">
   <input  hidden name="username" value= "{{uzytkownik.username}}" />
   
     <select class="form-control"  name="status" > 
       <option value="1"> Uprawnienia administratora</option>
      <option value="2"> Uprawnienia użytkownika </option>

     </select>
          <button  class="btn btn-success"> Zatwierdz </button>
       </form:form>
    
      <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
      </div>  </div>
    </div>
     </div>
  
      <div class="modal-footer">
       
      </div>
    </div>

  </div>

 
  </td>
<td>
 <div> 
 <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#{{uzytkownik.user_id}}2" >Usuń konto</button>

<!-- Modal -->
<div id="{{uzytkownik.user_id}}2" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
    <div class="panel-danger">
      <div class="panel-heading">
   
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Usuń konto</h4>
      </div>
         </div>
      <div class="modal-body">
       
        <form:form action="deleteaccount" method= "POST">
 
  <hr />
   <div style= "text-align: center">
   <input  hidden name="username" value= "{{uzytkownik.username}}" />
   
    
          <button  class="btn btn-danger"> Zatwierdz </button>
       </form:form>
    
      <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
      </div>  </div>
    </div>
     </div>
  
      <div class="modal-footer">
       
      </div>
    </div>

  </div>

 
  </td>
  </div>


	</tr>
    			</tbody>
    	
    		</table>

	   </div>
























<!--  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

<body>
<div ng-app="aplikacja">
<div class="container"  >

  <div ng-controller="kontrolertransakcji">

   
    	<div class="input-group-addon">
   			 <span> Szukaj</span>
   			
    		 <input class="form-control"  ng-model="{{wyszukiwarka}}">
         
        </div>
    
		<div class ="table-responsive">	

    		<table class="table table-hover">
    			<thead>
    				<th ng-repeat="naglowek in ['Id' , 'Imie', 'Hasło', 'Konto', 'Status aktywności konta']">
    				{{naglowek}}
    				</th>
    			</thead>
    
    			<tbody>
    				<tr ng-repeat='uzytkownik in uzytkownicy|filter:wyszukiwarka'>
    					<td>{{uzytkownik.user_id}}</td>
    					<td>{{uzytkownik.username}}</td>
    					<td>{{uzytkownik.password}}</td>
    				    <td>{{uzytkownik.balance}}</td>
    					<td>{{uzytkownik.active}}</td>
    				    
    				
    					
    				</tr>
    			</tbody>
    	
    		</table>
-->
	   </div>
</div>
</div>

     </div>

  <script>
  var app = angular.module('aplikacja' , [] );
  
  app.controller('kontrolertransakcji' , [ '$scope' , function( $scope ){ 
  		
  		                                  
  	    $scope.uzytkownicy = ${lista};
  }]);
  
  </script>


</body>



</html>