package boutique.model;

public class Categorie {
	private String nom;
	private int id;

	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	} 
}
