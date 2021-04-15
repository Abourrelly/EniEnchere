package org.eni.projetEnchere.bo;

public class Categorie {

	private int id;
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

    public Categorie(int id, String libelle) {
		setId(id);
		setLibelle(libelle);
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
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
