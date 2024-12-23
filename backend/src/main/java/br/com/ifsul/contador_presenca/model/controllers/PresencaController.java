package br.com.ifsul.contador_presenca.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsul.contador_presenca.model.entities.Presenca;
import br.com.ifsul.contador_presenca.model.repositories.PresencaRepository;
import br.com.ifsul.contador_presenca.model.services.PresencaService;

@RestController
@RequestMapping("/presenca")
@CrossOrigin(origins = "http://localhost:5500")
public class PresencaController {

	@Autowired
	private PresencaRepository presencaRepository;

	@Autowired
	private PresencaService presencaService;

	@GetMapping
	public Iterable<Presenca> obterPresencas() {
		return presencaRepository.findAll();
	}

	@PostMapping(path = "/registrar/{documento}")
	public String registrarEntrada(@PathVariable String documento) {
		return presencaService.registrarEntrada(documento);
	}

	@PutMapping(path = "/registrar_saida/{documento}")
	public String registrarSaida(@PathVariable String documento) {
		return presencaService.registrarSaida(documento);
	}

}
