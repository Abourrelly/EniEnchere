<%--
  Created by IntelliJ IDEA.
  User: Ashe
  Date: 07/04/2021
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Eni-Enchères - Création de compte</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="ressource/Icon/font/flaticon.css">
</head>
<body>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="accueil.jsp">Eni-Enchères</a>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Mon profil</h2>
        </div>
        <div class="col-sm-6 mt-5">
            <form>
                <div class="form-group">
                    <label for="pseudo">Pseudo</label>
                    <input type="text" class="form-control" id="pseudo" name="pseudo">
                    <label for="prenom">Prénom</label>
                    <input type="text" class="form-control" id="prenom" name="prenom">
                    <label for="telephone">Téléphone</label>
                    <input type="text" class="form-control" id="telephone" name="telephone">
                    <label for="cp">Code postal</label>
                    <input type="text" class="form-control" id="cp" name="cp">
                    <label for="password">Mot de passe</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
            </form>
        </div>
        <div class="col-sm-6 mt-5">
            <form>
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom" name="nom">
                    <label for="exampleInputEmail1">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                    <label for="rue">Rue</label>
                    <input type="text" class="form-control" id="rue" name="rue">
                    <label for="ville">Ville</label>
                    <input type="text" class="form-control" id="ville" name="ville">
                    <label for="confirmPass">Confirmation</label>
                    <input type="password" class="form-control" id="confirmPass" aria-describedby="emailHelp" name="confirmPass">
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 mt-3 text-right">
            <button class="submit btn btn-primary">Créer</button>
        </div>
        <div class="col-sm-6 mt-3 text-left">
            <a href="<%=request.getContextPath() %>/connexion" class="btn btn-primary">Annuler</a>
        </div>
    </div>
</div>

</body>
</html>