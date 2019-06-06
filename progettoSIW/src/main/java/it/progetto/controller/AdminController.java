package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.progetto.model.Admin;
import it.progetto.services.AdminService;
import it.progetto.services.AdminValidator;

@Controller
public class AdminController {
@Autowired
private AdminService adminservice;
@Autowired
private AdminValidator adminvalidator;

@RequestMapping(value="/admin",method= RequestMethod.POST)
public String logIn(@Valid @ModelAttribute("admin")Admin admin,
Model model,BindingResult bindingresult) {
	this.adminvalidator.validate(admin,bindingresult);
	if(!bindingresult.hasErrors()) {
		if(this.adminservice.check(admin)) {
		return "paginaAdmin.html";}
		else {
			ObjectError error= new ObjectError("idpsw","required");
			bindingresult.addError(error);
			return"AdminForm";
		}
	}
		
	else
		return "AdminForm";
}
}
