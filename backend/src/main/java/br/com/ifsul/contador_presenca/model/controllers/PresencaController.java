package br.com.ifsul.contador_presenca.model.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsul.contador_presenca.model.entities.Presenca;
import br.com.ifsul.contador_presenca.model.repositories.PresencaRepository;

@RestController
@RequestMapping("/presenca")
public class PresencaController {

	@Autowired
	private PresencaRepository presencaRepository;

	@GetMapping
	public Iterable<Presenca> obterPresencas() {
		return presencaRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Presenca> obterPresencaPorId(@PathVariable int id) {
		return presencaRepository.findById(id);
	}
}
