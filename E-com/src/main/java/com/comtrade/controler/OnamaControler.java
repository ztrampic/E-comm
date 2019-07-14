package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comtrade.entiteti.Brend;
import com.comtrade.servisi.BrendService;
import com.comtrade.servisi.ProizvodServis;

@Controller
public class OnamaControler {
	
	private BrendService brendServis;
	private ProizvodServis proizvodServis;
	
	
	@Autowired
	public OnamaControler(BrendService brendServis, ProizvodServis proizvodServis) {
		super();
		this.brendServis = brendServis;
		this.proizvodServis = proizvodServis;
	}
	
	@GetMapping("/onama")
	public String oNama(Model model) {
		Brend brend = new Brend();
		model.addAttribute("brend", brend);
		model.addAttribute("sviBrendovi", brendServis.selectAll());
		return "onama";
		
	}
}
