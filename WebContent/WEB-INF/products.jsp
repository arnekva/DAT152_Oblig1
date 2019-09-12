<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="store" />
<!doctype html>

<html lang="no">
<head>
  <meta charset="utf-8">

  <title><fmt:message key="page_title" /></title>

  <link rel="stylesheet" href="css/scooter.css">
<style>

  </style>
</head>

<body>
<div class="locale"><a class="locale_link" href="#">Norsk</a>
  <a class="locale_link" href="#">English (US)</a>
  <a class="locale_link" href="#">EspaÃ±ol</a>
</div>
<nav><a href="index.html"><fmt:message key="link_home" /></a><a href="cart.html"><fmt:message key="link_cart" /></a></nav>
<p><fmt:message key="welcome_message" /></p>

<div class="container">
<div class="list-container">
<c:forEach var="product" items="${products}"  varStatus="loop">
<table class="prod">
  <tr>
    <th><fmt:message key="product_nr_txt" /></th>
    <td>${product.prodnr}</td>
  </tr>
  <tr>
    <th><fmt:message key="product_name_txt" /></th>
    <td>${product.navn}</td>
  </tr>
  <tr>
    <th><fmt:message key="product_price_txt" /></th>
    <td>${product.pris}</td>
  </tr>
  <tr><td ><button class="btn-cart"value="Handlekurv"><fmt:message key="button_add" /></button></td></tr>
</table>
    
</c:forEach>

</div>

</div>
</body>
</html>
