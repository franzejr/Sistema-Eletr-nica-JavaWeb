package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cliente;

import DAO.ClienteDAO;

/**
 * Servlet implementation class BuscarClientesPorNomeServlet
 */
public class BuscarClientesPorNomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarClientesPorNomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Busca o parametro nome do cliente no request
		String nome = request.getParameter("nome");
		
		//Busca o cliente pelo nome
		ClienteDAO clienteDAO = new ClienteDAO();
		
		List<Cliente> clientes = clienteDAO.buscarPorNome(nome);
		
		//Adiciona a lista de clientes na requisicao
		request.setAttribute("clientes", clientes);
		
		//Obtendo o RequestDispatcher para o Servlet que lista os clientes
		RequestDispatcher rd = request.getRequestDispatcher("/ListarClienteServlet");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
