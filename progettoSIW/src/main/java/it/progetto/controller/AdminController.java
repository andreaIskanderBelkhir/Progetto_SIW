package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.progetto.model.Album;
import it.progetto.model.Foto;
import it.progetto.model.Fotografo;
import it.progetto.services.AlbumService;
import it.progetto.services.FotoService;
import it.progetto.services.FotografoService;

@Controller
public class AdminController {
	@Autowired
	private FotoService fotoService;
	@Autowired
	private FotografoService fotografoservice;
	@Autowired
	private AlbumService albumservice;
	
	@PostMapping("/foto")
	public String newFoto(@Valid @ModelAttribute("Foto") Foto foto,
			Model model, BindingResult bindingResult) {
		this.fotoService.inserisci(foto);
		return "paginaAdmin.html";
	}
	@PostMapping("/album")
	public String newAlbum(@Valid @ModelAttribute("Album") Album album,
			Model model, BindingResult bindingResult) {
		this.albumservice.inserisci(album);
		return "paginaAdmin.html";
	}
	@PostMapping("/fotografo")
	public String newFotografo(@Valid @ModelAttribute("Fotografo") Fotografo fotografo,
			Model model, BindingResult bindingResult) {
		this.fotografoservice.inserisci(fotografo);
		return "paginaAdmin.html";
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