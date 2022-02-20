package boutique.model;

public class Categorie {
	private Integer id;
	private String nom;

	public Categorie(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public int getId() {
		return this.id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	} 
}
