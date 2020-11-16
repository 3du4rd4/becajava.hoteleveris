package br.hoteleveris.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.QuartoComodidade;

@Repository
public interface QuartoComodidadeRepository extends JpaRepository<QuartoComodidade,Long> {

}