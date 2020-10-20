<%--
  Created by IntelliJ IDEA.
  User: I56852
  Date: 28/02/2020
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail du Livre</title>


    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'/>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'/>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../css/font-awesome.min.css" type="text/css"/>

    <!-- Custom CSS -->
    <link rel="stylesheet" href="../../css/owl.carousel.css" type="text/css"/>
    <link rel="stylesheet" href="../../css/style.css" type="text/css"/>
    <link rel="stylesheet" href="../../css/responsive.css" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.css">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<!-- FavIcon -->
<link rel="icon" type="image/png" href="../../img/book-24px.png" />

<body>
<div>
<img src="../../img/indispo.png">

<form action="/save/reservation" method="post">
    <input type="hidden" name="bookId" id="bookId" value="${book.id}"/>
    <button class="btn btn-outline-success">Emprunter</button>
</form>
<form action="/waitingList" method="post">
    <input type="hidden" name="bookId" id="bookId" value="${book.id}"/>
    <button class="btn btn-outline-warning">Réserver</button>
</form>
</div>

<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- jQuery popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

<!-- Bootstrap JS form CDN -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="../../js/owl.carousel.min.js"></script>
<script src="../../js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="../../js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="../../js/main.js"></script>

<!-- Slider -->
<script type="text/javascript" src="../../js/bxslider.min.js"></script>
<script type="text/javascript" src="../../js/script.slider.js"></script>

<!-- jQuery UI -->
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<!-- jQuery anchor -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.2.0/anchor.min.js"></script>

</body>
</html>
