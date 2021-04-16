<%--
  Created by IntelliJ IDEA.
  User: Ashe
  Date: 06/04/2021
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.eni.projetEnchere.bo.Utilisateur" %>
<%@ page import="org.eni.projetEnchere.bo.ArticleVendu" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%
    Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
    List<ArticleVendu> articles = (List<ArticleVendu>) request.getAttribute("article");
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Eni-Enchères - Accueil</title>
    <!-- Bootstrap core CSS -->
    <link href="ressource/css/accueil.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/navbar.jsp"/>
<img id="greenCut" src="ressource/img/greenCut.png"/>
<img id="treeCut" src="ressource/img/tree.png"/>
<div class="container">
    <div class="row">
        <div class="col-sm-12 mt-5">
            <h2 class="text-center">Liste des enchères</h2>
        </div>
        <div class="d-flex col-sm-12 mt-5 align-items-center justify-content-center">
            <div class="col-sm-12">
                <div class="card border-primary" style="max-width: 100rem;">
                    <div class="card-header">Filtres</div>
                    <div class="card-body">
                        <form class="form-inline col-sm-12 my-2 my-lg-0">
                            <div class="form-group col-sm-6">
                                <label for="filtreMots">Par mot : </label> <input
                                    class="form-control ml-2" type="text"
                                    placeholder="Mots à filtrer..." name="filtreMots"
                                    id="filtreMots">
                                <button class="btn btn-primary" type="submit">
                                    <img src="ressource/Icon/svg/funnel-hand-drawn-symbol.svg"
                                         height="24px" width="24px">
                                </button>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="exampleSelect1">Par catégorie : </label> <select
                                    class="form-control ml-2" id="exampleSelect1">
                                <option>Toutes</option>
                                <option>Informatique</option>
                                <option>Ameublement</option>
                                <option>Vêtement</option>
                                <option>Sport & Loisirs</option>
                            </select>
                            </div>
                        </form>
                        <%
                            if (utilisateur != null) {
                        %>
                        <div id="searchElement" class="d-flex col-sm-12 mt-3 align-items-center justify-content-center">
                            <div class="col-sm-6">
                                <fieldset class="form-group">
                                    <label class="form-check-label mb-2"> <input
                                            type="radio" class="form-check-input" name="optionsRadios"
                                            id="optionsRadios1" value="option1" checked=""
                                            onchange="swapCheckbox(this)"> Achats
                                    </label>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label"> <input
                                                class="form-check-input option1-checkbox" type="checkbox"
                                                value="" checked=""> Enchères ouvertes
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label"> <input
                                                class="form-check-input option1-checkbox" type="checkbox"
                                                value="" checked=""> Mes enchères en cours
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label"> <input
                                                class="form-check-input option1-checkbox" type="checkbox"
                                                value="" checked=""> Mes enchères remportées
                                        </label>
                                    </div>
                                </fieldset>
                            </div>
                            <div class="col-sm-6">
                                <fieldset class="form-group">
                                    <label class="form-check-label mb-2"> <input
                                            type="radio" class="form-check-input" name="optionsRadios"
                                            id="optionsRadios2" value="option2"
                                            onchange="swapCheckbox(this)"> Ventes
                                    </label>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label"> <input
                                                class="form-check-input option2-checkbox" type="checkbox"
                                                value="" checked=""> Ventes en cours
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label">
                                            <input class="form-check-input option2-checkbox" type="checkbox"
                                                   value="" checked=""> Ventes non débutées
                                        </label>
                                    </div>
                                    <div class="form-check ml-3">
                                        <label class="form-check-label"> <input
                                                class="form-check-input option2-checkbox" type="checkbox"
                                                value="" checked=""> Ventes terminées
                                        </label>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                        <%} else {%>
                        </br>
                        <% } %>
                        <div class="row col-sm-12 mt-2">
                            <div class="col-sm-4"></div>
                            <button id="buttonSearch" type="button" class="btn btn-primary btn-lg btn-block col-sm-4">
                                Rechercher
                            </button>
                            <div class="col-sm-4"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row my-5 mx-auto">
        <% for (ArticleVendu article : articles) { %>
        <!-- Article <%=article.getIdArticle() %> -->
        <div class="col-sm-8 col-md-6 col-lg-4">
            <div class="card shadow-sm border-light mb-4">
                <a href="ressource/article/<%=article.getIdArticle() %>.jpg"
                   class="lightbox imgArticle position-relative" aria-haspopup="dialog"
                   title="<%=article.getNom()%>">
                    <img src="ressource/article/<%=article.getIdArticle() %>.jpg" data-numArticle="<%= article.getIdArticle() %>" class="img-card-shop card-img-top"
                         alt="image" onerror="ReplaceImg(this)">
                    <%if (LocalDate.now().minusDays(1).isBefore(LocalDate.parse(article.getDateDebutEncheres())) && LocalDate.now().plusDays(2).isAfter(LocalDate.parse(article.getDateDebutEncheres()))) {%>
                    <i class="iconImg newIcon text-dark flaticon-new-tag-hand-drawn-outline"></i>
                    <%}%>
                </a>
                <hr>
                <div class="card-body py-0">
                    <a class="h6 text-primary" href="#"><%=article != null ? article.getNom() : ""%>
                    </a>
                    <div class="d-flex my-2">
                        <i class="star fas fa-star text-warning"></i>
                        <i class="star fas fa-star text-warning"></i>
                        <i class="star fas fa-star text-warning"></i>
                        <i class="star fas fa-star text-warning"></i>
                        <i class="star fas fa-star text-warning"></i>
                        <span class="badge badge-pill badge-secondary ml-2"><%=article != null ? article.getCategorie().getLibelle() : ""%></span>
                    </div>
                    <div class="post-meta">
								<span class="lh-120"><i class="flaticon-favorite-user-hand-drawn-interface-symbol"></i>
                                    Vendu par : <a href="<%=request.getContextPath()%>/profil?id=<%=article.getUtilisateur().getId()%>"><%=article.getUtilisateur().getPseudo()%></a>
                                </span>
                    </div>
                    <p class="small text-muted mt-2"><%= article.getDescription().length() > 150 ? article.getDescription().substring(0, 150) : article.getDescription() %><%=article.getDescription().length() > 150 ? "..." : ""%>
                    </p>
                    <div class="d-flex justify-content-between">
                        <div class="col pl-0">
                            <span class="text-muted font-small d-block mb-2">Montant</span>
                            <span class="small text-dark"><%=article != null ? article.getPrixVente() : ""%> <i class="flaticon-coins-stacks-of-dollars-hand-drawn-commercial-symbol"></i> </span>
                        </div>
                        <div class="col">
                            <span class="text-muted font-small d-block mb-2">Début</span>
                            <span class="small text-danger font-weight-bold"><%=article.getDateDebutEncheres() %></span>
                        </div>
                        <div class="col pr-0">
                            <span class="text-muted font-small d-block mb-2">Fin</span>
                            <span class="small text-success font-weight-bold"><%=article.getDateFinEncheres() %></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- fin article <%=article.getIdArticle() %> %> %> -->
        <% } %>
    </div>

</div>
<script src="ressource/JS/accueil.js?v=202104161306"></script>
<script type="text/javascript">
    $(function () {
        $('.lightbox').topbox();
    });
</script>
</body>
</html>