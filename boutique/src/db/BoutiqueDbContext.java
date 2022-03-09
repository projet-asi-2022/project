package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import boutique.model.Article;
import boutique.model.Boutique;
import boutique.model.Categorie;
import boutique.model.Panier;
import boutique.model.Photo;
import boutique.model.Role;
import boutique.model.Utilisateur;

public class BoutiqueDbContext {
	private static final String INSERT_PHOTO_SQL = "INSERT INTO Photo(size, url) VALUES(?, ?)";
	private static final String INSERT_CATEGORIE_SQL = "INSERT INTO Categorie(nom) VALUES(?)";
	private static final String INSERT_ROLE_SQL = "INSERT INTO Role(nom) VALUES(?)";
	private static final String INSERT_BOUTIQUE_SQL = "INSERT INTO Boutique(description, adresse, contact) VALUES(?, ?, ?)";
	private static final String INSERT_PANIER_SQL = "INSERT INTO Panier(confirme) VALUES(?)";
	private static final String INSERT_PANIER_ARTICLE_SQL = "INSERT INTO PanierArticle(idPanier, idArticle) VALUES(?, ?)";
	private static final String INSERT_UTILISATEUR_SQL = "INSERT INTO Utilisateur(nom, prenom, email, idRole, dateNaissance) VALUES(?, ?, ?, ?, ?)";
	private static final String INSERT_ARTICLE_SQL = "INSERT INTO Article(libelle, marque, prix, idPhoto, idCategorie) VALUES(?, ?, ?, ?, ?)";
	
	private static final String DELETE_ARTICLE_BY_ID_SQL = "DELETE * FROM Article WHERE id = ?";
	
	private static final String GET_PHOTO_BY_ID_SQL = "SELECT * FROM Photo WHERE id = ?";
	private static final String GET_ARTICLE_BY_ID_SQL = "SELECT * FROM Article WHERE id = ?";
	private static final String GET_CATEGORIE_BY_ID_SQL = "SELECT * FROM Categorie WHERE id = ?";
	private static final String GET_PANIER_BY_ID_SQL = "SELECT * FROM Panier WHERE id = ?";
	private static final String GET_UTILISATEUR_BY_ID_SQL = "SELECT * FROM Utilisateur WHERE id = ?";
	private static final String GET_ROLE_BY_ID_SQL = "SELECT * FROM Role WHERE id = ?";
	private static final String GET_PANIER_ARTICLE_BY_ID_SQL = "SELECT * FROM PanierArticle WHERE idPanier = ?";
	
	private static final String GET_ARTICLES_SQL = "SELECT id FROM Article";
	private static final String GET_CATEGORIES_SQL = "SELECT id FROM Categorie";
	private static final String GET_PANIERS_SQL = "SELECT id FROM Panier";
	private static final String GET_UTILISATEURS_SQL = "SELECT id FROM Utilisateur";
	
	private Connection conn;
	
	public BoutiqueDbContext() {
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:/home/malinvaud/Dev/project/boutique/src/db/HighTech.db";
			conn = DriverManager.getConnection(dbURL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public long insertArticle(Article article) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			long photoId = insertPhoto(article.getPhoto());
			long categorieId = insertCategorie(article.getCategorie());
			
			ps = conn.prepareStatement(INSERT_ARTICLE_SQL);
			ps.setString(1, article.getLibelle());
			ps.setString(2, article.getLibelle());
			ps.setDouble(3, article.getPrix());
			ps.setLong(4, (int) photoId);
			ps.setLong(5, (int) categorieId);
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertUtilisateur(Utilisateur utilisateur) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			long roleId = insertRole(utilisateur.getRole());
			
			ps = conn.prepareStatement(INSERT_UTILISATEUR_SQL);
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getEmail());
			ps.setLong(4, roleId);
			ps.setString(5, utilisateur.getDateNaissance());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertPanierArticle(Panier panier, Article article) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			ps = conn.prepareStatement(INSERT_PANIER_ARTICLE_SQL);
			ps.setLong(1, panier.getId());
			ps.setLong(2, article.getId());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertPanier(Panier panier) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			ps = conn.prepareStatement(INSERT_PANIER_SQL);
			ps.setInt(1, panier.isConfirme());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertBoutique(Boutique boutique) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			ps = conn.prepareStatement(INSERT_BOUTIQUE_SQL);
			ps.setString(1, boutique.getDescription());
			ps.setString(2, boutique.getAdresse());
			ps.setString(3, boutique.getContact());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertRole(Role role) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			ps = conn.prepareStatement(INSERT_ROLE_SQL);
			ps.setString(1, role.toString());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertPhoto(Photo photo) {
		PreparedStatement ps = null;
		long id = 0;
		try {
			ps = conn.prepareStatement(INSERT_PHOTO_SQL);
			ps.setFloat(1, photo.getSize());
			ps.setString(2, photo.getUrl());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long insertCategorie(Categorie categorie) {
		PreparedStatement ps = null;
		long id = 0;
		try {
		ps = conn.prepareStatement(INSERT_CATEGORIE_SQL);
			ps.setString(1, categorie.getNom());
			int numRowsInserted = ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			id = keys.getLong(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public long deleteArticle(int id) {
		PreparedStatement ps = null;
		try {			
			ps = conn.prepareStatement(DELETE_ARTICLE_BY_ID_SQL);
			ResultSet rs = ps.executeQuery();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return id;
	}
	
	public Photo getPhoto(int id) {
		PreparedStatement ps = null;
		Photo photo = new Photo();
		try {
			ps = conn.prepareStatement(GET_PHOTO_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				photo.setId(rs.getInt("id"));
			    photo.setSize(rs.getFloat("size")); 
                photo.setUrl(rs.getString("url"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return photo;
	}
	
	public Categorie getCategorie(int id) {
		PreparedStatement ps = null;
		Categorie categorie = new Categorie();
		try {
			ps = conn.prepareStatement(GET_CATEGORIE_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				categorie.setId(rs.getInt("id"));
				categorie.setNom(rs.getString("nom"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return categorie;
	}
	
	public Article getArticle(int id) {
		PreparedStatement ps = null;
		Article article = new Article();
		Photo photo = new Photo();
		Categorie categorie = new Categorie();
		long photoId = 0;
		long categorieId = 0;
		
		try {
			ps = conn.prepareStatement(GET_ARTICLE_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				article.setId(rs.getInt("id"));
			    article.setLibelle(rs.getString("libelle")); 
			    article.setMarque(rs.getString("marque")); 
			    article.setPrix((float) rs.getDouble("prix"));
			    photoId = rs.getInt("idPhoto");
			    categorieId = rs.getInt("idCategorie");
            }
			
			photo = getPhoto((int) photoId);
			categorie = getCategorie((int) categorieId);
			
			article.setPhoto(photo);
			article.setCategorie(categorie);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return article;
	}
	
	public ArrayList<Article> getArticles() {
		PreparedStatement ps = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try {
			ps = conn.prepareStatement(GET_ARTICLES_SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ids.add(rs.getInt("id"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		ArrayList<Article> articles = new ArrayList<Article>();
		ids.forEach(id -> {
			Article article = getArticle(id);
			articles.add(article);
		});
		
		return articles;
	}
	
	public ArrayList<Categorie> getCategories() {
		PreparedStatement ps = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try {
			ps = conn.prepareStatement(GET_CATEGORIES_SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ids.add(rs.getInt("id"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		ids.forEach(id -> {
			Categorie categorie = getCategorie(id);
			categories.add(categorie);
		});
		
		return categories;
	}
	
	public ArrayList<Panier> getPaniers() {
		PreparedStatement ps = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try {
			ps = conn.prepareStatement(GET_PANIERS_SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ids.add(rs.getInt("id"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		ArrayList<Panier> paniers = new ArrayList<Panier>();
		ids.forEach(id -> {
			Panier panier = getPanier(id);
			paniers.add(panier);
		});
		
		return paniers;
	}
	
	public ArrayList<Utilisateur> getUtilisateurs() {
		PreparedStatement ps = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try {
			ps = conn.prepareStatement(GET_UTILISATEURS_SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ids.add(rs.getInt("id"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		ids.forEach(id -> {
			Utilisateur utilisateur = getUtilisateur(id);
			utilisateurs.add(utilisateur);
		});
		
		return utilisateurs;
	}
	
	public Role getRole(int id) {
		PreparedStatement ps = null;
		String role = "";
		try {
			ps = conn.prepareStatement(GET_ROLE_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				role = rs.getString("nom");
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return Role.valueOf(role);
	}
	
	public Utilisateur getUtilisateur(int id) {
		PreparedStatement ps = null;
		Utilisateur utilisateur = new Utilisateur();
		try {
			ps = conn.prepareStatement(GET_UTILISATEUR_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setDateNaissance(rs.getString("dateNaissance"));
			    
				long idRole = rs.getInt("idRole");
				Role role = getRole((int) idRole);
				utilisateur.setRole(role);
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return utilisateur;
	}
	
	private ArrayList<Integer> getArticleIdsByPanierId(int id) {
		PreparedStatement ps = null;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			ps = conn.prepareStatement(GET_PANIER_ARTICLE_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ids.add(rs.getInt("idArticle"));
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return ids;
	}
	
	private ArrayList<Article> getArticlesByPanierId(int panierId){
		ArrayList<Integer> ids = getArticleIdsByPanierId(panierId);
		
		ArrayList<Article> articles = new ArrayList<Article>();
		ids.forEach(id -> {
			Article article = getArticle(id);
			articles.add(article);
		});
		
		return articles;
	}
	
	public Panier getPanier(int id) {
		PreparedStatement ps = null;
		Panier panier = new Panier();
		try {
			ps = conn.prepareStatement(GET_CATEGORIE_BY_ID_SQL);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				panier.setId(rs.getInt("id"));
				panier.setConfirme(rs.getInt("confirme"));
				
				int utilisateurId = rs.getInt("idUtilisateur");
				Utilisateur utilisateur = getUtilisateur(utilisateurId);
				panier.setUser(utilisateur);
				
				ArrayList<Article> articles = getArticlesByPanierId(id);
				panier.setArticles(articles);
            }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return panier;
	}
	
	public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}