<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Prime - Home</title>
  <meta name="description" content=".....">
  <meta name="keywords" content=".....">
  <meta name="author" content="Aleksandar Vilus | aleksandar.vilus.it.obuka@gmail.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta name="robots" content="index">
  <link rel="icon" href="http://primetimewatches.net/media/favicon/default/favicon.ico" type="image/x-icon">

  <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }css/mojstil.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }css/mojstil_index.css" rel="stylesheet">


</head>

<body onload="citati()">
	

  <!-- POČETAK OMOTAČA -->
  <div class="container">

    <!-- POČETAK HEDER-A -->
    <div class="page-header">
      <img src="${pageContext.request.contextPath }/images/primetime/primetime-head-inv.png">
    </div>

    <!-- KRAJ HEDER-A -->

    <!-- OVO JE POCETAK NAVIGACIJE -->
    <nav class="navbar navbar-default" data-spy="affix">
      <!--afix FIKSIRANJE NAVIGACIJE-->
      <h2>Glavna navigacija</h2>
      <div class="container-fluid">

        <!-- POČETAK DELA KOJI KREIRA BURGER -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/index">
            PRIME
          </a>
        </div>
        <!-- KRAJ DELA KOJI KREIRA BURGER -->

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">

            <!-- POČETAK PADAJUĆEG MENIJA -->
           
            <li class="dropdown">
              <a href="#s" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                aria-expanded="false">BRENDOVI <span class="caret"></span></a>
              <ul class="dropdown-menu">
               <c:forEach var="temp" items="${sviBrendovi}">
               		 	<c:url var="ucitajProizvodeBrenda" value="/proizvodiBrenda/${temp.id_brand}">
 						<c:param name ="ucitajProizvodeBrenda" value="${temp.id_brand}"/>
						</c:url> 
               		<li><a href="${ucitajProizvodeBrenda}">${fn:toUpperCase(temp.naziv)}</a>
               			
               		</li>
               	
               </c:forEach>
              </ul>
            </li>
            <!-- KRAJ PADAJUĆEG MENIJA -->

            <li><a href="/webshop">PRODAVNICA</a></li>
            <li><a href="/onama">O NAMA / KONTAKT</a></li>
            <li><a href="/login">LOGIN</a></li>

        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
    <!-- KRAJ NAVIGACIJE -->
	
    <!-- POČETAK NASLOVA STRANE -->
    <div id="GlTxt" class="page-header">
      <h1><em>Vreme je za Primetime!!!</em></h1>
      <p>Dobrodošli u PRIMETIME, on line prezentaciju i prodavnicu ekskluzivnog regionalnog distributera poznatih
        svetskih brendova satova.</p>

      <p>U PRIMETIME-u ćete pronaći sve potrebne informacije i novosti o brendovima koje zastupamo: Haemmer, Welder,
        U-Boat.</p>

      <p>PRIMETIME online prodavnica nudi najveći izbor modela ovsih brendova uz dodatne pogodnosti, poklone i akcije.
      </p>

      <p>Za sva pitanja, komentare i sugestije stojimo vam na raspolaganju. Možete nas kontaktirati putem maila,
        facebook-a, twiter-a ili telefonom.</p>
    </div>
    <!-- KRAJ NASLOVA STRANE -->


    <!-- POČETAK KARUSELA -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

      <!-- MEHURIĆI -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      </ol>
	
      <!-- FOTKE -->
      
      <div class="carousel-inner" role="listbox">
      <c:set var="brend" value="${sviBrendovi[0]}" ></c:set>
       <div class="item active">		
          <a href="/proizvodiBrenda/${sviBrendovi[0].id_brand}">
            <img src="${pageContext.request.contextPath }/images/${brend.nazivSlike}" alt="Welder by Italo Fontana">
          </a>
          <div class="carousel-caption">
          </div>
        </div>
        <c:forEach var="sviBrendovi" items="${sviBrendovi}">
       	<c:url var="ucitajProizvodeBrenda" value="/proizvodiBrenda/${sviBrendovi.id_brand}">
 			<c:param name ="ucitajProizvodeBrenda" value="${sviBrendovi.id_brand}"/>
			</c:url> 
        <div class="item">
          <a href="${ucitajProizvodeBrenda}">
            <img src="${pageContext.request.contextPath }/images/${sviBrendovi.nazivSlike}">
          </a>
          <div class="carousel-caption">
          </div>
        </div>
        </c:forEach>
      </div>

      <!-- KONTROLE KARUSELA -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
    <!-- KRAJ KARUSELA -->

    <div class="page-header">
      <!-- POČETAK BOKSEVA -->
      <div class="row">
        <!-- POČETAK LEVOG BOKSA -->
        <div class="col-md-8">
          <div class="jumbotron">
            <h2>Aktueno</h2>

            <p>Promotivna prodaja Haemmer satova.
              Ovog meseca cene snižene 40%. Prijavite se da bi ste dobili detaljnije informacije.
            </p>
            <br>
            <p><a class="btn btn-primary btn-lg" href="/admin" role="button">ADMIN TEMP  <i
                  class="fas fa-arrow-alt-circle-right"></i></a></p>	
          </div>
			
        </div>
        <!-- KRAJ LEVOG BOKSA -->

        <!-- POČETAK DESNOG BOKSA -->
        <div class="col-md-4">
          <div class="jumbotron">

            <h2>Rekli su</h2>
            <blockquote>
              <p id="citat"></p>
              <small><cite id="author"></cite></small>
            </blockquote>

          </div>
        </div>
        <!-- KRAJ DESNOG BOKSA -->
      </div>
      <!-- KRAJ BOKSEVA -->
    </div>


    <!-- POČETAK FOOTER-A -->
    <footer>
      <div class="row">

        <div class="col-md-12">

          <ul id="SoNet" class="list-inline">
            <li><a href="http://facebook.com/"><i class="fab fa-facebook-f fa-3x"></i></a></li>
            <li><a href="http://instagram.com/"><i class="fab fa-instagram fa-3x"></i></a></li>
            <li><a href="http://twitter.com/"><i class="fab fa-twitter fa-3x"></i></a></li>
          </ul>
        </div>
      </div>
      <!-- kraj gornjeg dela footer-a -->
      <!-- donji deo footer-a -->
      <div class="panel-footer">
        <div class="row">

          <div class="col-md-12">
            <p class="text-right">Copyright &copy; 2019 Aleksandar Vilus &#64; CODE</p>
          </div>
        </div>
      </div>
      <!-- kraj donjeg dela footer-a -->
    </footer>
    <!-- KRAJ FOOTER-A -->
  </div>
  <!-- KRAJ OMOTAČA -->


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/mojjs.js"></script>
	
</body>

</html>