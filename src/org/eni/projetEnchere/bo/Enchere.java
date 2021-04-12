package org.eni.projetEnchere.bo;

import java.time.LocalDate;

public class Enchere {

	private int id;
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
    
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
        		"id=" + id +
                ", no_utilisateur=" + idUser +
                ", no_article=" + idArticle +
                ", date_enchere=" + dateEnchere +
                ", montant_enchere=" + montantEnchere +
                '}';
    }
}
