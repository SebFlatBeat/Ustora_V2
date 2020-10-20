<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
ustora by freshdesignweb.com
Twitter: https://twitter.com/freshdesignweb
URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bibliotheque Ustora</title>

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
                        <c:if test="${pageContext.request.userPrincipal == null}">
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/register"/>"><i class="fa fa-user"></i> Creer Compte</a></li>
                            <li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>"><i class="fa fa-user"></i>Connexion</a>
                            </li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal != null}">

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-user"></i>${pageContext.request.userPrincipal.name}</a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="<c:url value="/espacePerso"/>">Espace Perso</a>
                                    <a class="dropdown-item" href="<c:url value="/logout"/>">Déconnexion</a>
                                </div>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End header area -->

<div class="slider-area">
    <!-- Slider -->
    <div class="block-slider block-slider4">
        <ul class="" id="bxslider-home4">
            <li>
                <img src="../../img/h4-slide.png" alt="Slide">
                <div class="caption-group">
                    <h2 class="caption title">
                        J.R.R <span class="primary"><strong>Tolkien</strong></span>
                    </h2>
                    <h4 class="caption subtitle">Beowulf</h4>
                </div>
            </li>
            <li><img src="../../img/h4-slide2.png" alt="Slide">
                <div class="caption-group">
                    <h2 class="caption title">
                        Jules <span class="primary"><strong>Verne</strong></span>
                    </h2>
                    <h4 class="caption subtitle">L'étonnante aventure de la mission barsac</h4>

                </div>
            </li>
            <li><img src="../../img/h4-slide3.png" alt="Slide">
                <div class="caption-group">
                    <h2 class="caption title">
                        Stephen <span class="primary"><strong>King</strong></span>
                    </h2>
                    <h4 class="caption subtitle">The Mist</h4>
                </div>
            </li>
            <li><img src="../../img/h4-slide4.png" alt="Slide">
                <div class="caption-group">
                    <h2 class="caption title">
                        Mary <span class="primary">Higgins <strong>Clark</strong></span>
                    </h2>
                    <h4 class="caption subtitle">Dernière Danse</h4>
                </div>
            </li>
        </ul>
    </div>
    <!-- ./Slider -->
</div> <!-- End slider area -->


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="boxed-grey">
                <form id="contact-form" action="/">
                    <h2 class="text-lg-center">Rechechez votre livre</h2>
                    <div class="row">
                        <div class="form-group col-md-3 ">
                            <label for="titre" class="">Le livre</label>
                            <select id="titre" name="titre" class="chosen-select form-control" data-placeholder="Cherchez par livre" >
                                <option></option>
                                <c:forEach var="titre" items="${titres}">
                                    <option value="${titre}">${titre}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="auteurPrincipalNom">Nom d'auteur</label>
                            <select id="auteurPrincipalNom" name="auteurPrincipalNom" class="chosen-select form-control" data-placeholder="Cherchez par nom d'auteur" >
                                <option></option>
                                <c:forEach var="auteurNom" items="${auteurNoms}">
                                    <option value="${auteurNom}">${auteurNom}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="auteurPrincipalPrenom">Prénoms</label>
                            <select id="auteurPrincipalPrenom" name="auteurPrincipalPrenom" class="chosen-select form-control" data-placeholder="Cherchez par prénom" >
                                <option></option>
                                <c:forEach var="auteurPrenom" items="${auteurPrenoms}">
                                    <option value="${auteurPrenom}">${auteurPrenom}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="editeur">Editeur</label>
                            <select id="editeur" name="editeur" class="chosen-select form-control" data-placeholder="Cherchez par prénom" >
                                <option></option>
                                <c:forEach var="editeur" items="${editeurs}">
                                    <option value="${editeur}">${editeur}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-3 ">
                            <label for="anneeEdition" class="">Année d'édition</label>
                            <select id="anneeEdition" name="anneeEdition" class="chosen-select form-control" data-placeholder="Cherchez par année" >
                                <option></option>
                                <c:forEach var="anneeEdition" items="${anneeEditions}">
                                    <option value="${anneeEdition}">${anneeEdition}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="section" class="">Section</label>
                            <select id="section" name="section" class="chosen-select form-control" data-placeholder="Cherchez par section" >
                                <option></option>
                                <c:forEach var="section" items="${sections}">
                                    <option value="${section}">${section}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3 ">
                            <label for="isbn" class="">ISBN</label>
                            <select id="isbn" name="isbn" class="chosen-select form-control" data-placeholder="Cherchez par ISBN" >
                                <option></option>
                                <c:forEach var="isbn" items="${isbns}">
                                    <option value="${isbn}">${isbn}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-md-3 ">
                            <button class="btn btn-outline-primary ml-auto mr-auto">Chercher</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="service-box team boxed-grey">
            <table class="table table-responsive-lg table-striped table-hover">
                <thead class="thead-dark">
                <tr class="bg-primary">
                    <th class="text-center" scope="col">Livre</th>
                    <th class="text-center" scope="col">Nom de l'auteur</th>
                    <th class="text-center" scope="col">Prénom de l'auteur</th>
                    <th class="text-center" scope="col"> Editeur</th>
                    <th class="text-center" scope="col"> Année d'édition</th>
                    <th class="text-center" scope="col"> Section</th>
                    <th class="text-center" scope="col"> ISBN</th>
                    <th class="text-center" scope="col"> Nombre d'exemplaire</th>
                    <th class="text-center" scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${allBookList.size()==searchBook.size()}">
                    <c:forEach items="${allBook}" var="bookAll">
                        <tr>
                            <td class="text-center" scope="row">${bookAll.titre}</td>
                            <td class="text-center" scope="row">${bookAll.auteurPrincipalNom}</td>
                            <td class="text-center" scope="row">${bookAll.auteurPrincipalPrenom}</td>
                            <td class="text-center" scope="row">${bookAll.editeur}</td>
                            <td class="text-center" scope="row">${bookAll.anneeEdition}</td>
                            <td class="text-center" scope="row">${bookAll.section}</td>
                            <td class="text-center" scope="row">${bookAll.isbn}</td>
                            <td class="text-center" scope="row">${bookAll.nbreExemplaire}</td>
                            <td class="text-center" scope="row">
                                <div class="single-product">
                                    <sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
                                    <a class="btn btn-outline-info" href="<c:url value="/bookDetail/${bookAll.id}"/>">Détails</a>
                                        <form action="/save/reservation" method="post">
                                            <input type="hidden" name="bookId" id="bookId" value="${bookAll.id}"/>
                                            <button class="btn btn-outline-success">Emprunter</button>
                                        </form>
                                    </sec:authorize>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${allBookList.size() !=searchBook.size()}">
                    <c:forEach items="${searchBookPage.getContent()}" var="bookAll">
                        <tr>
                            <td class="text-center" scope="row">${bookAll.titre}</td>
                            <td class="text-center" scope="row">${bookAll.auteurPrincipalNom}</td>
                            <td class="text-center" scope="row">${bookAll.auteurPrincipalPrenom}</td>
                            <td class="text-center" scope="row">${bookAll.editeur}</td>
                            <td class="text-center" scope="row">${bookAll.anneeEdition}</td>
                            <td class="text-center" scope="row">${bookAll.section}</td>
                            <td class="text-center" scope="row">${bookAll.isbn}</td>
                            <td class="text-center" scope="row">${bookAll.nbreExemplaire}</td>
                            <td class="text-center" scope="row">
                                <div class="single-product">
                                    <sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
                                        <a class="btn btn-outline-info" href="<c:url value="/bookDetail"/>">Détails</a>
                                        <form action="/save/reservation" method="post">
                                            <input type="hidden" name="bookId" id="bookId" value="${bookAll.id}"/>
                                            <button class="btn btn-outline-success">Emprunter</button>
                                        </form>
                                    </sec:authorize>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${paginationBook.getNumber() == 0}">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>
            </c:if>
            <c:if test="${paginationBook.getNumber() != 0}">
                <li class="page-item">
                    <a class="page-link" href="/?page=${paginationBook.getNumber()-1}">Previous</a>
                </li>
            </c:if>
            <li class="page-item">
                <a class="page-link" >${paginationBook.getNumber()}</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="/?page=${paginationBook.getNumber()+1}">Next</a>
            </li>
        </ul>
    </nav>
</div>
<!-- End mainmenu area -->



<div class="promo-area">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-8">
                <div class="single-promo promo1">
                    <i class="fa fa-refresh"></i>
                    <p>30 jours d'emprunt</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-8">
                <div class="single-promo promo3">
                    <i class="fa fa-lock"></i>
                    <p>un espace personnel</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-8">
                <div class="single-promo promo4">
                    <i class="fa fa-gift"></i>
                    <p>nouveaux livres</p>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End promo area -->

<div class="maincontent-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="latest-product">
                    <h2 class="section-title">Les derniers livres arrivés</h2>
                    <div class="product-carousel">
                        <div class="single-product">
                            <div class="product-f-image">
                                <img src="../../img/product-1.jpg" alt="">
                            </div>

                            <h2><a >Balzac</a></h2>

                            <div class="product-carousel-price">
                                <ins>Les Chouans</ins>
                            </div>
                        </div>
                        <div class="single-product">
                            <div class="product-f-image">
                                <img src="../../img/product-2.jpg" alt="">
                            </div>

                            <h2>Balzac</h2>
                            <div class="product-carousel-price">
                                <ins>Le Colonnel Chabert</ins>
                            </div>
                        </div>
                        <div class="single-product">
                            <div class="product-f-image">
                                <img src="../../img/product-3.jpg" alt="">
                            </div>

                            <h2>Marcel Pagnol</h2>

                            <div class="product-carousel-price">
                                <ins>La Gloire De Mon Père</ins>
                            </div>
                        </div>
                        <div class="single-product">
                            <div class="product-f-image">
                                <img src="../../img/product-4.jpg" alt="">
                            </div>

                            <h2><a >Les frères Grimm</a></h2>

                            <div class="product-carousel-price">
                                <ins>Hänsel et Gretel</ins>
                            </div>
                        </div>
                        <div class="single-product">
                            <div class="product-f-image">
                                <img src="../../img/product-6.jpg" alt="">
                            </div>

                            <h2><a >Guillaume Apollinaire</a></h2>

                            <div class="product-carousel-price">
                                <ins>Si je mourais là-bas</ins>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End main content area -->

<div class="footer-top-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-9">
                <div class="footer-about-us">
                    <h2>u<span>Stora</span></h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis sunt id doloribus vero quam laborum quas alias dolores blanditiis iusto consequatur, modi aliquid eveniet eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit, debitis, quisquam. Laborum commodi veritatis magni at?</p>
                    <div class="footer-social">
                        <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
                        <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
                        <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
                        <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Accès Rapide</h2>
                    <ul>
                        <li><a href="/espacePerso">Mon compte</a></li>
                        <li><a href="/espacePerso#">Mes emprunts</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer top area -->

<div class="footer-bottom-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="copyright">
                    <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p>
                </div>
            </div>

            <div class="col-md-4">
                <div class="footer-card-icon">
                    <i class="fa fa-cc-discover"></i>
                    <i class="fa fa-cc-mastercard"></i>
                    <i class="fa fa-cc-paypal"></i>
                    <i class="fa fa-cc-visa"></i>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer bottom area -->

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
