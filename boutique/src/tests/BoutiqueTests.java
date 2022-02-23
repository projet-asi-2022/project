package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import boutique.model.Article;
import boutique.model.Categorie;
import boutique.model.Photo;
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
		Photo photo = new Photo(1050, "defautUrl");
		Categorie categorie = new Categorie("Categorie A");
		
		Article article = new Article(
				"Libelle A", 
				"Marque A", 
				100, 
				categorie, 
				photo);
		
		long id = ctx.insertArticle(article);
		assertEquals(1, id);
	}
}
