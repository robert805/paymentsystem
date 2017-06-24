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
<!--  script language="JavaScript">
function validateForm()
{
	// sprawdza imie
	if (document.forms[0].elements[0].value == "")
	{
		alert ("Wprowadź imię!");
		return false;
	}

	// sprawdza dlugosc hasła
	if (document.forms[0].elements[1].value.length < 100)
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
</script-->
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Edycja profilu</h3>
                    </div>
                    <div class="panel-body">
                        <form:form accept-charset="iso-8859-1" commandName= "userDetails"  action= "saveprofil" role="form"  method="POST" onSubmit="return validateForm();">
                            <fieldset>
                              
                              <div class="form-group">
                                    Imie: <input class="form-control"id= "name" placeholder="name" name="name" path="name" value="${userDetails.name}" autofocus>
                                </div>
                            
                                 <div class="form-group">
                                    Nazwisko: <input class="form-control" placeholder="lastname" name="lastname" path="lastname" value="${userDetails.lastname}" autofocus>
                                </div>
                                   
                                   
                                  
                                
                          
                                <div class="form-group">
                                    Data urodzenia: <input class="form-control" placeholder="age" name="age" path="age" value="${userDetails.age}" autofocus>
                                </div>
                            
                                <div class="form-group">
                                    Telefon: <input class="form-control" placeholder="phone" name="phone" path="phone" value="${userDetails.phone}" autofocus>
                                </div>
                                
                                 <div class="form-group">
                                    Adres: <input class="form-control" name="adress" path="adress" value="${userDetails.adress}" >
                                </div>
                                 
                                 <div class="form-group">
                                    Kod pocztowy: <input class="form-control" placeholder="postalcode" name="postalcode" path="postalcode" value="${userDetails.postalcode}" autofocus>
                                </div>
                                
                                 
                                 <div class="form-group">
                                 Województwo:
                           <select class="form-control" name="voivodeship">
                              <option value="Mazowieckie">Mazowieckie</option>
                              <option value="Śląskie">Śląskie</option>
                              <option value="Wielkopolskie">Wielkopolskie</option>
                              <option value="Małopolskie">Małopolskie</option>
                              <option value="Dolnośląskie">Dolnośląskie</option>
                              <option value="Łódzkie">Łódzkie</option>
                              <option value="Pomorskie">Pomorskie</option>
                              <option value="Lubelskie">Lubelskie</option>
                              <option value="Podkarpackie">Podkarpackie</option>
                              <option value="Kujawsko-Pomorskie">Kujawsko-Pomorskie</option>
                              <option value="Zachodniopomorskie">Zachodniopomorskie</option>
                              <option value="Warmińsko-Mazurskie">Warmińsko-Mazurskie</option>
                              <option value="Świętokrzyskie">Świętokrzyskie</option>
                              <option value="Podlaskie">Podlaskie</option>
                              <option value="Lubuskie">Lubuskie</option>
                              <option value="Opolskie">Opolskie</option>
                              
                              <option hidden selected="${userDetails.voivodeship}">${userDetails.voivodeship} </option>   
                                                         
    
  </select>
  </div>
  <div class="form-group">
                                    <input type="hidden" class="form-control"  placeholder="user_details_id" name="user_details_id" path="user_details_id" value="${userDetails.user_details_id}" autofocus>
                                </div>
                             <input type="hidden" class="form-control" placeholder="balance" name="balance" path="balance" value="${user.balance}" autofocus>
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-success btn-block"> Edytuj profil</button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>