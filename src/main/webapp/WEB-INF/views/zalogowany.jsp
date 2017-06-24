<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"      "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <script>
$(function() {
    $( "#datepicker" ).datepicker();
});
</script>
 <title>Test</title>
</head>
<body>
<form:form action="activities" method= "POST" >

<input name="afte" type="text" path="afte" /> 
<button>Submit</button>
</form:form>
człowiek

<form method="post" name="userDto" action="activitiessearch">
    <input name="username"/>
    <input name="password"/>
    <input type="submit"/>
</form>

Date: <input type="text" id="datepicker" />
</body>
  </html>