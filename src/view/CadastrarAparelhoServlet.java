package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AparelhoDAO;
import bean.Aparelho;

/**
 * Servlet implementation class CadastrarAparelhoServlet
 */
public class CadastrarAparelhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAparelhoServlet() {
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
		String nome = request.getParameter("nome");
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String defeito = request.getParameter("defeito");
		String observacoes = request.getParameter("observacoes");
		String serie = request.getParameter("serie");
		
		Aparelho aparelho = new Aparelho(nome, modelo, marca, defeito, observacoes, serie);
		
		//Adiciona o aparelho ao banco
		AparelhoDAO aparelhoDAO = new AparelhoDAO();
		
		if(aparelhoDAO.inserir(aparelho)){
			//Se foi inserido corretamente, entao manda listar
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarAparelhoServlet");
			requestDispatcher.forward(request, response);
		}else {
			//Redirecionando para a pagina de erro
			response.sendRedirect("cadastroFalhou.html");
		}
		
		
	}

}
