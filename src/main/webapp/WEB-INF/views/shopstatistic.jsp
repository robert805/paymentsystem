<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statystyka sklepu</title>
</head>
<body>

Sklep o nazwie :  ${shop.name} <hr/>
 Adres:  ${shop.address} <hr/> 
  Telefon:  ${shop.phone} <hr/> 
  Kod pocztowy:  ${shop.postalcode}<hr/>
  Link sklepu odbierania danych  ${shop.link_send_data} <hr/>
  Unikalny numer identyfikacyjny sklepu:  ${shop.shop_id} <hr/>
Posiada : 150 aktywnych kart <hr/>

Zakupy w sklepie wykonano: 120 razy <hr/>

</body>
</html>



