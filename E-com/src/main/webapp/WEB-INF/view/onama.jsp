<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Prime - O nama</title>
  <meta name="description" content=".....">
  <meta name="keywords" content=".....">
  <meta name="author" content="Aleksandar Vilus | aleksandar.vilus.it.obuka@gmail.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta name="robots" content="index">
  <link rel="icon" href="http://primetimewatches.net/media/favicon/default/favicon.ico" type="image/x-icon">

  <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/css/mojstil.css" rel="stylesheet">


</head>

<body>
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
    <div class="page-header">
      <h1><em>O NAMA</em></h1>
      <p>
        Kompanija Primetime osnovana je 2010. godine u Beogradu kao studio za grafički dizajn. Tokom godina je proširila
        svoju delatnost na marketing, konsalting, organizaciju promotivnih događaja i marketinšku produkciju.
      </p>
      <p>
        Od 2019. godine Primetime se bavi i poslovima distribucije satova i nakita, a u svom portfoliju za sada ima
        sledeće brendove: Haemmer Germany, Welder by Italo Fontana, U-Boat.
      </p>
      <p>
        Pored poslova distribucije, Primetime razvija i svoju maloprodajnu mrežu pod jedinstvenim imenom.
      </p>
      <p>
        Primetime posluje na tržištu regiona (Srbija, Crna Gora, Makedonija, Hrvatska, Slovenija i Bosna i Hercegovina).
      </p>
    </div>
    <!-- KRAJ NASLOVA STRANE -->

    <div class="page-header">

      <!-- POČETAK BOKSEVA -->

      <div class="row">

        <!-- GLAVNI SEGMENT -->

        <div class="col-md-6">
          <div class="mapa">

            <h2 class="page-header">
              Gde se nalazimo
            </h2>
            <iframe class="lokacija"
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2830.9758022439064!2d20.41792461549795!3d44.80168177909877!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a6fed108da8a7%3A0x9c662a8e931516fb!2sITS+-+Information+Technology+School!5e0!3m2!1sen!2srs!4v1549702265641"
              allowfullscreen></iframe>
          </div>
        </div>
        <div class="col-md-5">
          <div class="mapa">

            <h2 class="page-header">
              Kontakt
            </h2>
            <p><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i> Zadnja kuća 7, Novi Beograd 11090,
              Srbija </p>
            <p><i class="glyphicon glyphicon-phone-alt" aria-hidden="true"></i> +381 11 000 55 00</p>
            <p><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i> info@alobing.rs</p>
          </div>
        </div>


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