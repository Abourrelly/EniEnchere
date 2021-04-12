<%--
  Created by IntelliJ IDEA.
  User: Ashe
  Date: 06/04/2021
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Eni-Enchères - Accueil</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="ressource/css/accueil.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="ressource/Icon/font/flaticon.css">
</head>
<body>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="ressource/JS/accueil.js?v=202104091628"></script>


<nav class="navbar navbar-expand-lg navbar-dark bg-info">
    <a class="navbar-brand" href="#">Eni-Enchères</a>

    <div class="collapse navbar-collapse" id="navbarColor01">
<%--        <ul class="navbar-nav ml-auto">--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="<%=request.getContextPath() %>/connexion">S'inscrire - Se connecter</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Enchères</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Vendre un article</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<%=request.getContextPath() %>/voirProfil">Mon profil</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link pt-1" href="<%=request.getContextPath() %>/deconnexion"><i class="text-dark flaticon-power-symbol-variant-hand-drawn-outline"></i></a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Liste des enchères</h2>
        </div>
        <div class="d-flex col-sm-12 mt-5 align-items-center justify-content-center">
            <div class="col-sm-12">
                <div class="card border-info" style="max-width: 100rem;">
                    <div class="card-header">Filtres</div>
                    <div class="card-body">
                        <form class="form-inline col-sm-12 my-2 my-lg-0">
                            <div class="form-group col-sm-6">
                                <label for="filtreMots">Par mot : </label>
                                <input class="form-control ml-2" type="text" placeholder="Mots à filtrer..." name="filtreMots" id="filtreMots">
                                <button class="btn btn-info" type="submit"><i class="text-dark flaticon-funnel-hand-drawn-symbol"></i></button>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="exampleSelect1">Par catégorie : </label>
                                <select class="form-control ml-2" id="exampleSelect1">
                                    <option>Toutes</option>
                                    <option>Informatique</option>
                                    <option>Ameublement</option>
                                    <option>Vêtement</option>
                                    <option>Sport & Loisirs</option>
                                </select>
                            </div>
                        </form>
                        <div id ="searchElement" class="d-flex col-sm-12 mt-3 align-items-center justify-content-center">
                            <div class="col-sm-6">
                                <fieldset class="form-group">
                                    <label class="form-check-label mb-2">
                                        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked="" onchange="swapCheckbox(this)">
                                        Achats
                                    </label>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option1-checkbox" type="checkbox" value="" checked="">
                                            Enchères ouvertes
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option1-checkbox" type="checkbox" value="" checked="">
                                            Mes enchères en cours
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option1-checkbox" type="checkbox" value="" checked="">
                                            Mes enchères remportées
                                        </label>
                                    </div>
                                </fieldset>
                            </div>
                            <div class="col-sm-6">
                                <fieldset class="form-group">
                                    <label class="form-check-label mb-2">
                                        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2" onchange="swapCheckbox(this)">
                                        Ventes
                                    </label>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">
                                            Enchères ouvertes
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">
                                            Mes enchères en cours
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">
                                            Mes enchères remportées
                                        </label>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <div class="row col-sm-12 mt-2">
                            <div class="col-sm-4"></div>
                            <button type="button" class="btn btn-info btn-lg btn-block col-sm-4">Rechercher</button>
                            <div class="col-sm-4"></div>
                        </div>
                    </div>
                </div>
            </div>
<%--            <div class="col-sm-4">--%>
<%--                <button type="button" class="btn btn-info btn-lg btn-block">Rechercher</button>--%>
<%--            </div>--%>
        </div>
<%--        <div  id ="searchElement" class="d-flex col-sm-12 mt-5 align-items-center justify-content-center">--%>
<%--            <div class="col-sm-6">--%>
<%--                <fieldset class="form-group">--%>
<%--                    <label class="form-check-label mb-2">--%>
<%--                        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked="" onchange="swapCheckbox(this)">--%>
<%--                        Achats--%>
<%--                    </label>--%>
<%--                    <div class="form-check ml-3">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input option1-checkbox" type="checkbox" value="" checked="">--%>
<%--                            Enchères ouvertes--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check ml-3">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input option1-checkbox" type="checkbox" value="" checked="">--%>
<%--                            Mes enchères en cours--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check ml-3">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input option1-checkbox" type="checkbox" value="" checked="">--%>
<%--                            Mes enchères remportées--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                </fieldset>--%>
<%--            </div>--%>
<%--            <div class="col-sm-6">--%>
<%--                <fieldset class="form-group">--%>
<%--                    <label class="form-check-label mb-2">--%>
<%--                        <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2" onchange="swapCheckbox(this)">--%>
<%--                        Ventes--%>
<%--                    </label>--%>
<%--                    <div class="form-check ml-3">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">--%>
<%--                            Enchères ouvertes--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check ml-3">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">--%>
<%--                            Mes enchères en cours--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                    <div class="form-check ml-3">--%>
<%--                        <label class="form-check-label">--%>
<%--                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">--%>
<%--                            Mes enchères remportées--%>
<%--                        </label>--%>
<%--                    </div>--%>
<%--                </fieldset>--%>
<%--            </div>--%>
        </div>
        <div class="d-flex col-sm-12 mt-5 align-items-center justify-content-center">
            Enchères affichées
        </div>
    </div>
</div>


</body>
</html>