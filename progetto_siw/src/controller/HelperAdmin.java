package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class HelperAdmin {

	public boolean IsNotValid(HttpServletRequest request) throws UnsupportedEncodingException {

		String id = request.getParameter("id");  
		String password = request.getParameter("password");

		boolean errore = false;

		if(id.isEmpty()) {
			String  mess = "L'id � un campo obbligatorio";
			request.setAttribute("idErr", mess );  //Passo alla form il messaggio di errore
			errore = true;
		}

		if(password.isEmpty()) {
			String  mess = "La password � un campo obbligatorio";
			request.setAttribute("passwordErr", mess );  //Passo alla form il messaggio di errore
			errore = true;
		}
		if(!errore)//TODO controlla se password � associata al id presente nella lista di admin nel server 
			{
			String mess="L'associazione id password � errata";
			request.setAttribute("idpasErr", mess);
			errore= true;
		}

		return errore;
	}
}