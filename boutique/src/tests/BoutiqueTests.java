package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import boutique.model.Article;
import boutique.model.Boutique;
import boutique.model.Categorie;
import boutique.model.Panier;
import boutique.model.Photo;
import boutique.model.Role;
import boutique.model.Utilisateur;
import db.BoutiqueDbContext;

class BoutiqueTests {

	private BoutiqueDbContext ctx = new BoutiqueDbContext();
	
	@Test
	public void testConnection() throws SQLException {
		ResultSet rs = ctx.getConn().getMetaData().getTables(null, null, null, null);
		while (rs.next()) {
			System.out.println(rs.getString("TABLE_NAME"));
		}
	}
	
	@Test 
	public void insertPhoto() {
		Photo photo = new Photo(1050, "defautUrl");
		long id = ctx.insertPhoto(photo);
		assertEquals(1, id);
	}
	
	@Test 
	public void insertCategorie() {
		Categorie categorie = new Categorie("Categorie A");
		long id = ctx.insertCategorie(categorie);
		assertEquals(1, id);
	}

	@Test 
	public void insertArticle() {
		Article article = getArticle();
		long id = ctx.insertArticle(article);
		assertEquals(1, id);
	}
	
	private Article getArticle() {
		Photo photo = new Photo(1050, "defautUrl");
		Categorie categorie = new Categorie("Categorie A");
		
		Article article = new Article(1,
				"Libelle A", 
				"Marque A", 
				100, 
				categorie, 
				photo);
		return article;
	}
	
	@Test
	public void insertUtilisateur() {
		Utilisateur utilisateur = new Utilisateur(
				"JEBBARI", 
				"Rayhane", 
				"jebray@gmail.com",
				"password",
				"20/10/04",
				Role.User
				);
		
		 long id = ctx.insertUtilisateur(utilisateur);
		 assertEquals(1, id);
	}
	
	@Test
	public void insertPanier() {
		Utilisateur utilisateur = new Utilisateur(
				1,
				"JEBBARI", 
				"Rayhane", 
				"jebray@gmail.com",
				"password",
				"20/10/04",
				Role.User
				);
		Panier panier = new Panier(utilisateur, true);
		long id = ctx.insertPanier(panier);
		assertEquals(1, id);
	}
	
	@Test
	public void insertPanierArticle() {
		Article article = getArticle();
		long articleId = ctx.insertArticle(article);
		article.setId((int) articleId);
		
		Utilisateur utilisateur = new Utilisateur(
				1,
				"JEBBARI", 
				"Rayhane", 
				"jebray@gmail.com",
				"password",
				"20/10/04",
				Role.User
				);
		Panier panier = new Panier(utilisateur, true);
		long panierId = ctx.insertPanier(panier);
		panier.setId((int) panierId);
		
		long id = ctx.insertPanierArticle(panier, article);
		assertEquals(1, id);
	}
	
	@Test
	public void insertBoutique() {
		Boutique boutique = new Boutique("description", "myAdresse", "myContact");
		long id = ctx.insertBoutique(boutique);
		assertEquals(1, id);
	}
	
	@Test
	public void getPhoto() {
		Photo photo = ctx.getPhoto(1);
		assertNotNull(photo);
	}
	
	@Test
	public void getPanier() {
		Panier panier = ctx.getPanier(2);
		assertNotNull(panier);
	}
	
	@Test
	public void getCategorie() {
		Categorie categorie = ctx.getCategorie(1);
		assertNotNull(categorie);
	}
	
	@Test
	public void getArticles() {
		ArrayList<Article> articles = ctx.getArticles();
		assertNotNull(articles);
	}
	
	@Test 
	public void getPaniers() {
		ArrayList<Panier> paniers = ctx.getPaniers();
		assertNotNull(paniers);
	}
	
	@Test 
	public void getUtilisateur() {
		Utilisateur utilisateur = ctx.getUtilisateur(1);
	    assertNotNull(utilisateur);
	}
	
	@Test
	public void userExist() {
		String role = ctx.userExist("jebray@gmail.com", "password");
		assertNotNull(role);
	}
	
	@Test
	public void deleteArticle() {
		ctx.deleteArticle(1);

	}
}
