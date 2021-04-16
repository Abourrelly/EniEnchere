<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page import="org.eni.projetEnchere.bo.Utilisateur" %> --%>
<% 
/* 	Utilisateur user = (Utilisateur)request.getAttribute("user"); */

%>
<!DOCTYPE html>
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

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	    <a class="navbar-brand" href="<%=request.getContextPath() %>/accueil">Eni-Enchères</a>
	</nav>

	<div class="">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Créer un compte</h2>
        </div>
        <form action="<%=request.getContextPath() %>/creation" class="d-flex justify-content-center flex-wrap w-75 m-auto" method="POST">
	        <div class="col-sm-6">
	            <div class="form-group">
	                <label for="pseudo">Pseudo</label>
	                <input type="text" class="form-control" id="pseudo" name="pseudo">
	                <label for="prenom">Prénom</label>
	                <input type="text" class="form-control" id="prenom" name="prenom">
	                <label for="telephone">Téléphone</label>
	                <input type="text" class="form-control" id="telephone" name="telephone">
	                <label for="cp">Code postal</label>
	                <input type="text" class="form-control" id="cp" name="cp">	                
	                <label for="new_password">Nouveau mot de passe</label>
	                <input type="password" class="form-control" id="newPassword" name="newPassword">
	            </div>
	        </div>
	        <div class="col-sm-6">
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
	        </div>
	        
	        <div class="d-block text-center">
	        
	        	<div class="notification"><p></p></div>
	        
	        	<input type="submit" class="btn btn-primary" value="Créer" />
	        	
	        	<a href="<%=request.getContextPath() %>/connexion" class="btn btn-primary" >Annuler</a>
	        	
	        </div>
	        
        </form>
    </div>

</body>

	<script src="<%=request.getContextPath() %>/ressource/JS/confirmpassword.js"></script>

</html>