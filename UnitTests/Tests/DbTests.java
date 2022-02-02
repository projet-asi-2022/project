package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DbTests {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		String dbURL = "jdbc:sqlite:HightTechDB.db";
        Connection conn = DriverManager.getConnection(dbURL);
        Boolean isValid = conn.isValid(300);
		assertTrue(isValid);
	}

}
