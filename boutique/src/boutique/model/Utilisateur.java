package boutique.model;

public class Utilisateur {
	private int id ;
	private String nom ; 
	private String prenom ; 
	private String email ; 
	private String password; 
	private String date_naissance ; 
	private Panier panier ;
	public Role role ; 
	
	public Utilisateur(int id, String nom, String prenom, String email, String password, String date_naissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.date_naissance = date_naissance;
		this.panier = new Panier(1); 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	} 
	public void setAdmin() {
		this.role = Role.ADMIN ; 
	}
	public void setUser() {
		this.role = Role.USER ; 
	}
}
