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
</head>
<body>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-info">
    <a class="navbar-brand" href="#">Eni-Enchères</a>

    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<%=request.getContextPath() %>/connexion">S'inscrire - Se connecter</a>
            </li>
        </ul>
    </div>
</nav>

<h2 class="text-center mt-4">Liste des enchères</h2>

<div class="row ml-5 mt-5">
    <div class="col-lg-3"></div>
    <div class="col-lg-3">
        <div class="card border-info mb-3" style="max-width: 20rem;">
            <div class="card-header">Filtres :</div>
            <div class="card-body">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control" type="text" placeholder="Mots à filtrer...">
                    <button class="btn btn-info" type="submit"><img src="ressource/Icon/svg/funnel-hand-drawn-symbol.svg" height="24px" width="24px"></button>
                    <div>
                        <h6 class="mt-2">Catégorie :</h6>
                        <div class="form-group">
                            <select class="form-control" id="exampleSelect1">
                                <option>Informatique</option>
                                <option>Ameublement</option>
                                <option>Vêtement</option>
                                <option>Sport & Loisirs</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-lg-3 mt-5">
        <button type="button" class="btn btn-info btn-lg btn-block">Rechercher</button>
    </div>
    <div class="col-lg-3"></div>
</div>

</body>
</html>