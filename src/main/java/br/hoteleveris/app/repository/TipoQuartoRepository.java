package br.hoteleveris.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.hoteleveris.app.model.TipoQuarto;

public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Long>{
	Optional<TipoQuarto> findById(Long Id);
		
}
