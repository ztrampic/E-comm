package com.comtrade.controler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comtrade.entiteti.*;
import com.comtrade.servisi.KupacServis;
import com.comtrade.servisi.RacunServis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comtrade.servisi.BrendService;
import com.comtrade.servisi.ProizvodServis;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class WebshopControler {
	private BrendService brendServis;
	private ProizvodServis proizvodServis;
	private RacunServis racunServis;
	private KupacServis kupacServis;
	
	@Autowired
	public WebshopControler(BrendService brendServis, ProizvodServis proizvodServis, RacunServis racunServis, KupacServis kupacServis) {
		super();
		this.brendServis = brendServis;
		this.proizvodServis = proizvodServis;
		this.racunServis = racunServis;
		this.kupacServis = kupacServis;
	}




	@GetMapping("/webshop")
	public String webShop(Model model,Racun racun,Brend brend,Proizvod proizvod,Stavke stavke) {
		model.addAttribute("stavke",stavke);
		model.addAttribute("racun", racun);
		model.addAttribute("brend", brend);
		model.addAttribute("proizvod",proizvod);
		model.addAttribute("sviBrendovi", brendServis.selectAll());
		model.addAttribute("sviProizvodi",proizvodServis.selectAll());


		return "webshop";
		
	}
	@PostMapping("/dodavanjeRacuna")
	public String dodavanjeRacuna(Racun racun,Kupac kupac,Model model,Brend brend,Proizvod proizvod,Stavke stavke,
								  @RequestParam("idtrenutnogKorisnika") Integer idKupca)
								  {
		if(idKupca == null){
			return "login";
		}
		if(racun.getKupac() == null){
			racun.setDatum(new Date());
			racun.setBrojracuna(String.valueOf(poslednjiBrRacuna()));
			kupac= kupacServis.findKupacById(idKupca);
			racun.setKupac(kupac);
			racunServis.save(racun); //trenutno //inace blanko prosledjivanje bez id
		}

		model.addAttribute("prijavljeniKorisnik", kupac);
		model.addAttribute("stavke",stavke);
		model.addAttribute("racun", racun);
		model.addAttribute("brend", brend);
		model.addAttribute("proizvod",proizvod);
		model.addAttribute("sviBrendovi", brendServis.selectAll());
		model.addAttribute("sviProizvodi",proizvodServis.selectAll());



		return "webshop";
	}


	@PostMapping("/dodajProizvod")
	public String korpaWebShop(Kupac kupac,Model model,Racun racun,Brend brend,Proizvod proizvod,Stavke stavke,
							               @RequestParam("tfKolicina") Integer kolicina,
							               @RequestParam("idProizvoda") Integer idProizvoda,
	                                       @RequestParam("idtrenutnogKorisnika") Integer idKorisnika){
		if(idKorisnika==null){
			return "login";
		}
		Proizvod p = proizvodServis.findProizvodById(idProizvoda);
		stavke.setProizvod(p);
		stavke.setKolicina(kolicina);
		racun.dodajStavke(stavke);

		model.addAttribute("prijavljeniKorisnik", kupac);
		model.addAttribute("racun", racun);
		model.addAttribute("brend", brend);
		model.addAttribute("proizvod",proizvod);
		model.addAttribute("sviBrendovi", brendServis.selectAll());
		model.addAttribute("sviProizvodi",proizvodServis.selectAll());


		return "webshop";
	}





	public Integer poslednjiBrRacuna(){
		Integer broj =racunServis.nadjiPoslednjiBrRacuna();
		if(broj == null){
			return 1;
		}
		return broj+1;
	}

}
