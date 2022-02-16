package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import boutique.model.Photo;

public class BoutiqueDbContext {
	private static final String INSERT_PHOTO_SQL = "INSERT INTO Photo(size, url) VALUES(?, ?)";
	private Connection conn;
	
	public BoutiqueDbContext() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		String dbURL = "jdbc:sqlite:HighTech.db";
        conn = DriverManager.getConnection(dbURL);
	}
	
	public int insertPhoto(Photo photo) {
		int numRowsInserted = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(INSERT_PHOTO_SQL);
			ps.setFloat(1, photo.getSize());
			ps.setString(2, photo.getUrl());
			numRowsInserted = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(ps);
		}
		return numRowsInserted;
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