package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import bean.Cliente;

/**
 * Servlet implementation class CadastrarClienteServlet
 */
public class CadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// Busca os parametros do request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefoneFixo = request.getParameter("telefoneFixo");
		String celular = request.getParameter("celular");

		Cliente cliente = new Cliente(nome, endereco, telefoneFixo, celular);

		// Adiciona o cliente ao banco

		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.inserir(cliente)) {
			// Se o cliente for inserido, sera redirecionado para o servlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarClienteServlet");
			requestDispatcher.forward(request, response);
		} else {
			// Redirecionando para pagina de erro
			response.sendRedirect("CadastroFalhou.html");
		}

	}

}
