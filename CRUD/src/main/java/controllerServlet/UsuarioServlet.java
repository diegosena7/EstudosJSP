package controllerServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * ControllerServlet.java
 * Este servlet atua como um controlador/controller de requisi??es web feitas ao aplicativo, tratando de todas as solicita??es do usu?rio.
 * @author Diego Sena
 */

@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The usuario DAO. */
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Inits the.
	 */
	public void init() {
		usuarioDAO = new UsuarioDAO();
	}

	/**
	 * Do post.
	 * M?todo respons?vel pelas altera??es solicitadas pelo usu?rio da nossa aplica??o.
	 * Encaminha as requisi??es do tipo post para o m?todo doGet, pois este, trata as
	 * solicita??es e encaminha de acordo com as requisi??es aos m?todos respons?veis
	 * pelas devidas a??es solicitadas pelo usu?rio.
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Do get.
	 * M?todo respons?vel por direcionar as requi??es do usu?rio aos m?todos respons?veis pelo CRUD
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				formNovoUsuario(request, response);
				break;
			case "/insert":
				inserirUsuario(request, response);
				break;
			case "/delete":
				deletarUsuarioUnico(request, response);
				break;
			case "/edit":
				formEditarUsuario(request, response);
				break;
			case "/update":
				atualizarUsuarioUnico(request, response);
				break;
			default:
				listarUsuarios(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * Listar usuarios.
	 * @param request the request
	 * @param response the response
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Usuario> listaDeUsuarios = usuarioDAO.buscarTodosOsUsuarios();
		request.setAttribute("listaDeUsuarios", listaDeUsuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Form novo usuario.
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void formNovoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Form editar usuario.
	 * @param request the request
	 * @param response the response
	 * @throws SQLException the SQL exception
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void formEditarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioExistente = usuarioDAO.buscarUsuarioPorId(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("usuario", usuarioExistente);
		dispatcher.forward(request, response);
	}

	/**
	 * Inserir usuario.
	 * @param request the request
	 * @param response the response
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		Usuario novoUsuario = new Usuario(nome, email, pais);
		usuarioDAO.inserirUsuario(novoUsuario);
		response.sendRedirect("list");
	}

	/**
	 * Atualizar usuario unico.
	 * @param request the request
	 * @param response the response
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void atualizarUsuarioUnico(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");

		Usuario usuarioAtualizado = new Usuario(id, nome, email, pais);
		usuarioDAO.atualizarUsuario(usuarioAtualizado);
		response.sendRedirect("list");
	}

	/**
	 * Deletar usuario unico.
	 * @param request the request
	 * @param response the response
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void deletarUsuarioUnico(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDAO.deletarUsuario(id);
		response.sendRedirect("list");
	}
}
