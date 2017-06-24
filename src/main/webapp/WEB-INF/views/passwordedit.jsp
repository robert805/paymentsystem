<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zmien haslo</title>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Zmien haslo</h3>
                    </div>
                    <div class="panel-body">
                        <form:form commandName= "user"  action= "savepassword" role="form"  method="POST">
                            <fieldset>
                             
                                <input type="hidden" class="form-control"  placeholder="user_id" name="user_id" path="user_id" value="${user.user_id}" autofocus>
                             
                                <input type="hidden" class="form-control" placeholder="username" name="username" path="username" value="${user.username}" autofocus>
                                
                                 <input type="hidden" class="form-control" placeholder="user_role_id" name="user_role_id" path="user_role_id" value="${user.user_role_id}" autofocus>
                                 
                                  <input type="hidden" class="form-control" placeholder="user_details_id" name="user_details_id" path="user_details_id" value="${user.user_details_id}" autofocus>
                                  
                                   <input type="hidden" class="form-control" placeholder="active" name="active" path="active" value="${user.active}" autofocus>
                                  
                                   <input type="hidden" class="form-control" placeholder="balance" name="balance" path="balance" value="${user.balance}" autofocus>
                                  
                                  <div class="form-group">
                                   Aktualne Haslo: <input class="form-control" placeholder="Aktualne haslo" name="password_actual" path="password_actual" type="password" required>
                                </div>
                                    <div class="form-group has-error">
                               ${error_psw1}
                                </div>
                                    <div class="form-group">
                                   Nowe Haslo: <input class="form-control" placeholder="Nowe haslo" name="password" path="password" type="password" required >
                                </div>
                                  <div class="form-group error">
                                  <form:errors path= "password"> </form:errors>
                                </div>
                              <div class="form-group">
                                   Powtorz Haslo: <input class="form-control" placeholder="Powtorz haslo" name="password_check" type="password"  required>
                                </div>
                                
                              <div class="form-group has-error">
                               ${error_psw}
                                </div>
                          
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-success btn-block"> Edytuj haslo</button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>