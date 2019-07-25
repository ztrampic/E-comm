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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String dodavanjeRacuna(Racun racun,Kupac kupac,Model model,Brend brend,Proizvod proizvod,Stavke stavke,HttpServletRequest request, HttpServletResponse response,
								  @RequestParam("idtrenutnogKorisnika") Integer idKupca)
								  {
		if(idKupca == null){
			return "login";
		}
		HttpSession session = request.getSession();
		if(racun.getKupac() == null){
			racun = (Racun) session.getAttribute("racun");
			racun.setDatum(new Date());
			racun.setBrojracuna(String.valueOf(poslednjiBrRacuna()));
			kupac= (Kupac) session.getAttribute("ulogovanKorisnik");
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
	public String korpaWebShop(Kupac kup,Model model,HttpServletRequest request, HttpServletResponse response,
							   @RequestParam("tfKolicina") Integer kolicina,
							   @RequestParam("idProizvoda") Integer idProizvoda,
							   @RequestParam("idtrenutnogKorisnika") Integer idKorisnika){

		Brend brend = new Brend();
		Proizvod proizvod = new Proizvod();
		Stavke stavke = new Stavke();

		if(idKorisnika==null){
			return "login";
		}
		HttpSession session = request.getSession();
		Racun racun = (Racun) session.getAttribute("racun");
		Kupac kupac = (Kupac) session.getAttribute("ulogovanKorisnik");
		Proizvod p = proizvodServis.findProizvodById(idProizvoda);
		stavke.setProizvod(p);
		stavke.setKolicina(kolicina);
		stavke.setBrStavke(brojStavke(session));
		racun.dodajStavke(stavke);

		session.setAttribute("racun",racun);
		session.setAttribute("ulogovanKorisnik", kupac);

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
	public Integer brojStavke(HttpSession session){
		Integer brojStavke = 1;
		Racun racun= (Racun) session.getAttribute("racun");
		List<Stavke>list=racun.getListaStavki();
		if(list.isEmpty()){
			return brojStavke;
		}


		return brojStavke+list.size();
	}
}
