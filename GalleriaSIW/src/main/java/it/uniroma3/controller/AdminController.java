package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.modello.Amministratore;
import it.uniroma3.service.AmministratoreService;

@Controller
public class AdminController {
	
	@Autowired
	private AmministratoreService admService;
	

	@GetMapping(value="/registrati")
	public String getPaginaRegistrazione(Model model) {
		Amministratore daCreare = new Amministratore();
		model.addAttribute(daCreare);
		return "registrazioneAdmin";
	}
	
	@PostMapping(value="/registrati")
	public String registraAdmin(@Valid @ModelAttribute Amministratore admin, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "registrazioneAdmin";
		}
			if (admService.cercaAmministratorePerEmail(admin.getEmail()) == null && admService.cercaPerUsername(admin.getUsername()) == null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = passwordEncoder.encode(admin.getPassword());
			admin.setPassword(password);
			admService.inserisciAmministratore(admin);
			model.addAttribute(admin);
			return "/index";
			}
	return "registrazioneAdmin";
		
	}

	@GetMapping(value ="/operazioniAdmin")
	public String getPaginaOperazioni() {
		return "operazioniAdmin";
	}
}