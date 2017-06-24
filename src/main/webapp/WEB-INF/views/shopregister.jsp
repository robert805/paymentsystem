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
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Utwórz konto</h3>
                    </div>
                    <div class="panel-body">
                    
                <div style="text-align: center" class="form-error">  <b><h1><img src="${adreszdjecia}" width= "80" ${hidden}>  ${komunikat1} </h1> </b> </div>
                    
                        <form:form commandName= "shop"  action= "shopregistersave" role="form"  method="POST">
                            <fieldset>
                              <div class="form-group">
                                    Nazwa: <input class="form-control" placeholder="Nazwa" name="name" path="name"  autofocus>
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "name"> </form:errors>
                                </div>
                              
                               
                                <div class="form-group">
                                    Adres: <input class="form-control" placeholder="Adres" name="address" path="address" >
                                </div>
                                  <div class="form-group error">
                                  <form:errors path= "address"> </form:errors>
                                </div>
                                
                           <div class="form-group">
                                    Telefon: <input class="form-control" placeholder="Telefon" name="phone" path="phone" autofocus>
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "phone"> </form:errors>
                                </div>
                                
                                 <div class="form-group">
                                    Kod pocztowy: <input class="form-control" placeholder="Kod pocztowy" name="postalcode" path="postalcode">
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "postalcode"> </form:errors>
                                </div>
                             
                             	 <div class="form-group">
                                    Województwo: <input class="form-control" placeholder="Województwo" name="voivodeship" path="voivodeship">
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "voivodeship"> </form:errors>
                                </div>
                               
                                <div class="form-group">
                                    Link danych: <input class="form-control" placeholder="Adres sklepu na który system wysłać ma dane o transakcji" name="link_send_data" path="link_send_data">
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "link_send_data"> </form:errors>
                                </div>
                             
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-success btn-block"> Dodaj sklep</button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>