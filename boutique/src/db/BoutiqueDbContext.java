package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	private static final String GET_PHOTO_BY_ID_SQL = "SELECT COUNT(*) FROM Photo WHERE columnName = ?";
	
	private Connection conn;
	
	public BoutiqueDbContext() {
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:HighTech.db";
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
			ps.setString(1, article.getMarque());
			ps.setDouble(1, article.getPrix());
			ps.setLong(1, photoId);
			ps.setLong(1, categorieId);
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
			
			ps = conn.prepareStatement(INSERT_PANIER_ARTICLE_SQL);
			ps.setString(1, utilisateur.getNom());
			ps.setString(1, utilisateur.getPrenom());
			ps.setString(1, utilisateur.getEmail());
			ps.setLong(1, roleId);
			ps.setString(1, utilisateur.getDateNaissance());
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
			ps.setInt(1, panier.getId());
			ps.setInt(1, article.getId());
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
			ps.setInt(1, panier.getId());
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
			ps.setString(1, boutique.getAdresse());
			ps.setString(1, boutique.getContact());
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
			ps.setString(1, role.getNom());
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