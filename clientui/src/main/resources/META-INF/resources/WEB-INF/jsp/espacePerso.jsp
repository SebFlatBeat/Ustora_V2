<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Espace de ${pageContext.request.userPrincipal.name}</title>

    <!-- FavIcon -->
    <link rel="icon" type="image/png" href="../../img/book-24px.png" />

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
<body>

<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-4 mr-auto">
                <div class="logo ml-auto">
                    <h1><a href="<c:url value="/index"/>"><img src="../../img/logo.png"/></a></h1>
                </div>
            </div>
            <div class="col-md-4">
                <div class="user-menu text-right">
                    <ul class="navbar-brand">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-user"></i>${pageContext.request.userPrincipal.name}</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/espacePerso"/>">Espace Perso</a>
                                <a class="dropdown-item" href="<c:url value="/logout"/>">Déconnexion</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End header area -->

<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link"  href="<c:url value="/index"/>">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/espacePerso#prets"/>">Mes prêts</a>
            </li>
        </ul>
    </div>
</nav>
<!-- End nav area -->
&nbsp;
&nbsp;
&nbsp;

<section id="prets">
    <div class="service-box team boxed-grey col-md-10 ml-auto mr-auto">
        <h3 class="text-center">Prêt en cours</h3>
        <table class="table table-responsive-lg table-striped table-hover">
            <thead class="thead-dark">
            <tr class="bg-primary">
                <th class="text-center" scope="col"> Numéro de réservation</th>
                <th class="text-center" scope="col"> Nom du Livre</th>
                <th class="text-center" scope="col">Date d'emprunt</th>
                <th class="text-center" scope="col">Date de fin de prêt</th>
                <th class="text-center" scope="col"></th>
                <th class="text-center" scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="available" items="${userReservation}">
                <tr>
                    <td class="text-center" scope="row">${available.id}</td>
                    <td class="text-center" scope="row">${available.book.titre}</td>
                    <td class="text-center" scope="row">
                        <fmt:formatDate value="${available.borrowing}" type="date" pattern="dd.MM.yyyy" />
                    </td>
                    <td class="text-center" scope="row">
                        <fmt:formatDate value="${available.endBorrowing}" type="date" pattern="dd.MM.yyyy" />
                    </td>
                    <td class="text-center" scope="row">
                        <c:if test="${available.extend == false}">
                        <form method="post" action="/extend/reservation">
                               <div>
                                   <fmt:formatDate var="dateDuJour" value="${now}" pattern="dd.MM.yyyy" />
                                   <c:if test="${available.endBorrowing>dateDuJour}">
                                    <span>${message}</span>
                                   </c:if>
                               </div>
                                <button class="btn btn-outline-success" name="id" id="id" value="${available.id}">Renouveller</button>
                        </form>
                        </c:if>
                        <c:if test="${available.extend == true}">
                            <button class="btn btn-outline-danger disabled" name="id" id="id" value="${available.id}">Renouveller</button>
                        </c:if>
                    </td>
                        <td class="text-center" scope="row">
                        <form method="post" action="/delete/reservation">
                                <button class="btn btn-outline-primary" name="id" id="id" value="${available.id}">Rendre</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<!-- End section prets area -->

<section id="account">

</section>
<!-- End section account area -->


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

<!-- jQuery chosen -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.jquery.js"></script>

<!-- jQuery anchor -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/anchor-js/4.2.0/anchor.min.js"></script>

<!-- Chosen Script -->
<script type="text/javascript">
    $(function() {
        $(".chosen-select").chosen();
    });
</script>

</body>
</html>
