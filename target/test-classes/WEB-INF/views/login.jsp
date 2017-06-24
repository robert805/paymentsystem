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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/testowy/bootstrap.css" rel="stylesheet"  type="text/css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Login</title>
</head>
<body onload="document.f.j_username.focus();">



  
  <!--Panel logowania -->  
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Zaloguj sie</h3>
                    </div>
                    <div class="panel-body">
                        <form  role="form" name="f" action="/SpringMVC/j_spring_security_check" method="POST">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Email" name="j_username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Haslo" name="j_password" type="password" value="">
                                </div>
                              <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Zapamietaj
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button name="submit" type="submit" class="btn btn-lg btn-success btn-block">Zaloguj</button>

                               

                                <a href="register" class="btn btn-primary btn-outline btn-block">Utwórz konto</a>

                                <h5>Problem z logowaniem? Kliknij <a href="login_problem.html">tutaj</a></h5>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>