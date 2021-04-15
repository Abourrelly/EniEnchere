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
	    <a class="navbar-brand" href="accueil.jsp">Eni-Enchères</a>
	</nav>

	<div class="">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Mofidier mon profile</h2>
        </div>
        <form action="<%=request.getContextPath() %>/modifierCompte" class="d-flex justify-content-center flex-wrap w-75 m-auto" method="POST">
	        <div class="col-sm-6">
	            <div class="form-group">
	                <label for="pseudo">Pseudo</label>
	                <input type="text" class="form-control" id="pseudo" name="pseudo" value="${user.pseudo}">
	                <label for="prenom">Prénom</label>
	                <input type="text" class="form-control" id="prenom" name="prenom" value="${user.prenom}">
	                <label for="telephone">Téléphone</label>
	                <input type="text" class="form-control" id="telephone" name="telephone" value="${user.telephone}">
	                <label for="cp">Code postal</label>
	                <input type="text" class="form-control" id="cp" name="cp" value="${user.codePostal}">
	                <label for="password">Mot de passe actuelle</label>
	                <input type="password" class="form-control" id="password" name="password" value="${user.motDePasse}">
	                
	                <label for="new_password">Nouveau mot de passe</label>
	                <input type="password" class="form-control" id="newPassword" name="newPassword" value="">
	                
	                <label for="new_password">Credit : <strong>${user.credit}</strong></label>
	            </div>
	        </div>
	        <div class="col-sm-6">
	             <div class="form-group">
	                 <label for="nom">Nom</label>
	                 <input type="text" class="form-control" id="nom" name="nom" value="${user.nom}">
	                 <label for="exampleInputEmail1">Email</label>
	                 <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" value="${user.email}">
	                 <label for="rue">Rue</label>
	                 <input type="text" class="form-control" id="rue" name="rue" value="${user.rue}">
	                 <label for="ville">Ville</label>
	                 <input type="text" class="form-control" id="ville" name="ville" value="${user.ville}">
	                 
	                 <div style="width:546px; height:61px; margin-bottom:.5rem;"></div>

	                 <label for="confirmPass">Confirmation</label>
	                 <input type="password" class="form-control" id="confirmPass" aria-describedby="emailHelp" name="confirmPass" value="">
	             </div>
	        </div>
	        
	        <div class="d-block text-center">
	        
	        	<div class="notification"><p></p></div>
	        
	        	<input type="submit" class="btn btn-primary" value="EN?VOYER" />
	        	
	        	<a href="<%=request.getContextPath() %>/suppresion" class="btn btn-primary" />SUPPRIMER MON COMPTE</a>
	        	
	        </div>
	        
        </form>
    </div>

</body>

	<script src="<%=request.getContextPath() %>/ressource/JS/confirmpassword.js"></script>

</html>