package com.comtrade.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comtrade.entiteti.Brend;
import com.comtrade.servisi.BrendService;


@Controller
public class IndexControler {

	private BrendService brendServis;
	
	
	@Autowired
	public IndexControler(BrendService brendServis) {
		super();
		this.brendServis = brendServis;
	}
	@GetMapping("/")
	public String vrati(Model model) {
		Brend brend = new Brend();
		model.addAttribute("brend", brend);
		model.addAttribute("sviBrendovi", brendServis.selectAll());
		return "/index";
	}
	
	@GetMapping("/index") 
	public String index() { 
		return "redirect:/";
	  
	}
	 
}
