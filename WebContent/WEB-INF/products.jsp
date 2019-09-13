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
<div id="page-container">
<div id="content-wrap">
 <span class="lang">
        <form>
            <select name="language" onchange="submit()">
            <option value="" selected disabled hidden>Choose language</option>
                <option value="en_US" ${language == 'en' ? 'selected' : ''}>English (US)</option>
                <option value="de_DE" ${language == 'ru' ? 'selected' : ''}>Deutsch (DE)</option>
                <option value="nb_NO" ${language == 'nb' ? 'selected' : ''}>Norsk (Bokmål)</option>
            </select>
        </form>
    </span>
<nav><a class="fancy-link" href="home"><fmt:message key="link_home" /></a><a class="fancy-link" href="cart"><fmt:message key="link_cart" /></a><a class="fancy-link" href="products"><fmt:message key="link_products" /></a></nav>
<h2><fmt:message key="welcome_message" /></h2>
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
  <tr><td >
  <form method="post">
	<input type="hidden" name="prodnr" value="${product.prodnr}"/>
	<button onclick="submit()" ><fmt:message key="button_add" /></button>
  </form>
  </td></tr>
</table>
</c:forEach>
</div>
</div>
</div>
<footer id="footer">footer Footer footer Footer footer Footer footer (c) 2019 Footer, inc. under exclusive licence from Fotsopp ltd., a FotFooterFoot company. All rights reserved. Regional restrictions may apply. </footer>
</div>
</body>
</html>
