package view;

import java.io.IOException;

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
 * Servlet implementation class EditarAparelho
 */
public class EditarAparelhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAparelhoServlet() {
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
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String defeito = request.getParameter("defeito");
		String observacoes = request.getParameter("observacoes");
		String serie = request.getParameter("serie");
		
		int id = Integer.parseInt(idString);
		
		Aparelho aparelho = new Aparelho(id,nome, modelo, marca, defeito,observacoes,serie);
		
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		
		if(aparelhoDAO.editar(aparelho)){
			
			// Se o cliente for editado, sera redirecionado para o servlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarAparelhoServlet");
			requestDispatcher.forward(request, response);
			
		}
	}

}
