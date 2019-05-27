package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import services.Adminservices;

@WebServlet("/LogIn")
public class LogInController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Lettura dei parametri

		HelperAdmin helperstudente = new HelperAdmin();
		AdminForm adminForm = new AdminForm();
		HttpSession session = req.getSession();
		//Gestione della risposta
		String nextPage;

		if(helperstudente.IsNotValid(req)) {
			nextPage = "/ControlloAdim.jsp";

		}
		else {
			adminForm.setId(req.getParameter("id"));
			adminForm.setPassword(req.getParameter("password"));
			session.setAttribute("AdminForm", adminForm);
			nextPage = "/risposta.jsp";

		}
		ServletContext application = getServletContext();
		RequestDispatcher rd;
		rd = application.getRequestDispatcher(nextPage);
		rd.forward(req, resp);
		return;

	}
	}


