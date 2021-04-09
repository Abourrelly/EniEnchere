package org.eni.projetEnchere.bo;

import java.util.Date;

public class ArticleVendu {

    private int no_article;
    private String nom_article;
    private String description;
    private String date_debut_encheres;
    private String date_fin_encheres;
    private int prix_initial;
    private int prix_vente;
    private Utilisateur no_utilisateur;
    private Categorie no_categorie;

    public ArticleVendu() {
    }

    public ArticleVendu(String nom_article, String description, String date_debut_encheres, String date_fin_encheres, int prix_initial, int prix_vente) {
        this.nom_article = nom_article;
        this.description = description;
        this.date_debut_encheres = date_debut_encheres;
        this.date_fin_encheres = date_fin_encheres;
        this.prix_initial = prix_initial;
        this.prix_vente = prix_vente;
    }

	public int getNo_article() {
        return no_article;
    }

    public void setNo_article(int no_article) {
        this.no_article = no_article;
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_debut_encheres() {
        return date_debut_encheres;
    }

    public void setDate_debut_encheres(String date_debut_encheres) {
        this.date_debut_encheres = date_debut_encheres;
    }

    public String getDate_fin_encheres() {
        return date_fin_encheres;
    }

    public void setDate_fin_encheres(String date_fin_encheres) {
        this.date_fin_encheres = date_fin_encheres;
    }

    public int getPrix_initial() {
        return prix_initial;
    }

    public void setPrix_initial(int prix_initial) {
        this.prix_initial = prix_initial;
    }

    public int getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(int prix_vente) {
        this.prix_vente = prix_vente;
    }

    public Utilisateur getNo_utilisateur() {
        return no_utilisateur;
    }

    public void setNo_utilisateur(Utilisateur no_utilisateur) {
        this.no_utilisateur = no_utilisateur;
    }

    public Categorie getNo_categorie() {
        return no_categorie;
    }

    public void setNo_categorie(Categorie no_categorie) {
        this.no_categorie = no_categorie;
    }

    @Override
    public String toString() {
        return "ArticleVendu{" +
                "no_article=" + no_article +
                ", nom_article='" + nom_article + '\'' +
                ", description='" + description + '\'' +
                ", date_debut_encheres='" + date_debut_encheres + '\'' +
                ", date_fin_encheres='" + date_fin_encheres + '\'' +
                ", prix_initial=" + prix_initial +
                ", prix_vente=" + prix_vente +
                ", no_utilisateur=" + no_utilisateur +
                ", no_categorie=" + no_categorie +
                '}';
    }
}
