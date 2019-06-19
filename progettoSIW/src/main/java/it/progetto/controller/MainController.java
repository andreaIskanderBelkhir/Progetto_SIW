package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.progetto.model.Admin;
import it.progetto.model.Richiesta;
import it.progetto.repository.RichiestaRepository;
import it.progetto.services.RichiestaValidator;

@Controller
public class MainController {
	
	@Autowired
	private RichiestaRepository richiestaRepository;

	@Autowired
	private RichiestaValidator richiestaValidator;
	

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "home";
	}
	@RequestMapping(value = {"/richiesta"}, method = RequestMethod.GET)
	public String richiestaContratto(@Valid @ModelAttribute("Richiesta") Richiesta richiesta,Model model,
			BindingResult bindingResult) {
		this.richiestaValidator.validate(richiesta, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.richiestaRepository.save(richiesta);
			return "richiestaInviata";
		}
		else {
			return "richiestaContratto";
		}
	}
	@RequestMapping("/login")
	public String login(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "adminLogin";
}
}
