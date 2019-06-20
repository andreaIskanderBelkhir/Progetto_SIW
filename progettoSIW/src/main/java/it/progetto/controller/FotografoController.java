package it.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.progetto.services.FotografoService;

public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;
	
	@RequestMapping(value = "/fotografo/{id}", method = RequestMethod.GET)
	public String getFotografo(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("fotografo", this.fotografoService.fotografoPerId(id));
			return "fotografo.html";
		}else {
			model.addAttribute("fotografi", this.fotografoService.tutti());
			return "fotografi.html";
		}
	}
	
	@RequestMapping("/fotografi")
	public String getFotografi(Model model) {
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi.html";
	}

}
