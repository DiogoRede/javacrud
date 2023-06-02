package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoBanco;
import dao.DaoPostRepository;
import dao.DaoVideoRepository;
import models.Post;
import models.Video;

@WebServlet("/home")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conteudoPage = "/pages/home.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	    ConexaoBanco conexao = new ConexaoBanco();
	    
	    DaoVideoRepository daoVideoRepository = new DaoVideoRepository(conexao);
	    List<Video> videos = daoVideoRepository.consultaHome();
	    request.setAttribute("videos", videos);
	    
	    DaoPostRepository daoPostRepository = new DaoPostRepository(conexao);
	    List<Post> posts = daoPostRepository.consultarTodos();
	    request.setAttribute("posts", posts);
	    
	    conexao.desconecta();
	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
