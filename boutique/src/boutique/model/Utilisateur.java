package boutique.model;

public class Utilisateur {
	private int id ;
	private String nom ; 
	private String prenom ; 
	private String email ; 
	private String password; 
	private String dateNaissance ; 

	public Role role ; 
	
	public Utilisateur(String nom, String prenom, String email, String password, String dateNaissance,Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}
	
	public Utilisateur(int id,String nom, String prenom, String email, String password, String dateNaissance,Role role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}
	public Utilisateur() {
		
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
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setAdmin() {
		this.role = Role.Admin;
	}
	
	public void setUser() {
		this.role = Role.User; 
	}
}
