package com.comtrade.controler;

import java.awt.TextArea;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comtrade.entiteti.Brend;
import com.comtrade.entiteti.Proizvod;
import com.comtrade.servisi.BrendService;
import com.comtrade.servisi.ProizvodServis;

@Controller
public class AdminControler {
	
	private BrendService brendService;
	private ProizvodServis proizvodServis;

	@Autowired
	public AdminControler(BrendService brendService,ProizvodServis proizvodServis) {
		super();
		this.brendService = brendService;
		this.proizvodServis = proizvodServis;
	}
	@GetMapping("/admin")
	public String admin(Model model) {
		Brend brend = new Brend();
		Proizvod proizvod = new Proizvod();
		model.addAttribute("brend", brend);
		model.addAttribute("sviBrendovi", brendService.selectAll());
		model.addAttribute("proizvod",proizvod);
		return "admin";
		
	}
	@PostMapping("/unosBrenda")
	public String unosBrend(Brend brend,@RequestParam("slikaBrenda") File file,@RequestParam("opis") String opis ){
		String putanja = file.getPath();
		brend.setNazivSlike(putanja);
		brendService.save(brend);
		return "redirect:admin";
		
	}
	@DeleteMapping("/brisanjeBrenda")
	public String brisanjeBrenda(@RequestParam("idB") Integer id) {
		brendService.deleteBrend(id);
		
		return "redirect:admin";
		
	}
	
	
}
