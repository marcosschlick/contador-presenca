package br.com.ifsul.contador_presenca.model.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifsul.contador_presenca.model.entities.Presenca;
import br.com.ifsul.contador_presenca.model.entities.Usuario;
import br.com.ifsul.contador_presenca.model.repositories.PresencaRepository;
import br.com.ifsul.contador_presenca.model.repositories.UsuarioRepository;

@Service
public class PresencaService {

	@Autowired
	private PresencaRepository presencaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public String registrarEntrada(String documento) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByDocumento(documento);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			Presenca presenca = new Presenca();
			presenca.setUsuario(usuario);
			presenca.setDataEntrada(LocalDate.now());
			presenca.setHorarioEntrada(LocalTime.now());

			presencaRepository.save(presenca);

			return "Presença registrada com sucesso para o usuário: " + usuario.getNome();
		} else {
			return "Usuário com o documento " + documento + " não encontrado.";
		}
	}

	public String registrarSaida(String documento) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByDocumento(documento);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();

			Optional<Presenca> presencaOptional = presencaRepository.findTopByUsuarioIdOrderByIdDesc(usuario.getId());

			if (presencaOptional.isPresent()) {
				Presenca presenca = presencaOptional.get();

				if (presenca.getDataSaida() == null && presenca.getHorarioSaida() == null) {
					presenca.setDataSaida(LocalDate.now());
					presenca.setHorarioSaida(LocalTime.now());

					presencaRepository.save(presenca);

					return "Saída registrada com sucesso para o usuário: " + usuario.getNome();
				} else {
					return "O usuário já tem um registro de saída.";
				}
			} else {
				return "Não há registro de entrada para o usuário: " + usuario.getNome();
			}
		} else {
			return "Usuário com o documento " + documento + " não encontrado.";
		}
	}
}
