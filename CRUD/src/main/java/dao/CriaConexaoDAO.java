package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class CriaConexaoDAO.
 */
public class CriaConexaoDAO {

	/** The jdbc driver de conexao. */
	final String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The jdbc URL de conexao. */
	private String jdbcURLDeConexao = "jdbc:mysql://127.0.0.1:3306/crudUsuarios?useTimezone=true&serverTimezone=UTC";
	
	/** The jdbc nome de usuario. */
	private String jdbcNomeDeUsuario = "root";
	
	/** The jdbc senha. */
	private String jdbcSenha = "Santosfc@1912";
	
	/**
	 * Classe de conexão.
	 * @return the connection
	 */
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(jdbcURLDeConexao, jdbcNomeDeUsuario, jdbcSenha);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return connection;
	}
}
