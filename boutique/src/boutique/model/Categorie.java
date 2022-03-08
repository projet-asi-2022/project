package boutique.model;

public class Categorie {
	private String nom;
	private int id;
	
	public Categorie() {
	}
	
	public Categorie(String nom) {
		this.nom = nom;
	}
	
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
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
