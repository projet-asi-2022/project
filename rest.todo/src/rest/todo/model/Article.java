package rest.todo.model;

public class Article {
	private Integer id;
	private String libelle;
    private String marque;
    private float prix;
    private Categorie categorie;
    private Photo photo;
    
	public Article(String libelle, String marque, float prix, Categorie categorie) {
		this.libelle = libelle;
		this.marque = marque;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getMarque() {
		return this.marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public float getPrix() {
		return this.prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public Categorie getCategorie() {
		return this.categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Photo getPhoto() {
		return this.photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Integer getId() {
		return this.id;
	} 
    
    
}
