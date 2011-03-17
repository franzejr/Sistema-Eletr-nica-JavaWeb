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
 * Servlet implementation class RemoverAparelhoServlet
 */
public class RemoverAparelhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverAparelhoServlet() {
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

		// Busca os parametros do request
		String ide = request.getParameter("id");
		
		int id = Integer.parseInt(ide);

		// Adiciona o aparelho ao banco

		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		Aparelho aparelho = new Aparelho(id);

		if (aparelhoDAO.remover(aparelho)) {
			// Se o cliente for inserido, sera redirecionado para o servlet
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarAparelhoServlet");
			requestDispatcher.forward(request, response);
		} else {
			// Redirecionando para pagina de erro
			response.sendRedirect("CadastroFalhou.html");
		}
	}

}
