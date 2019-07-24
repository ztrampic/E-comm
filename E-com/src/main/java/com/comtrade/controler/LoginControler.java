package com.comtrade.controler;

import com.comtrade.entiteti.*;
import com.comtrade.servisi.BrendService;
import com.comtrade.servisi.KupacLoginServis;
import com.comtrade.servisi.ProizvodServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginControler {

	private KupacLoginServis kupacLoginServis;
	private BrendService brendService;
	private ProizvodServis proizvodServis;

	@Autowired
	public LoginControler(KupacLoginServis kupacLoginServis,BrendService brendService,ProizvodServis proizvodServis) {
		this.kupacLoginServis = kupacLoginServis;
		this.brendService = brendService;
		this.proizvodServis = proizvodServis;
	}

	@GetMapping("/login")
	public String login(Model model) {
		Kupac kupac = new Kupac();
		model.addAttribute("kupac", kupac);
		return "login";
		
	}
	@PostMapping("/tryLogin")
	public String tryLogin(Kupac kupac, Model model, Racun racun, Brend brend, Proizvod proizvod, Stavke stavke,
						   @RequestParam("email") String email, @RequestParam("password") String pass){
		Kupac k = new Kupac();
		k.setEmail(email);
		k.setPassword(pass);
		kupac = kupacLoginServis.tryLogin(k);
		if(kupac == null){
			return "redirect:login";
		}
		model.addAttribute("prijavljeniKorisnik",kupac);
		model.addAttribute("brend", brend);
		model.addAttribute("proizvod",proizvod);
		model.addAttribute("sviBrendovi", brendService.selectAll());
		model.addAttribute("sviProizvodi",proizvodServis.selectAll());

		return "webshop";
	}

}
