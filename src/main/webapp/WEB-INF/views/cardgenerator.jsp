<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap Core CSS -->
    <link href="../css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="JavaScript">
function validateForm()
{
	// sprawdza imie
	if (document.forms[0].elements[0].value == "")
	{
		alert ("Wprowadź imię!");
		return false;
	}

	// sprawdza dlugosc hasła
	if (document.forms[0].elements[1].value.length < 6)
	{
		alert ("Wprowadź hasło składające sie przynajmniej z 6 znaków!");
		return false;
	}

	// sprawdza adres email

	// sprawdza wiek
	if (isNaN(document.forms[0].elements[3].value))
	{
		alert ("Wprowadź prawidłowy wiek!");
		return false;
	}

	// sprawdza zakres wieku
	if (parseInt(document.forms[0].elements[3].value) < 1 ||
parseInt(document.forms[0].elements[3].value) > 99)
	{
		alert ("Wprowadź wiek mieszczący się w zakresie 1-99!");
		return false;
	}

	return true;
}
</script>
<title>Generator</title>
</head>
<body>

<a href="http://localhost:8080/SpringMVC/users/hello">Wyloguj</a>
<div class="container">
        
            
                <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Generator Kart</h3>
                    </div>
                    <div class="panel-body">
                        <form:form accept-charset="ISO-8859-1" action= "createcard" role="form"  method="POST">
                            <fieldset>
                              
                              <div class="form-group">
                                    Kwota: <input class="form-control" placeholder="kwota" name="amount" path="amount">
                                </div>
                            
                                
                                
                                 
                                
            
                                <button class="btn btn-lg btn-success btn-block"> Wygeneruj </button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
                
                 <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Lista kart</h3> </div>
                    <div class="panel-body">
                   
                   
                   
                    <table class="table">
                    
                    <thead>
                <tr><td> Numer Karty: </td> 
                    <td> Kwota: </td> 
                    <td> Status: </td> </tr>
                    </thead>
                     <c:forEach var="listValue" items="${lista}">
                   <tr>
                    <td> ${ listValue.id } </td> 
                    <td> ${ listValue.amount} </td>
                    <td> ${ listValue.active} </td>
                    
                    </tr> 
                    
                 
                   
                    
                    </c:forEach>
                    
                    
                    </table>
                    
                    
                    </div>
        </div>
    
    
</div> 

           
               
          
  

</body>
</html>