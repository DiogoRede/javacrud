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

@WebServlet("/autores")
public class ServletAutores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAutores() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAutor = request.getParameter("id");
		String acao = request.getParameter("acao");
		ConexaoBanco conexao = new ConexaoBanco();
		DaoAutorRepository daoAutorRepository = new DaoAutorRepository(conexao);
		String conteudoPage = "";
		
		if(idAutor!=null && !idAutor.isEmpty()) {
			conteudoPage = "/update/updateAutor.jsp";
			if(request.getSession().getAttribute("usuario")!=null && acao!=null && !acao.isEmpty() ) {
				if(acao.equalsIgnoreCase("delete")) {
					daoAutorRepository.deletar(Integer.parseInt(idAutor));
					conteudoPage = "/pages/autores.jsp";
					response.sendRedirect("/prova2/autores");
					return;
				}
			}else {
				request.setAttribute("autor", daoAutorRepository.consultarId(Integer.parseInt(idAutor)));
			}
		}else {
			request.setAttribute("autores", daoAutorRepository.consultarAutores());
			
			conteudoPage = "/pages/autores.jsp";  
		}
		
		
		
		request.setAttribute("conteudoPage", conteudoPage);
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAutor = request.getParameter("idAutor");
		String nome = request.getParameter("nomeAutor");
		String resumo=request.getParameter("resumoAutor");
		ConexaoBanco conexao = new ConexaoBanco();
		DaoAutorRepository daoAutorRepository = new DaoAutorRepository(conexao);
		
		if(idAutor!=null && !idAutor.isEmpty() && nome!=null && !nome.isEmpty() && resumo!=null && !resumo.isEmpty()) {
			Autor autor = new Autor();
			autor.setId(Integer.parseInt(idAutor));
			autor.setNome(nome);
			autor.setResumo(resumo);
			
			boolean atualizou = daoAutorRepository.atualizar(autor);
			
			if(atualizou) {
				request.setAttribute("alert", "Autor atualizado com sucesso");
			}else {
				request.setAttribute("alert", "Erro para atualizar");
			}
		}
		String conteudoPage = "/update/updateAutor.jsp";
		request.setAttribute("autor", daoAutorRepository.consultarId(Integer.parseInt(idAutor)));
		request.setAttribute("conteudoPage", conteudoPage);
		conexao.desconecta();
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

}
