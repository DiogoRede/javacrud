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
import dao.DaoComentarioRepository;
import dao.DaoPostRepository;
import models.Comentario;
import models.Post;

@WebServlet("/post/comentario")
public class ServletComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletComentario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/prova2/home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean cadastrou = false;
		String idPublicacao = request.getParameter("idPublicacao").trim();
		String tipoPublicacao = request.getParameter("tipoPublicacao").trim();
		String nome = request.getParameter("nomeComentario").trim();
		String mensagem = request.getParameter("mensagemComentario").trim();
		
		if (idPublicacao != null && !idPublicacao.isEmpty() && tipoPublicacao != null && nome != null && mensagem != null
			    && !tipoPublicacao.isEmpty() && !nome.isEmpty() && !mensagem.isEmpty()) {
			Comentario comentario = new Comentario();
			
			ConexaoBanco conexao = new ConexaoBanco();
			DaoComentarioRepository daoComentarioRepository = new DaoComentarioRepository(conexao);
			
			comentario.setIdPublicacao(Integer.parseInt(idPublicacao));
			comentario.setTipoPublicacao(tipoPublicacao);
			comentario.setNome(nome);
			comentario.setMensagem(mensagem);

			cadastrou = daoComentarioRepository.cadastrar(comentario);	
			
			if(cadastrou) {
				response.sendRedirect("/prova2/" + tipoPublicacao + "?id=" + idPublicacao);
				return;
			}else {
				request.setAttribute("alert", "Falha ao cadastrar o comentario");
			}
		}else {
			request.setAttribute("alert", "CAMPOS VAZIOS!");
		}
		
		response.sendRedirect("/prova2/" + tipoPublicacao + "?id=" + idPublicacao);

	}
}
