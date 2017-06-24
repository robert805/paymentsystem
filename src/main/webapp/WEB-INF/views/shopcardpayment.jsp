<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<style>
table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}



th, td {
    padding: 15px;
}
</style>
<title>Shop Card Payment</title>
</head>
<body>

Do zapłaty: 
${lacznakwota}

Zapłacono:

 ${suma}

Twój stan konta wynosi: 

  ${balance}
  
  Numery wykorzystanych kart:
  
  <table>
   <c:forEach var="listValue" items="${sessionScope.listauzytychkart}"> 
   <td>
  <div class="panel panel-primary">
                  <div class="panel panel-heading"><h1>Karta Podarunkowa: </h1></div>
                    <div class="panel body">
  <div style="text-align: center"> Numer karty: ${listValue.shop_card_id} <hr/>
   
   Ilość środków: ${listValue.amount}  zł<hr/>
   Aktywność karty:  ${listValue.active}  <hr/>
    </div></div></div>
  </c:forEach>
  </td>
  </table>
  
  
  <table>
  
            
             <td>
                     <form:form  action = "shopcardpaymentcommit" method="POST" role="form" >
                     <input hidden name="lacznakwota" value=${lacznakwota} />
                     <input hidden name="suma" value=${suma} />
            <button class="btn btn-success"> Zatwierdz transakcję </button>
           </form:form>
                     </td> 
           <form:form  action = "shopcardpaymentsave" method="POST" role="form" >
                     <input hidden name="lacznakwota" value=${lacznakwota} />
                     <input hidden name="suma" value=${suma} />
                     <div class="form-group">
                          <input class="form-control" name="number" value="${number}"  type="number"  min="10000000" max="100000000" required/>
                     </div>
                                     
                          <div class="form-group error" >      ${error_active} </div>
                     <div class="form-group error" >      ${error_money} </div>
                                   
                     <td>    
                                    
                  <button class="btn btn-primary"> Użyj karty </button>
                  </td>
                  
            </form:form>
           <form:form  action = "shopcardpaymentbalancepay" method="POST" role="form" >                       
                     <input hidden name="lacznakwota" value=${lacznakwota} />
                     <input hidden name="suma" value=${suma} />                   
                          <td>           
                       <button class="btn btn-primary"> Dopłać środkami na koncie </button>             
                </td>
          </form:form>
                    <td>
                    <a href="transactioncancel" class="btn btn-danger"> Anuluj</a>
                    </td>                  
          </table>                            
                                      
                                  
       ${sessionScope.cardThatOverfill}  
       ${sessionScope.cardThatOverfillMoneyToTake}                              
       ${sessionScope.balance}                              
                                      
</body>
</html>