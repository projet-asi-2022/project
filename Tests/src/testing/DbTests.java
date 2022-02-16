package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import boutique.model.Photo;
import db.BoutiqueDbContext;

class DbTests {
	private BoutiqueDbContext ctx;
	
	@Test 
	public void insertPhoto() {
		Photo photo = new Photo(1050, "defautUrl");
		int n = ctx.insertPhoto(photo);
		assertEquals(1, n);
	}
}
