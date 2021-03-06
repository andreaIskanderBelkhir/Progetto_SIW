package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/foto", method = RequestMethod.POST)
	public String newFoto(@Valid @ModelAttribute("Foto") Foto foto,
			Model model, BindingResult bindingResult) {
		this.fotoService.inserisci(foto);
		return "paginaAdmin.html";
	}
	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("Album") Album album,
			Model model, BindingResult bindingResult) {
		this.albumservice.inserisci(album);
		return "paginaAdmin.html";
	}
	@RequestMapping(value = "/fotografo", method = RequestMethod.POST)
	public String newFotografo(@Valid @ModelAttribute("Fotografo") Fotografo fotografo,
			Model model, BindingResult bindingResult) {
		this.fotografoservice.inserisci(fotografo);
		return "paginaAdmin.html";
	}
}