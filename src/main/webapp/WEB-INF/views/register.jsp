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
                        <form:form commandName= "user"  action= "save" role="form"  method="POST">
                            <fieldset>
                              <div class="form-group">
                                    Email: <input class="form-control" placeholder="Email" name="username" path="username" type="email" autofocus>
                                </div>
                                       <div class="form-group error">
                                <form:errors path= "username"> </form:errors>
                                </div>
                               <div class="form-group error">
                               ${error_exist}
                                </div>
                               
                                <div class="form-group">
                                    Haslo: <input class="form-control" placeholder="Haslo" name="password" path="password" type="password" value="">
                                </div>
                                  <div class="form-group error">
                                  <form:errors path= "password"> </form:errors>
                                </div>
                              <div class="form-group">
                                   Powtorz Haslo: <input class="form-control" placeholder="Powtorz haslo" name="password_check" type="password" value="">
                                </div>
                                
                              <div class="form-group error">
                               ${error_psw}
                                </div>
                               
                                <div class="form-group">
                                 Wybierz rodzaj konta:
                           <select class="form-control" name="account_type">
                              <option value="User"> Konto użytkownika</option>
                              <option value="ShopUser">Konto właściciela sklepu</option>
                                </select>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="accept" type="checkbox" required value="Remember Me">Akceptuje warunki <a href="regulamin.html" target="_blank">Regulaminu</a>
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-success btn-block"> Utworz konto</button>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>