package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.progetto.model.Album;
import it.progetto.model.Foto;
import it.progetto.model.Fotografo;
import it.progetto.services.AlbumService;
import it.progetto.services.AlbumValidator;
import it.progetto.services.FotografoService;
import it.progetto.services.FotografoValidator;

@Controller
public class AdminController {
	
	@Autowired
	private FotografoService fotografoService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private FotografoValidator fotografoValidator;
	@Autowired
	private AlbumValidator albumValidator;
	
	@PostMapping("/album")
	public String newAlbum(@Valid @ModelAttribute("Album") Album album,
			Model model, BindingResult bindingResult) {
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			model.addAttribute("album", this.albumService.tutti());
			return "paginaAdmin.html";
		}else {
			return "addAlbum.html";
		}
	}
	
	@RequestMapping(value = "/fotografo", method = RequestMethod.POST)
	public String newFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo,
			Model model, BindingResult bindingResult) {
		this.fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.fotografoService.inserisci(fotografo);
			model.addAttribute("fotografo", this.fotografoService.tutti());
			return "paginaAdmin.html";
		}else {
			return "addFotografo.html";
		}
	}
	
	@GetMapping("/addFoto")
	public String addFoto(Model model) {
		model.addAttribute("foto", new Foto());
		return "addFoto.html";
	}
	
	@GetMapping("/addFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "addFotografo.html";
	}
	
	@GetMapping("/addAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		return "addAlbum.html";
	}
}