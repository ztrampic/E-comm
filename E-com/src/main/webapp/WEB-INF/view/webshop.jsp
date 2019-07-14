<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Prime - Webshop</title>
  <meta name="description" content=".....">
  <meta name="keywords" content=".....">
  <meta name="author" content="Aleksandar Vilus | aleksandar.vilus.it.obuka@gmail.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta name="robots" content="index">
  <link rel="icon" href="http://primetimewatches.net/media/favicon/default/favicon.ico" type="image/x-icon">

  <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/css/mojstil.css" rel="stylesheet">

  <link href="css/mojstil_galerija.css" rel="stylesheet">


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
      <h1><em>WEBSHOP</em></h1>
    </div>
    <!-- KRAJ NASLOVA STRANE -->
    <form class="prodavnica" id="proizvodi">
    	<c:forEach var="brend" items="${sviBrendovi}">
	  <div class="page-header">

        <!-- POČETAK BOKSEVA -->
        <div class="row">
          <div class="col-xs-3 col-sm-3 col-md-0">

          </div>
          <div class="col-xs-6 col-sm-6 col-md-12">
            <img id="HaGe" src="${pageContext.request.contextPath }/images/${brend.nazivSlike}" class="img-responsive" alt="Haemmer Germany">

          </div>
        </div>

        <div class="row">

          <!-- BOČNI SEGMENT KOJI SLUŽI SAMO ZA ODVAJANJE -->
          <div class="col-xs-2 col-md-1">
          </div>

          <!-- GLAVNI SEGMENT -->
          <div class="col-xs-8 col-md-10">

            <!-- POČETAK DELA SA FOTOGRAFIJAMA PROIZVODA -->
            <div class="okvir0">

              <!-- FOTOGRAFIJA 1 -->
              <c:forEach var = "proizvod" items="${sviProizvodi}">
              <c:if test="${proizvod.brend.id_brand == brend.id_brand}">
              	<c:if test="${proizvod.brend.id_brand == proizvod.brend.id_brand}">
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>DHC-12 Zeno</strong>
                    </h3>
                  
                  <a>
                    <img src="${pageContext.request.contextPath }/images/${proizvod.nazivSlike}" alt="DHC-12 Zeno">
                  </a>
                </div>
                <p>
                  <strong>40,150.00 RSD</strong>
                </p>
                <p>
                  Naručujem <label for="jedan"></label>
                  <input type="text" id="jedan" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    Završi kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>
              		</c:if>
            	</c:if>
			 </c:forEach>
            </div>
           
            <!-- KRAJ SA FOTOGRAFIJAMA PROIZVODA -->

          </div>

        </div>
        <!-- KRAJ BOKSEVA -->

      </div>
      

</c:forEach>
      <div class="page-header">

        <div id="krajodabira">
          <div class="row">
            <div class="col-md-12">
              <h2>
                Detalji narudzbenice
              </h2>

              <div class="grupaizracunavanje">
                <p>
                  <label for="btn-izracunaj">

                  </label>
                  <input type="submit" value="Ukupan iznos" id="btn-izracunaj" name="">
                  <input type="text" id="txt-izracunaj" placeholder="0.00 RSD" name="">
                </p>
                <div id="rezultati">
                </div>
                <br>
                <div id="rezultati1">
                </div>
                <p>
                  <a class="btn btn-primary btn-lg" href="kontakt.html" role="button">Prijavite se</a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>

    </form>
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

  <script src="${pageContext.request.contextPath }/js/korpa.js"></script>


</body>

</html>