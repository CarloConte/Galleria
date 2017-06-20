package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.uniroma3.modello.Opera;
import it.uniroma3.service.OperaService;

@Controller
public class IndexController {

	@GetMapping(value ="/")
	public String getIndex() {
		return "index";
	}

	
	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "login";
	}

}
