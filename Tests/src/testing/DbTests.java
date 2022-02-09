package testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DbTests {

	@Test
	void connectionTest() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		String dbURL = "jdbc:sqlite:HightTechDB.db";
        Connection conn = DriverManager.getConnection(dbURL);
        DatabaseMetaData metaData = conn.getMetaData();
        String[] types = {"TABLE"};
        //Retrieving the columns in the database
        ResultSet tables = metaData.getTables(null, null, "%", types);
        while (tables.next()) {
           System.out.println(tables.getString("TABLE_NAME"));
        }
	}

}
