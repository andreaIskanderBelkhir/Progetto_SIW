package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.progetto.model.Album;
import it.progetto.model.Foto;
import it.progetto.services.FotoService;
import it.progetto.services.FotografoValidator;
@Controller
public class FotoController {
	@Autowired
	private FotoService fotoservice;
	@Autowired
	private FotografoValidator fotovalidator;
	
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newFoto(@Valid @ModelAttribute("foto") Foto foto,
			Model model, BindingResult bindingResult) {
		this.fotovalidator.validate(foto, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotoservice.inserisci(foto);
			model.addAttribute("foto", this.fotoservice.tutti());
			return "paginaAdmin.html";
		}else {
			return "addFoto.html";
		}
	}
	
	@RequestMapping(value = "/foto/{id}", method = RequestMethod.GET)
	public String getFoto(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("foto", this.fotoservice.fotoPerId(id));
			return "foto.html";
		}else {
			return "paginaAdmin.html";
		}
	}
	
	@RequestMapping("/addAdmin")
	public String addFoto(Model model) {
		model.addAttribute("foto", new Foto());
		return "addFoto.html";
	}
	
}
