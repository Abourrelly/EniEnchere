package org.eni.projetEnchere.bo;

import java.time.LocalDate;

public class Enchere {

	private Utilisateur idUser;
    private ArticleVendu idArticle;
    private LocalDate dateEnchere;
    private int montantEnchere;

    public Enchere() {
    }

    public Enchere(LocalDate dateEnchere, int montantEnchere) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }
    
    public Enchere(Utilisateur idUser, int montantEnchere) {
    	this.idUser = idUser;
        this.montantEnchere = montantEnchere;
    }

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    public ArticleVendu getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(ArticleVendu idArticle) {
        this.idArticle = idArticle;
    }

    public LocalDate getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDate dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }

    @Override
    public String toString() {
        return "Enchere{" +
                "no_utilisateur=" + idUser +
                ", no_article=" + idArticle +
                ", date_enchere=" + dateEnchere +
                ", montant_enchere=" + montantEnchere +
                '}';
    }
}
