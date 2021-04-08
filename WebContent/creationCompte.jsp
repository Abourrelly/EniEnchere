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
</head>
<body>
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <nav class="navbar navbar-expand-lg navbar-dark bg-info">
        <a class="navbar-brand" href="accueil.jsp">Eni-Enchères</a>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 mt-5">
                <h2 class="text-center">Mon profil</h2>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 mt-5">
                <form>
                    <div class="form-group">
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo">
                        <label for="prenom">Prénom</label>
                        <input type="text" class="form-control" id="prenom">
                        <label for="telephone">Téléphone</label>
                        <input type="text" class="form-control" id="telephone">
                        <label for="cp">Code postal</label>
                        <input type="text" class="form-control" id="cp">
                        <label for="exampleInputPassword1">Mot de passe</label>
                        <input type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                </form>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 mt-5">
                <form>
                    <div class="form-group">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        <label for="rue">Rue</label>
                        <input type="text" class="form-control" id="rue">
                        <label for="ville">Ville</label>
                        <input type="text" class="form-control" id="ville">
                        <label for="confirmEmail">Confirmation</label>
                        <input type="email" class="form-control" id="confirmEmail" aria-describedby="emailHelp">
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 mt-3 text-right">
                <button class="submit btn btn-info">Créer</button>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 mt-3 text-left">
                <a href="<%=request.getContextPath() %>/connexion" class="btn btn-info">Annuler</a>
            </div>
        </div>
    </div>

</body>
</html>
