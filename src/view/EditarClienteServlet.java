package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cliente;

import DAO.ClienteDAO;

/**
 * Servlet implementation class EditarClienteServlet
 */
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		
		//Busca os parametros do request
		String idString = request.getParameter("id");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefoneFixo = request.getParameter("telefoneFixo");
		String celular = request.getParameter("celular");
		
		int id = Integer.parseInt(idString);
		
		Cliente cliente = new Cliente(id,nome, endereco, telefoneFixo, celular);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(clienteDAO.editar(cliente)){
			
			// Se o cliente for editado, sera redirecionado para o servlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarClienteServlet");
			requestDispatcher.forward(request, response);
			
		}
	}

}
