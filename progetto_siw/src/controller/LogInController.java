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

@WebServlet("/LogInController")
public class LogInController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Lettura dei parametri

<<<<<<< HEAD
		HelperAdmin helperAdmin = new HelperAdmin();
=======
		HelperAdmin helperadmin = new HelperAdmin();
>>>>>>> refs/remotes/origin/master
		AdminForm adminForm = new AdminForm();
		HttpSession session = req.getSession();
		//Gestione della risposta
		String nextPage;

<<<<<<< HEAD
		if(helperAdmin.IsNotValid(req)) {
			nextPage = "/ControlloAdmin.jsp";
=======
		if(helperadmin.IsNotValid(req)) {
			nextPage = "/ControlloAdim.jsp";

>>>>>>> refs/remotes/origin/master
		}
		else {
			adminForm.setId(req.getParameter("id"));
			adminForm.setPassword(req.getParameter("password"));
			session.setAttribute("AdminForm", adminForm);
			nextPage = "/HomeAdmin.jsp";

		}
		ServletContext application = getServletContext();
		RequestDispatcher rd;
		rd = application.getRequestDispatcher(nextPage);
		rd.forward(req, resp);
		return;

	}
}


