package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLoginRepository;
import models.Login;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoLoginRepository daoLoginRepository = new DaoLoginRepository();
	
    public ServletLogin() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if(acao!=null && acao.equalsIgnoreCase("logout")) {
			request.getSession().invalidate();
			RequestDispatcher redirecionar = request.getRequestDispatcher("login.jsp");
			redirecionar.forward(request, response);
			return;
		}
		RequestDispatcher redirecionar = request.getRequestDispatcher("login.jsp");
	    redirecionar.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("nomeUsuario");
	    String senha = request.getParameter("senhaUsuario");

	    if (login != null && senha != null && !login.isEmpty() && !senha.isEmpty()) {
	        Login modelLogin = new Login(login, senha);

	        if (daoLoginRepository.verificarLogin(modelLogin)) {
	            request.getSession().setAttribute("usuario", modelLogin.getLogin());
	            request.setAttribute("logado", request.getSession().getAttribute("usuario"));
	    	    RequestDispatcher redirecionar = request.getRequestDispatcher("/home");
	    	    redirecionar.forward(request, response);
	            return;
	        }else {
	        	request.setAttribute("alert", "Login e senha inválidos!");
	        }
	    }else {
	    	request.setAttribute("alert", "Campos Vazios");
	    }

	    
	    RequestDispatcher redirecionar = request.getRequestDispatcher("login.jsp");
	    redirecionar.forward(request, response);
	}

}
