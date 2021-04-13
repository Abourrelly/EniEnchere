package org.eni.projetEnchere.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleVendu {

    private int idArticle;
    private String nom;
    private String description;
    private String dateDebutEncheres;
    private String dateFinEncheres;
    private int prixInitial;
    private int prixVente;
    private Utilisateur idUser;
    private Categorie idCategorie;
    
//    private List<Enchere> encheres;

    public ArticleVendu() {
    }

    public ArticleVendu(String nom, String description, String dateDebutEncheres, String dateFinEncheres, int prixInitial, int prixVente) {
        this.nom = nom;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
    }
    
    public ArticleVendu(int idArticle, String nom, String description, String dateDebutEncheres, String dateFinEncheres, int prixInitial, int prixVente) {
        this.idArticle = idArticle;
    	this.nom = nom;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
    }
    
//    public ArticleVendu(String nom_article, String description, String date_debut_encheres, String date_fin_encheres, int prix_initial, int prix_vente, List<Enchere> encheres) {
//    	this(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente);
//    	this.encheres = encheres;
//    }

	public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDebutEncheres() {
        return dateDebutEncheres;
    }

    public void setDateDebutEncheres(String dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }

    public String getDateFinEncheres() {
        return dateFinEncheres;
    }

    public void setDateFinEncheres(String dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }

    public int getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }
    
//	public List<Enchere> getEncheres() {
//		return encheres;
//	}
//
//	public void setEncheres(List<Enchere> encheres) {
//		this.encheres = encheres;
//	}
//	
//	public void addEnchere(Enchere enchere) {
//		if(encheres == null) {
//			encheres = new ArrayList<Enchere>();
//		}
//		encheres.add(enchere);
//	}

    @Override
    public String toString() {
        return "ArticleVendu{" +
                "idArticle=" + idArticle +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", dateDebutEncheres='" + dateDebutEncheres + '\'' +
                ", dateFinEncheres='" + dateFinEncheres + '\'' +
                ", prixInitial=" + prixInitial +
                ", prixVente=" + prixVente +
                ", idUser=" + idUser +
                ", idCategorie=" + idCategorie +
//                ", encheres=" + encheres +
                '}';
    }

}
