package com.comtrade.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comtrade.entiteti.Kupac;

@Controller
public class LoginControler {
	@GetMapping("/login")
	public String login(Model model) {
		Kupac kupac = new Kupac();
		model.addAttribute("kupac", kupac);
		return "login";
		
	}
}
