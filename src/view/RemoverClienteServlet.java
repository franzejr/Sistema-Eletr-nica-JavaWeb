package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import bean.Cliente;

/**
 * Servlet implementation class RemoverClienteServlet
 */
public class RemoverClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// Busca os parametros do request
		String ide = request.getParameter("id");
		
		int id = Integer.parseInt(ide);

		// Adiciona o cliente ao banco

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente(id);

		if (clienteDAO.remover(cliente)) {
			// Se o cliente for inserido, sera redirecionado para o servlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarClienteServlet");
			requestDispatcher.forward(request, response);
		} else {
			// Redirecionando para pagina de erro
			response.sendRedirect("CadastroFalhou.html");
		}
	}

}
