<%--
  Created by IntelliJ IDEA.
  User: Ashe
  Date: 06/04/2021
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.eni.projetEnchere.bo.Utilisateur" %>
<%@ page import="org.eni.projetEnchere.bo.ArticleVendu" %>
<% 
	ArticleVendu article = (ArticleVendu)request.getAttribute("article");
%>
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


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Eni-Enchères</a>
    <% Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur"); %>
    <% if(utilisateur != null) { %>
        <!-- Connecté -->
        <div class="collapse navbar-collapse" id="nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<%= request.getContextPath() %>/creationEnchere">Enchères</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Vendre un article</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="<%=request.getContextPath() %>/profil?id=<%=utilisateur.getId()%>">Mon profil</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link pt-1" href="<%=request.getContextPath() %>/deconnexion"><img src="ressource/Icon/svg/power-symbol-variant-hand-drawn-outline.svg" height="24px" width="24px"></a>
                </li>
            </ul>
        </div>
    <% } else { %>
        <!-- Pas connecté -->
        <div class="collapse navbar-collapse" id="connexion">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<%=request.getContextPath() %>/connexion">S'inscrire - Se connecter</a>
                </li>
            </ul>
        </div>
    <% } %>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Liste des enchères</h2>
        </div>
        <div class="d-flex col-sm-12 mt-5 align-items-center justify-content-center">
            <div class="col-sm-12">
                <div class="card border-primary" style="max-width: 100rem;">
                    <div class="card-header">Filtres</div>
                    <div class="card-body">
                        <form class="form-inline col-sm-12 my-2 my-lg-0">
                            <div class="form-group col-sm-6">
                                <label for="filtreMots">Par mot : </label>
                                <input class="form-control ml-2" type="text" placeholder="Mots à filtrer..." name="filtreMots" id="filtreMots">
                                <button class="btn btn-primary" type="submit"><img src="ressource/Icon/svg/funnel-hand-drawn-symbol.svg" height="24px" width="24px"></button>
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
                        <% if(utilisateur != null) { %>
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
                                            Ventes en cours
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">
                                            Ventes non débutées
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option2-checkbox" type="checkbox" value="" checked="">
                                            Ventes terminées
                                        </label>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <% } else { %>
                    </br>
                        <% } %>
                        <div class="row col-sm-12 mt-2">
                            <div class="col-sm-4"></div>
                            <button type="button" class="btn btn-primary btn-lg btn-block col-sm-4">Rechercher</button>
                            <div class="col-sm-4"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex col-sm-12 mt-5 align-items-center justify-content-center">
            <div class="card mb-3">
                <h3 class="card-header text-center text-primary"><%= article != null ? article.getNom() : "" %></h3>
                <div class="card-body">
                    <h5 class="card-title text-center text-secondary"><%= article != null ?  article.getCategorie().getLibelle() : "" %></h5>
                </div>
                <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">
                    <rect width="100%" height="100%" fill="#868e96"></rect>
                    <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
                </svg>
                <div class="card-body">
                    <p class="card-text">Description : <%= article != null ?  article.getDescription() : ""  %></p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Prix : <%= article != null ?  article.getPrixVente() : "" %> points</li>
                    <li class="list-group-item">Vendu par : <a href="<%= request.getContextPath() %>/profil?id=<%= article.getUtilisateur().getId() %>" class="card-link"> <%= article != null ? article.getUtilisateur().getPseudo() : "" %></a></li>
                </ul>
                <div class="card-body text-center text-secondary">
                	Enchère débutée le <%= article != null ? article.getDateDebutEncheres() : "" %>                    
                </div>
                <div class="card-footer text-muted text-center">
                    <a href="#" class="card-link">Ajouter des points</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>