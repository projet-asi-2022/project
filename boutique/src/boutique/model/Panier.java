package boutique.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private Integer id;
	private boolean confirme; 
    private List<Article> articles = new ArrayList<>();
	private float prixTotal(){return 1;}
	
	public Panier(int id) {
		this.id = id;
		this.confirme = false;
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
	
	public Integer getId() {
		return this.id ; 
	}

}
