package br.com.ifsul.contador_presenca.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ifsul.contador_presenca.model.entities.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Integer> {

}