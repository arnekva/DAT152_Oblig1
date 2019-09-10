<!doctype html>

<html lang="no">
<head>
  <meta charset="utf-8">

  <title>Hjem</title>

  <link rel="stylesheet" href="css/styles.css?v=1.0">
<style>
.prod{
  margin:5px;
}
th, td{
  padding:10px;
}
.list-container {
position: relative;

}
.list-container:not(:first-child) {
margin-top:50px;
}
.container{
  margin-top:50px;
}
img{
  position: absolute;
    top: 0;
    bottom: 0;
    margin: auto;
    margin-right:100px;
}
th{
  width:10px;
}
.prod-img{
  min-height:50px;
  margin-right:100px;
}
.prod{
  margin-left:100px;
  text-align:left;
}
.btn-cart{
  background-color:#a3a3a3;
  color:white;
  height:35px;
  width:90px;
  border-radius:10px;
  text-decoration:none;
  font-size:1rem;
}
footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 50px;
}
  </style>
</head>

<body>
<div class="locale"><a class="locale_link" href="#">Norsk</a>
  <a class="locale_link" href="#">English (US)</a>
  <a class="locale_link" href="#">Español</a>
</div>
<nav><a href="index.html">HJEM</a><a href="cart.html">CART</a></nav>
<div class="container">
<div class="list-container">
<table class="prod">
<img class="prod-img"src="img/sco2.jpg" alt="" border=0 height=100 width=100></img>
  <tr>
    <th>Merke: </th>
    <td>Bydue</td>
  </tr>
  <tr>
    <th>Modell: </th>
    <td>Pro Duo 2000</td>
  </tr>
  <tr>
    <th>Rekkevidde: </th>
    <td>25-30 km</td>
  </tr>
  <tr>
    <th>Pris: </th>
    <td>4999 kr</td>
  </tr>
  <tr><td ><button class="btn-cart"value="Handlekurv">Legg til</button></td></tr>
</table>

</div>
<div class="list-container">
<table class="prod">
<img class="prod-img"src="img/sco1.jpeg" alt="" border=0 height=100 width=100></img>
  <tr>
    <th>Merke: </th>
    <td>HaraldWalk</td>
  </tr>
  <tr>
    <th>Modell: </th>
    <td>Max XR 500</td>
  </tr>
  <tr>
    <th>Rekkevidde: </th>
    <td>10 - 15 km</td>
  </tr>
  <tr>
    <th>Pris: </th>
    <td>7499 kr</td>
  </tr>
  <tr><td ><button class="btn-cart"value="Handlekurv">Legg til</button></td></tr>
</table>

</div>
</div>
<footer>(c) xxx HvL</footer>
</body>
</html>
