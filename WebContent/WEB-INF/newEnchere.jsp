<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Antonin">
    <title>Eni-Enchères - Nouvelle Enchère</title>

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="ressource/css/newEnchere.css" rel="stylesheet">
</head>
<body>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="ressource/JS/newEnchere.js?v=2002104091106"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-info">
    <a class="navbar-brand" href="accueil.jsp">Eni-Enchères</a>
</nav>

<div class="container">
    <div class="row d-flex flex-wrap align-items-center">
        <div class="col-lg-12 col-md-12 col-sm-12 mt-5">
            <h2 class="text-center">Nouvelle Vente</h2>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 mt-5 ">
            <form>
                <img id="imgEnchere" src="#" alt="your image"/>
            </form>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 mt-5">
            <form>
                <div class="form-group">
                    <div class="form-group">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom">
                    </div>
                    <div class="form-group">
                        <label for="imgInp">Image</label>
                        <input type='file' id="imgInp" onchange="readURL(this)"/>
                        <div class="invalid-feedback">
                            Veuillez mettre une image !
                        </div>
                    </div>
                    <label for="exampleInputEmail1">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
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