package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.modello.Autore;
import it.uniroma3.modello.Opera;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.OperaService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private OperaService operaService;
	
	@GetMapping("/dettagliAutore")
	public String getPaginaAutore(@ModelAttribute("id") Long id, BindingResult errors,Model model) {
		if(errors.hasErrors()) {return "dettagliOpera";}
		Autore cercato = autoreService.cercaAutore(id);
		model.addAttribute("autore", cercato);
		model.addAttribute("opereAutore",cercato.getOpere());
		return "dettagliAutore";
	}
	
	@GetMapping("/inserisciAutore")
	public String getPaginaInserimentoAutore(Model model) {
		model.addAttribute("autore",new Autore());
		return "inserimentoAutore";
	}
	
	@PostMapping("/inserisciAutore")
	public String inserisciNuovoAutore(@Valid @ModelAttribute Autore daInserire, BindingResult errors,Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("inserimentoErr","Ricontrolla i campi");
			return "inserimentoAutore";
		}
		autoreService.inserisciAutore(daInserire);
		model.addAttribute("messaggioDiSuccesso","Autore inserito correttamente");
		return "index";
	}
	
	@GetMapping("/cercaAutore")
	public String getPaginaRicercaAutore() {
		return "ricercaAutore";
	}
	
	@GetMapping("/cancellaAutore")
	public String cancellaAutore(@ModelAttribute("id") Long id, Model model) {
		autoreService.cancellaAutore(autoreService.cercaAutore(id));
		model.addAttribute("autori",autoreService.cercaAutori());
		return "listaAutori";
	}
	
	@PostMapping("/ricercaAutore")
	public String cercaAutore(@RequestParam(value="attributo") String attributo,@RequestParam(value="valore") String valore, Model model) {
		List<Autore> autoriCercati = new ArrayList<Autore>();
		switch(attributo) {
		
			case "Nome": 
				autoriCercati = autoreService.cercaPerNome(valore);
				break;
				
			case "Cognome":
				autoriCercati = autoreService.cercaPerCognome(valore);
				break;
				
			case "TitoloOpera":
				for (Opera opera :operaService.cercaPerTitolo(valore) ) 
					autoriCercati.add(opera.getAutore());
				break;
			
			default: 
				model.addAttribute("erroreRicerca","Ricontrolla i campi e riprova"); return "ricercaAutore";
		}
		model.addAttribute("autori",autoriCercati);
		return "listaAutori";
	}
	
	@GetMapping ("/listaAutori")
	public String getPaginaAutori(Model model) {
		model.addAttribute("autori",autoreService.cercaAutori());
		return "listaAutori";
	}

}
