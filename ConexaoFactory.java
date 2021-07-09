package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public Connection getConnection() {
		try {
		
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
			
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/sistemabancario", "root", "");
			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}


