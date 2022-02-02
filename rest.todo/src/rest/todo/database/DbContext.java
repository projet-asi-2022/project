package rest.todo.database;

public class DbContext {
	
	private Connection connect() {
		String dbURL = "jdbc:sqlite:HightTechDB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public DbContext() {
		connect();
	}
	
	public int createArticle(Article article) {
		
	}
}
