package com.comtrade.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comtrade.entiteti.Brend;
import com.comtrade.entiteti.Proizvod;
import com.comtrade.servisi.BrendService;
import com.comtrade.servisi.ProizvodServis;

@Controller
public class WebshopControler {
	private BrendService brendServis;
	private ProizvodServis proizvodServis;
	
	
	@Autowired
	public WebshopControler(BrendService brendServis, ProizvodServis proizvodServis) {
		super();
		this.brendServis = brendServis;
		this.proizvodServis = proizvodServis;
	}




	@GetMapping("/webshop")
	public String webShop(Model model) {
		Brend brend = new Brend();
		Proizvod proizvod = new Proizvod();
		model.addAttribute("brend", brend);
		model.addAttribute("proizvod",proizvod);
		model.addAttribute("sviBrendovi", brendServis.selectAll());
		model.addAttribute("sviProizvodi",proizvodServis.selectAll());
		return "webshop";
		
	}
}
