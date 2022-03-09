package boutique.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private boolean confirme; 
	private int id;
	private Utilisateur user ;
    private List<Article> articles = new ArrayList<>();
	private Double prixTotal(){return this.articles.stream().mapToDouble(a -> a.getPrix()).reduce(0, Double::sum);}
	
	public Panier(boolean confirme) {
		this.confirme = confirme;
	}
	
	public Panier(int id,Utilisateur user) {
		this.id = id;
		this.confirme = false;
		this.setUser(user);
	}
	
	public Panier() {
		
	}
	
	public Panier(boolean confirme, Utilisateur user) {
		this.confirme = confirme;
		this.setUser(user);
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	};
	
	public void addArticle(Article article)  {
		this.articles.add(article);
	}
	
	public void removeArticle(int n)  {
		this.articles.remove(n);
	}
	


	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int isConfirme() {
		if(confirme)
			return 1;
		else 
			return 0;
	}
	
	public void setConfirme(int id) {
		if(id == 1)
			confirme = true;
		else 
			confirme = false;
	}

	public void setConfirme(boolean confirme) {
		this.confirme = confirme;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}


}
