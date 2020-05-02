package accesoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class AccesoDB {
	
	private String driver;
	private String url;
	
	public AccesoDB() {
		driver = "org.sqlite.JDBC";
		url = "jdbc:sqlite:dbSQLite/pruebaUsuarioLibro.db";
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		
		Connection con = DriverManager.getConnection(url, config.toProperties());
		System.out.println("Conexión establecida");
		
		return con;
	}
	
	

}
