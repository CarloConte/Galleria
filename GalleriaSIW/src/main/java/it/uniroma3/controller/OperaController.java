package it.uniroma3.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.modello.Autore;
import it.uniroma3.modello.Opera;
import it.uniroma3.repositories.OperaRepository;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping(value = "/listaOpere")
	public String paintingList(Model model) {
		List<Opera> opere = operaService.cercaOpere();
		model.addAttribute("opere",opere);
		return "paintingList";
	}


	@GetMapping(value = "/dettagliOpera")
	public String paintingList(@ModelAttribute("id") Long id,BindingResult errori,Model model) {
		if (errori.hasErrors()) {
			return "index";
		}
		Opera daVisualizzare = operaService.cercaOpera(id);
		model.addAttribute("opera",daVisualizzare);
		return "dettagliOpera";
	}
	

	@PostMapping(value="/inserisciOpera")
	public String inserisciNuovaOpera(Model model,@Valid @ModelAttribute Opera daInserire, BindingResult errors,@RequestParam(value="autore") Long id) {
		if(errors.hasErrors()) {
			model.addAttribute("inserimentoErr","Form non compilata correttamente");
			model.addAttribute(autoreService.cercaAutori());
			return "inserimentoOpera";
			}
	Autore autore = autoreService.cercaAutore(id);
	daInserire.setAutore(autore);
	operaService.aggiungiOpera(daInserire);
	model.addAttribute("messaggioDiSuccesso","Opera inserita correttamente");
	return "index";
	
	}
	
	@GetMapping(value = "/inserisciOpera")
	public String getPaginaInserimentoOpera(Model model) {
		Opera daInserire = new Opera();
		List<Autore> autori = autoreService.cercaAutori();
		model.addAttribute("autori",autori);
		model.addAttribute("opera",daInserire);
		return "inserimentoOpera";
	}
	
	@GetMapping(value = "/cancellaOpera")
	public String cancellaOpera(@ModelAttribute("id") Long id,Model model) {
		operaService.cancellaOpera(id);
		model.addAttribute("opere",operaService.cercaOpere());
		return "paintingList";
	}
	
	@GetMapping(value = "/cercaOpere")
	public String getPaginaRicercaOpere() {
		return "ricercaOpere";
	}
	
	
	@PostMapping(value = "/ricercaOpere")
	public String ricercaOpere(@RequestParam(value = "attributo") String attributo, @RequestParam(value = "valore") String valore,Model model)  {
		List<Opera> opereCercate = new ArrayList<Opera>();
		
		switch(attributo) {
	
			case "Titolo": opereCercate = operaService.cercaPerTitolo(valore);break;
		
			case "Tecnica": opereCercate = operaService.cercaPerTecnica(valore);break;
		
			case "Dimensioni":opereCercate =  operaService.cercaPerDimensioni(valore);break;
		
			case "Anno": opereCercate = operaService.cercaPerAnno(Integer.parseInt(valore));break;
		
			case "Autore":
				model.addAttribute("autori", autoreService.cercaPerNome(valore));
				return "listaAutori";		
			
			default: model.addAttribute("erroreRicerca","Ricontrolla i campi e riprova"); return "ricercaOpere";
		
		}
		
		model.addAttribute("opere",opereCercate);
		return "paintingList";
	}
}

