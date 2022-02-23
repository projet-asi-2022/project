package boutique.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private boolean confirme; 
	private int id;
    private List<Article> articles = new ArrayList<>();
	private Double prixTotal(){return this.articles.stream().mapToDouble(a -> a.getPrix()).reduce(0, Double::sum);}
	
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

	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public boolean isConfirme() {
		return confirme;
	}

	public void setConfirme(boolean confirme) {
		this.confirme = confirme;
	}


}
