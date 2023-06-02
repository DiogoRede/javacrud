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
import dao.DaoAutorRepository;
import dao.DaoComentarioRepository;
import dao.DaoPostRepository;
import models.Autor;
import models.Post;

@WebServlet("/post")
public class ServletPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletPost() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conteudoPage = "/pages/post.jsp";
		ConexaoBanco conexao = new ConexaoBanco();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String acao = request.getParameter("acao");
		
		DaoPostRepository daoPostRepository = new DaoPostRepository(conexao);
		Post post = daoPostRepository.consultarId(id);
		request.setAttribute("post", post);
		
		if(request.getSession().getAttribute("usuario")!=null) {
			
			
			if(acao!=null) {
				if(acao.equals("update")) {
					DaoAutorRepository daoAutorRepository = new DaoAutorRepository(conexao);
					List<Autor> autores = daoAutorRepository.consultarAutores();
					request.setAttribute("autores", autores);
					conteudoPage = "/update/updatePost.jsp";
				}else if (acao.equals("delete")){
					daoPostRepository.deletar(post.getIdPost());
					conteudoPage = "/home";
				}
			}
			
		}
		if(acao==null || acao.isEmpty()) {
			DaoAutorRepository daoAutorRepository = new DaoAutorRepository(conexao);
			Autor autor = daoAutorRepository.consultarId(post.getIdAutor());
			request.setAttribute("autor", autor);
		}
		
		
		
		DaoComentarioRepository daoComentarioRepository = new DaoComentarioRepository(conexao);
		request.setAttribute("comentarios", daoComentarioRepository.consultarTodos(id, "post"));

	    request.setAttribute("conteudoPage", conteudoPage); 
	    
	    conexao.desconecta();
	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conteudoPage;
		boolean atualizado = false;
		int idPost = Integer.parseInt(request.getParameter("idPost"));
        Integer idAutor = Integer.parseInt(request.getParameter("autorPost"));
        String titulo = request.getParameter("tituloPost");
        String resumo = request.getParameter("resumoPost");
        String conteudo = request.getParameter("conteudoPost");
        Post post = new Post();
        
        if (idAutor!= null && idAutor != 0 &&  titulo != null && !titulo.isEmpty()
                && resumo != null && !resumo.isEmpty()
                && conteudo != null && !conteudo.isEmpty()) {   	
            post.setIdPost(idPost);
            post.setIdAutor(idAutor);
            post.setTitulo(titulo);
            post.setResumo(resumo);
            post.setConteudo(conteudo);
            ConexaoBanco conexao = new ConexaoBanco();
            
            DaoPostRepository daoPostRepository = new DaoPostRepository(conexao);
            atualizado = daoPostRepository.atualizar(post);
            
            if (!atualizado){
            	request.setAttribute("alert", "Erro na atualização");
            }
            conexao.desconecta();
        }else {
        	request.setAttribute("alert", "CAMPOS VAZIOS!");
        }
		if(atualizado) {
			conteudoPage = "/home";
		}else {
			conteudoPage = "/update/updatePost.jsp";
		}
		request.setAttribute("conteudoPage", conteudoPage);
		RequestDispatcher redirecionar = request.getRequestDispatcher("/pages/layout.jsp");
	    redirecionar.forward(request, response);
	}

}
