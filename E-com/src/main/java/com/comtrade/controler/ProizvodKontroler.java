package com.comtrade.controler;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comtrade.entiteti.Brend;
import com.comtrade.entiteti.Proizvod;
import com.comtrade.servisi.BrendService;
import com.comtrade.servisi.ProizvodServis;

@Controller
public class ProizvodKontroler {
	
	private BrendService brendService;
	private ProizvodServis proizvodServis;
	
	@Autowired
	public ProizvodKontroler(BrendService brendService, ProizvodServis proizvodServis) {
		super();
		this.brendService = brendService;
		this.proizvodServis = proizvodServis;
	}
	@PostMapping("/unosProizvoda")
	public String unosProizvoda(@RequestParam("id_brand") int id,Proizvod proizvod,@RequestParam("slika") File file) {
		String putanja = file.getPath();
		proizvod.setNazivSlike(putanja);
		Brend b = new Brend();
		b.setId_brand(id);
		proizvod.setBrend(b);
		proizvodServis.save(proizvod);
		return "redirect:admin";
		
	}
	@GetMapping("/proizvodiBrenda/{brendId}")
	public String vratiSveProizvodeBrenda(@PathVariable("brendId") int brendId,Model model){
		
		  List<Proizvod> lista = proizvodServis.sviProizvodiZaIdBrenda(brendId);
		  model.addAttribute("listaProizvodaBrenda", lista);
		  model.addAttribute("sviBrendovi", brendService.selectAll());
		  model.addAttribute("brend", brendService.findBrendById(brendId));
		 
		return "listaProizvodaBrenda";
		
	}
	
	
	
}
