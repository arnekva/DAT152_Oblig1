<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ex" uri="descuri" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="store" />
<!doctype html>

<html lang="${language}">
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
        <form method="post">
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

<img class="front-img" src="img/are_favorite.jpg"/>
<h4><fmt:message key="have_a_look" /><a href="products"><fmt:message key="link_products" /></a></h4>
</div>
<footer id="footer"><ex:Copyright since="2008">HVL</ex:Copyright></footer>
</div>
</body>
</html>
