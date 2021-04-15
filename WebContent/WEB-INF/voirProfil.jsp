<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.eni.projetEnchere.bo.Utilisateur" %>
<% 
	Utilisateur profil = (Utilisateur)request.getAttribute("profil");
	Utilisateur user = (Utilisateur)session.getAttribute("utilisateur");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Eni-Enchères - Voir profil</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="ressource/Icon/font/flaticon.css">
</head>
<body>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="<%= request.getContextPath()%>/accueil">Eni-Enchères</a>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Profil de ${profil.pseudo}</h2>
        </div>
        <div class="col-sm-12 card border-primary mb-3 mt-5" style="max-width: 30rem;">
            <div class="card-header text-center">Détail du profil</div>
            <div class="card-body mx-auto">
                <h4 class="card-title text-center">${profil.pseudo}</h4>
                <div class="col-sm-12 mt-5">
                    <div class="form-group row">
                        <label for="nom" class="col-sm-4 col-form-label">Nom : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="nom" name="nom" value="${profil.nom}">
                        </div>
                        <label for="prenom" class="col-sm-4 col-form-label">Prénom : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="prenom" name="prenom" value="${profil.prenom}">
                        </div>
                        <label for="staticEmail" class="col-sm-4 col-form-label">Email : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" name="email" value="${profil.email}">
                        </div>
                        <label for="telephone" class="col-sm-4 col-form-label">Téléphone : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="telephone" name="telephone" value="${profil.telephone}">
                        </div>
                        <label for="rue" class="col-sm-4 col-form-label">Rue : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="rue" name="rue" value="${profil.rue}">
                        </div>
                        <label for="cp" class="col-sm-4 col-form-label">Code postal : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="cp" name="cp" value="${profil.codePostal}">
                        </div>
                        <label for="ville" class="col-sm-4 col-form-label">Ville : </label>
                        <div class="col-sm-8">
                            <input type="text" readonly="" class="form-control-plaintext" id="ville" name="ville" value="${profil.ville}">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% if((user != null) && (user.getId() == profil.getId())) { %>
        <div class="col-sm-12 mt-3 text-center">
            <a class="submit btn btn-primary" href="<%= request.getContextPath()%>/modifierCompte">Modifier</a>
        </div>
        <% } %>
    </div>
</div>

</body>
</html>