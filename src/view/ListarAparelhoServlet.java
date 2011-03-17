package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AparelhoDAO;
import bean.Aparelho;

/**
 * Servlet implementation class ListarAparelhoServlet
 */
public class ListarAparelhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAparelhoServlet() {
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
		//Busca o atributo lista de aparelhos do request
		List<Aparelho> aparelhos = (List<Aparelho>) request.getAttribute("aparelhos");
		
		//Se o atributo estiver nulo, sera listado a partir do banco
		if(aparelhos == null){
			AparelhoDAO aparelhoDAO = new AparelhoDAO();
			aparelhos = aparelhoDAO.listar();
		}
		
		request.setAttribute("aparelhos", aparelhos);
		
		//Redirecionando para a pagina que lista os aparelhos
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarAparelhos.jsp");
		requestDispatcher.forward(request, response);
	}

}
