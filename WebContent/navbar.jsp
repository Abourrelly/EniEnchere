<%@ page import="org.eni.projetEnchere.bo.Utilisateur" %>
<%Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");%>

<jsp:include page="/import.jsp" />

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    
    <a class="navbar-brand py-0" href="<%=request.getContextPath()%>/accueil">
    	<img src="ressource/img/logo.png" width= "120px;"/>Eni-Enchères
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	 </button>
    <% if (utilisateur != null) { %>
    <!-- ConnectÃ© -->
    <div class="collapse navbar-collapse" id="nav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Enchères</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<%=request.getContextPath() %>/creationEnchere">Vendre un article</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<%=request.getContextPath() %>/profil?id=<%=utilisateur.getId()%>">Mon profil</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link pt-1" href="<%=request.getContextPath() %>/deconnexion">
                <img src="ressource/Icon/svg/power-symbol-variant-hand-drawn-outline.svg" height="24px" width="24px"></a>
            </li>
        </ul>
    </div>
    <% } else { %>
    <!-- Pas connectÃ© -->
    <div class="collapse navbar-collapse" id="connexion">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<%=request.getContextPath() %>/connexion">S'inscrire - Se connecter</a>
            </li>
        </ul>
    </div>
    <% } %>
</nav>
