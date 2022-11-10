package br.com.fiap.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.store.business.operations.EmailBO;
import br.com.fiap.store.model.Usuario;
import br.com.fiap.store.model.DAO.DAOFactory;
import br.com.fiap.store.model.DAO.UsuarioDAO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	private EmailBO bo;

    public LoginServlet() {
        dao = DAOFactory.createUsuarioDAO();
        bo = new EmailBO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(email,senha);
		
		if(dao.validarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
		
			
			
		}
		else {
			request.setAttribute("erro", "Erro ao logar");
		}
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

}
