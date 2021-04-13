package org.eni.projetEnchere.bo;

public class Retrait {
	
	private int id;
    private ArticleVendu idArticle;
    private String rue;
    private String codePostal;
    private String ville;

    public Retrait() {
    }

    public Retrait(String rue, String codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    
    public Retrait(int id, String rue, String codePostal, String ville) {
    	this.id = id;
    	this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public ArticleVendu getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(ArticleVendu idArticle) {
        this.idArticle = idArticle;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode_postal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "idArticle=" + idArticle +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
