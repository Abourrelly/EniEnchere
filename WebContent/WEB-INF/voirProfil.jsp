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
    <link rel="stylesheet" type="text/css" href="ressource/css/voirProfil.css">
</head>
<body>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<jsp:include page="/navbar.jsp" />

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Profil de ${profil.pseudo}</h2>
        </div>
        <div class="col-xl-6 col-md-12">
                <div class="card user-card-full">
                    <div class="row m-l-0 m-r-0">
                        <div class="col-sm-4 bg-c-lite-green user-profile">
                            <div class="card-block text-center text-white">
                                <div class="m-b-25"> <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image"> </div>
                                <h6 class="f-w-600"><%= user.getPrenom() +" "+user.getNom() %></h6>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="card-block">
                                <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Information</h6>
                                <div class="row">
                                	<div class="col-sm-12">
                                        <p class="m-b-10 f-w-600">Pseudo</p>
                                        <h6 class="text-muted f-w-400"><%=user.getPseudo() %></h6>
                                    </div>
                                    <div class="col-sm-12">
                                        <p class="m-b-10 f-w-600">Email</p>
                                        <h6 class="small text-muted f-w-400"><%= user.getEmail() %></h6>
                                    </div>
                                    <div class="col-sm-12">
                                        <p class="m-b-10 f-w-600">Phone</p>
                                        <h6 class="text-muted f-w-400"><%=user.getTelephone() %></h6>
                                    </div>
                                </div>
                                <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Projects</h6>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Recent</p>
                                        <h6 class="text-muted f-w-400">Sam Disuja</h6>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Most Viewed</p>
                                        <h6 class="text-muted f-w-400">Dinoter husainm</h6>
                                    </div>
                                </div>
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