<%--
  Created by IntelliJ IDEA.
  User: Ashe
  Date: 07/04/2021
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Eni-Enchères - Connexion</title>
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
<div class="row ml-5 mt-5">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <form>
            <div class="form-group">
                <label for="exampleInputEmail1">Identifiant :</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Renseignez votre identifiant...">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Mot de passe :</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Renseignez votre mot de passe...">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-info mt-2">Connexion</button>
                <input class="form-check mt-2 ml-3" type="checkbox" value="" checked="">
                Se souvenir de moi
            </div>

        </form>
    </div>
    <div class="col-lg-4"></div>
</div>
</body>
</html>
