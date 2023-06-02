package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoBanco;
import dao.DaoAutorRepository;
import dao.DaoPostRepository;

import java.util.ArrayList;
import models.Autor;
import models.Post;

@WebServlet("/cadastro/post")
public class ServletCadPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConexaoBanco conexao = new ConexaoBanco();
		DaoAutorRepository daoAutorRepository = new DaoAutorRepository(conexao);
	    
	    List<Autor> autores = daoAutorRepository.consultarAutores();
	    
	    request.setAttribute("autores", autores);
	    
	    String conteudoPage = "/cadastro/cadPost.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idAutor = Integer.parseInt(request.getParameter("autorPost"));
		String titulo = request.getParameter("tituloPost");
		String resumo = request.getParameter("resumoPost");
		String conteudo = request.getParameter("conteudoPost");
		if(titulo!=null && !titulo.isEmpty() && resumo!=null && !resumo.isEmpty() && conteudo!=null && !conteudo.isEmpty()) {
			Post post = new Post(idAutor, titulo, resumo, conteudo);
			ConexaoBanco conexao = new ConexaoBanco();
			
			DaoPostRepository daoPostRepository = new DaoPostRepository(conexao);
			
			boolean cadastro = daoPostRepository.cadastrar(post);
			if(cadastro) {
				request.setAttribute("alert", "Post cadastrado com sucesso");
			}else {
				request.setAttribute("alert", "Erro ao criar o post");
			}
		}else {
			request.setAttribute("alert", "CAMPOS VAZIOS!");
		}
		
		doGet(request, response);
	}
}
