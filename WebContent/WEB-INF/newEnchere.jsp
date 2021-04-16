<%@page import="org.eni.projetEnchere.bll.CategorieManager"%>
<%@page import="org.eni.projetEnchere.bo.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="org.eni.projetEnchere.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Antonin">
    <title>Eni-Enchères - Nouvelle Enchère</title>
    <link href="ressource/css/newEnchere.css" rel="stylesheet">
</head>
<body>
<%
	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
	List<Categorie> listCategories = new CategorieManager().getAll();
%>
<jsp:include page="/navbar.jsp"/>
<form method="post" action="<%= request.getContextPath() %>/creationEnchere">
<div class="container mb-2">
    <div class="row d-flex flex-wrap align-items-center">
        <div class="col-lg-12 col-md-12 col-sm-12 mt-5">
            <h2 class="text-center">Nouvelle Vente</h2>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 mt-5 ">
            <img id="imgEnchere" src="ressource/img/no-image.png" alt="your image"/>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 mt-5">
                <div class="form-group">
                	<!-- idUser -->
                	<input type="hidden" name="idUser" value="<%= user != null ? user.getId() : 0%>">
                    <!-- Article -->
                    <div class="form-group">
                        <label for="article">Article</label> 
                        <input type="text" class="form-control" name="nom" id="article" required="required">
                    </div>
                    <!-- Description -->
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea name="description" class="form-control" id="description" required="required"></textarea>
                    </div>
                    <!-- Catégorie -->
                    <div class="form-group">
                        <label for="categorie">Catégorie</label> 
                        <select name="categorie" id="categorie" class="custom-select col-12" required="required">
                        <% for(Categorie categorie : listCategories) { %>
                        <option value="<%=categorie.getId()%>"><%=categorie.getLibelle() %></option>
                        <% } %>
                    </select>
                    </div>
                    <!-- Photo -->
                    <div class="form-group">
                        <label for="imgInp">Image</label> 
                        <input type='file' class="form-control-file" id="imgInp" onchange="readURL(this)" accept=".png,.jpg,.jpeg" required="required"/>
                    </div>
                    <!-- Description -->
                    <div class="form-group col-5">
                        <label for="prix">Mise à Prix</label> 
                        <input type="number" min="0" name="prix" class="form-control" id="prix" required="required"/>
                    </div>
                    <!-- Début de l'enchère -->
                    <div class="form-group">
                        <label for="dateDebut">Début de l'enchère</label> 
                        <input class="form-control" type="date" name="dateDebutEnchere" id="dateDebutEnchere" required="required"/>
                    </div>
                    <!-- Fin de l'enchère -->
                    <div class="form-group">
                        <label for="dateFin">Fin de l'enchère</label> 
                        <input class="form-control" type="date" name="dateFinEnchere" id="dateFinEnchere" required="required"/>
                    </div>

                    <div class="retrait">
                        <h1 class="retraitTitle">Retrait</h1>
						<div class="form-group  mx-2">
	                        <label for="rue">Rue</label> 
	                        <input class="form-control" type="text" name="rue" id="rue" <%= user != null ? ("value="+"'"+user.getRue()+"'") : ""%> required="required"/>
                    	</div>
                    	<div class="form-group  mx-2">
	                        <label for="codePostale">Code Postale</label> 
	                        <input class="form-control" type="text" name="codePostale" id="codePostale" <%= user != null ? ("value="+"'"+user.getCodePostal()+"'") : ""%> required="required"/>
                    	</div>
                    	<div class="form-group  mx-2">
	                        <label for="ville">Ville</label> 
	                        <input class="form-control" type="text" name="ville" id="ville" <%= user != null ? ("value="+"'"+user.getVille()+"'") : ""%> required="required"/>
                    	</div>
                    </div>
                </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 mt-3 text-right">
            <button type="submit" class="submit btn btn-info" <%= user != null ? "" : "disabled" %>>Créer</button>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 mt-3 text-left">
            <a href="<%=request.getContextPath()%>/connexion"
               class="btn btn-info">Annuler</a>
        </div>
    </div>
</div>
</form>

<script src="ressource/JS/newEnchere.js?v=2002104091106"></script>
</body>
</html>