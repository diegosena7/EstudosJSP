package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

/**
 * Esta classe DAO fornece opera??es de banco de dados CRUD para os usu?rios da tabela no banco de dados.
 * @author Diego Sena
 */
public class UsuarioDAO {
	
	/** Connection object with class CriaConexaoDAO. */
	CriaConexaoDAO conexao = new CriaConexaoDAO();

	/** The Constant INSERIR_USUARIO. */
	private static final String INSERIR_USUARIO = "INSERT INTO usuarios (nome, email, pais) VALUES (?, ?, ?);";

	/** The Constant BUSCAR_USUARIO_POR_ID. */
	private static final String BUSCAR_USUARIO_POR_ID = "select id, nome , email , pais from usuarios where id = ?";
	
	/** The Constant BUSCAR_TODOS_USUARIOS. */
	private static final String BUSCAR_TODOS_USUARIOS = "select * from usuarios";
	
	/** The Constant DELETAR_USUARIO. */
	private static final String DELETAR_USUARIO = "delete from usuarios where id = ?;";
	
	/** The Constant ATUALIZAR_USUARIO. */
	private static final String ATUALIZAR_USUARIO = "update usuarios set nome = ?, email= ?, pais = ? where id = ?;";

	/**
	 * Instantiates a new user DAO.
	 */
	public UsuarioDAO() {
	}

	/**
	 * Inserir usuario.
	 * @param user the user
	 * @throws SQLException the SQL exception
	 */
	public void inserirUsuario(Usuario user) throws SQLException {
		System.out.println(INSERIR_USUARIO);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = conexao.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_USUARIO)) {
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPais());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	/**
	 * Buscar usuario por id.
	 * @param id the id
	 * @return the user
	 */
	public Usuario buscarUsuarioPorId(int id) {
		Usuario usuarioUnico = null;
		// Step 1: Establishing a Connection
		try (Connection connection = conexao.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_USUARIO_POR_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarioUnico = new Usuario(id, nome, email, pais);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return usuarioUnico;
	}

	/**
	 * Buscar todos os usuarios.
	 * @return the list
	 */
	public List<Usuario> buscarTodosOsUsuarios() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Usuario> usuarios = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = conexao.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_TODOS_USUARIOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id, nome, email, pais));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return usuarios;
	}

	/**
	 * Deletar usuario.
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deletarUsuario(int id) throws SQLException {
		boolean usuarioDeletado;
		try (Connection connection = conexao.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETAR_USUARIO);) {
			statement.setInt(1, id);
			usuarioDeletado = statement.executeUpdate() > 0;
		}
		return usuarioDeletado;
	}

	/**
	 * Atualizar usuario.
	 * @param user the user
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean atualizarUsuario(Usuario user) throws SQLException {
		boolean usuarioAtualizado;
		try (Connection connection = conexao.getConnection();
				PreparedStatement statement = connection.prepareStatement(ATUALIZAR_USUARIO);) {
			statement.setString(1, user.getNome());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPais());
			statement.setInt(4, user.getId());

			usuarioAtualizado = statement.executeUpdate() > 0;
		}
		return usuarioAtualizado;
	}

	/**
	 * Prints the SQL exception.
	 * @param ex the ex
	 */
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}

