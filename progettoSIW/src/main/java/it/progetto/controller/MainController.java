package it.progetto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.progetto.model.Album;
import it.progetto.model.Carrello;
import it.progetto.model.Foto;
import it.progetto.model.Fotografo;
import it.progetto.model.Richiesta;
import it.progetto.repository.FotografoRepository;
import it.progetto.repository.RichiestaRepository;
import it.progetto.services.AlbumService;
import it.progetto.services.AlbumValidator;
import it.progetto.services.FotoService;
import it.progetto.services.FotoValidator;
import it.progetto.services.FotografoService;
import it.progetto.services.FotografoValidator;
import it.progetto.services.RichiestaValidator;

@Controller
public class MainController {

	@Autowired
	private RichiestaRepository richiestaRepository;

	@Autowired
	private FotografoRepository fotografoRepository;

	@Autowired
	private RichiestaValidator richiestaValidator;

	@Autowired
	private FotografoValidator fotografoValidator;

	@Autowired
	private FotoValidator fotoValidator;

	@Autowired
	private AlbumValidator albumValidator;

	@Autowired
	private AlbumService albumServices;

	@Autowired
	private FotoService fotoServices;
	
	private static Carrello carrello = new Carrello();
	
	@GetMapping("/")
	@PostMapping("/")
	public String index(Model model) {
		return "home.html";
	}

	@GetMapping("/presentazione")
	@PostMapping("/presentazione")
	public String presentazione(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		model.addAttribute("foto", new Foto());
		model.addAttribute("album", new Album());
		model.addAttribute("carrello", carrello);
		return "presentazione.html";
	}


	@GetMapping("/paginaAdmin")
	@PostMapping("/paginaAdmin")
	public String admin(Model model) {
		UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String role = details.getAuthorities().iterator().next().getAuthority();    // get first authority
		model.addAttribute("username", details.getUsername());
		model.addAttribute("role", role);

		return "paginaAdmin.html";
	}

	@PostMapping("/richiesta")
	public String richiestaContratto(@Valid @ModelAttribute Richiesta richiesta,Model model,
			BindingResult bindingResult) {
		this.richiestaValidator.validate(richiesta, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.richiestaRepository.save(richiesta);
			return "richiestaInviata.html";
		}
		else {
			return "richiestaContratto.html";
		}
	}

	@PostMapping("/fotografoVisualizza")
	public String fotografo(@Valid @ModelAttribute Fotografo fotografo,BindingResult bindingResult,Model model) {
		this.fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
			model.addAttribute("fotografo", this.fotografoRepository.findByNomeAndCognome(fotografo.getNome(), fotografo.getCognome()));
			return "fotografo.html";
		}
		else
			return "presentazione.html";
	}

	@PostMapping("/albumVisualizza")
	public String album(@Valid @ModelAttribute Album album ,BindingResult bindingResult,Model model) {
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			model.addAttribute("album", this.albumServices.albumPerNome(album.getNome()));
			return "album.html";
		}
		else {
			return "presentazione.html";
		}
	}
	
	@PostMapping("/fotoVisualizza")
	public String foto(@Valid @ModelAttribute Foto foto ,BindingResult bindingResult,Model model) {
		this.fotoValidator.validate(foto, bindingResult);
		if(!bindingResult.hasErrors()) {
			model.addAttribute("foto", this.fotoServices.fotoPerNome(foto.getNome()));
			return "foto.html";
		}
		else {
			return "presentazione.html";
		}
	}
	
	@RequestMapping(value="/foto/{id}",method=RequestMethod.GET)
	public String aggiungiFoto(@PathVariable("id") Long id,Model model) {
		if(id!=null && !carrello.getFoto().contains(this.fotoServices.fotoPerId(id))) {
		carrello.getFoto().add(this.fotoServices.fotoPerId(id));
		model.addAttribute("carrello", carrello);
		}
		return "presentazione.html";
	}
	
	@GetMapping("/richiestaContratto")
	public String richiestaContratto(Model model) {
		model.addAttribute("richiesta", new Richiesta());
		return "richiestaContratto.html";
	}
}
