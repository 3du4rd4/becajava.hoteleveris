package br.hoteleveris.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.TipoQuarto;

public interface ComodidadeRepository extends JpaRepository<Comodidade, Long>{
	
	Optional<Comodidade> findById(Long id);
}
