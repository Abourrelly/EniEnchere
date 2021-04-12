package org.eni.projetEnchere.bo;

public class Categorie {

	private int id;
    private int idCategorie;
	private String libelle;

    public Categorie() {
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

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
        		"id=" + id +
        		", idCategorie=" + idCategorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
