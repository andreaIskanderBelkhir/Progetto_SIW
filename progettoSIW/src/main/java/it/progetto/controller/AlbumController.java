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
import it.progetto.services.AlbumService;
import it.progetto.services.AlbumValidator;
@Controller
public class AlbumController {
	@Autowired
	private AlbumValidator albumvalidator;
	@Autowired
	private AlbumService albumservice;
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newFotografo(@Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult) {
		this.albumvalidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumservice.inserisci(album);
			model.addAttribute("fotografo", this.albumservice.tutti());
			return "paginaAdmin.html";
		}else {
			return "addFotografo.html";
		}
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getStudente(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("album", this.albumservice.albumPerId(id));
			return "album.html";
		}else {
			return "paginaAdmin.html";
		}
	}
	
	@RequestMapping("/addAlbum")
	public String addFotografo(Model model) {
		model.addAttribute("album", new Album());
		return "addAlbum.html";
	}

}
