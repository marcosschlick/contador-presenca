package br.com.ifsul.contador_presenca.model.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsul.contador_presenca.model.entities.Usuario;
import br.com.ifsul.contador_presenca.model.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public Iterable<Usuario> obterProdutos() {
		return usuarioRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Usuario> obterProdutoPorId(@PathVariable int id) {
		return usuarioRepository.findById(id);
	}
}
