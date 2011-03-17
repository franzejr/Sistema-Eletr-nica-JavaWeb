package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AparelhoDAO;
import DAO.ClienteDAO;
import bean.Aparelho;
import bean.Cliente;

/**
 * Servlet implementation class ListarClienteServlet
 */
public class ListarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Busca o atributo lista de clientes do request
		List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
		
		//Se o atributo estiver nulo, sera listado a partir do banco
		if(clientes == null){
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
		}
		
		request.setAttribute("clientes", clientes);
		
		//Redirecionando para a pagina que lista os aparelhos
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarClientes.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
