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
                    
                        <form:form commandName= "shopCard"  action= "shopcardaddsave" role="form"  method="POST">
                            <fieldset>
                              <div class="form-group">
                                    Kwota: <input class="form-control" placeholder="Nazwa" name="amount" path="amount"  autofocus>
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "name"> </form:errors>
                                </div>
                              
                               
                                <div class="form-group">
                                    Ilość: <input class="form-control" placeholder="Ilość" name="howmuch" path="howmuch" >
                                </div>
                                  <div class="form-group error">
                                  <form:errors path= "address"> </form:errors>
                                </div>
                                
                             
                                <div class="form-group">
                                    Id sklepu : <input class="form-control" placeholder="Adres" name="shop_id" path="shop_id" value=${shop_id} >
                                </div>
                               
                                
                             
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-success btn-block"> Dodaj karty</button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>