package boutique.model;

public class Article {
	private Integer id;
	private String libelle;
    private String marque;
    private double prix;
    private Categorie categorie;
	private Photo photo;
    
	public Article(String libelle, String marque, double prix, Categorie categorie, Photo photo) {
		this.libelle = libelle;
		this.marque = marque;
		this.prix = prix;
		this.categorie = categorie;
		this.photo = new Photo();
	}
	
    public Article(int id,String libelle, String marque, double prix, Categorie categorie, Photo photo) {
    	this.id=id;
		this.libelle = libelle;
		this.marque = marque;
		this.prix = prix;
		this.categorie = categorie;
		this.photo = photo;
	}
    
    public Article() { 
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
	
	public double getPrix() {
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
	
	public void setId(int id) {
		this.id = id;
	}
}
