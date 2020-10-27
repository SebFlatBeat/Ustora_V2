<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title>Détails du livre ${book.titre}</title>

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

<!-- FavIcon -->
<link rel="icon" type="image/png" href="../../img/book-24px.png" />

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
                                <a class="dropdown-item" href="<c:url value="/index"/>">Acceuil</a>
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
                <a class="nav-link" href="<c:url value="/espacePerso"/>">Mon espace Perso</a>
            </li>

        </ul>
    </div>
</nav>
<!-- End nav area -->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h2>${book.titre}</h2>
            <img src="../../img/indispo.png">
            <h3>${book.auteurPrincipalNom} ${book.auteurPrincipalPrenom}</h3>
        </div>
        <div class="service-box team boxed-grey col-md-12 ml-auto mr-auto">
            <h3 class="text-center">Informations</h3>
            <table class="table table-responsive-lg table-striped table-hover">
                <thead class="thead-dark">
                <tr class="bg-primary">
                    <th class="text-center" scope="col">Nbre d'exemplaire</th>
                    <th class="text-center" scope="col">Date de retour prévue</th>
                    <th class="text-center" scope="col">Nbre de reservation demandée</th>
                    <th class="text-center" scope="col">Nbre de reservation maximum</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td class="text-center" scope="row">${book.nbreExemplaire}</td>
                    <td class="text-center" scope="row">
                        <fmt:formatDate value="${waitingList[0].dateDeRetour}" type="date" pattern="dd.MM.yyyy" />
                    </td>
                    <td class="text-center" scope="row">${waitingList[0].nbreDeDemande}</td>
                    <td class="text-center" scope="row">${book.nbreExemplaireTotal*2}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="alert alert-warning col-lg-12" role="alert">
                <p>${errorMessage}</p>
            </div>
        </c:if>
        <div class="col-lg-12">
            <div class="btn-group-justified">
                <c:if test="${book.nbreExemplaire!=0}">
                    <form action="/save/reservation" method="post">
                        <input type="hidden" name="bookId" id="bookId" value="${book.id}"/>
                        <button class="btn btn-outline-success btn-lg aligncenter ml-auto mr-auto">Emprunter</button>
                    </form>
                </c:if>
                <c:if test="${book.nbreExemplaire==0}">
                    <button class="btn btn-outline-dark btn-lg disabled aligncenter ml-auto mr-auto">Emprunter</button>
                </c:if>
                <c:if test="${book.nbreExemplaire==0 && book.nbreExemplaireTotal*2 ne waitingList[0].nbreDeDemande}">
                    <form action="/waitingList" method="post">
                        <input type="hidden" name="bookId" id="bookId" value="${book.id}"/>
                        <button class="btn btn-outline-warning btn-lg aligncenter ml-auto mr-auto">Réserver</button>
                    </form>
                </c:if>
                <c:if test="${book.nbreExemplaire!=0 || book.nbreExemplaireTotal*2==waitingList[0].nbreDeDemande}">
                    <button class="btn btn-outline-dark disabled btn-lg aligncenter ml-auto mr-auto">Réserver</button>
                </c:if>
                <button class="btn btn-outline-primary btn-lg aligncenter ml-auto mr-auto"><a href="<c:url value="/index"/>">Retour</a></button>
            </div>
        </div>
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
