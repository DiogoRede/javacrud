package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoBanco;
import dao.DaoAutorRepository;
import models.Autor;
import java.io.File;
@WebServlet("/cadastro/autor")
public class ServletCadAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conteudoPage = "/cadastro/cadAutor.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeAutor");
	    String resumo=request.getParameter("resumoAutor");
	    
	    if(nome!=null && !nome.isEmpty() && resumo!=null && !resumo.isEmpty()) {
	    	Autor autor = new Autor(nome, resumo);
	    	ConexaoBanco conexao = new ConexaoBanco();
		    DaoAutorRepository daoAutorRepository = new DaoAutorRepository(conexao);
		    boolean cadastro = daoAutorRepository.cadastrar(autor);

		    if(cadastro) {
		    	request.setAttribute("alert", "Autor cadastrado com sucesso!");
		    }else {
		    	request.setAttribute("alert", "Informações incorretas");
		    }
		    conexao.desconecta();
	    }else {
	    	request.setAttribute("alert", "CAMPOS VAZIOS");
	    }
	    
		String conteudoPage = "/cadastro/cadAutor.jsp";
	    request.setAttribute("conteudoPage", conteudoPage);
	       
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

}
