package com.comtrade.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.comtrade.entiteti.Kupac;
import com.comtrade.servisi.KupacRgistracijaServis;

@Controller
public class KupacControler {
	
	private KupacRgistracijaServis kupacRgistracijaServis;
	
	
	@Autowired
	public KupacControler(KupacRgistracijaServis kupacRgistracijaServis) {
		super();
		this.kupacRgistracijaServis = kupacRgistracijaServis;
	}


	@PostMapping("/kupac/registracija")
	public String registracija(@Valid @ModelAttribute Kupac kupac, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "login";
		}
		
		kupacRgistracijaServis.save(kupac);
		return "login";
		
	}
}
