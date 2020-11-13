package br.hoteleveris.app.model;

import javax.persistence.*;

@Entity
public class QuartoComodidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto quartoId;
	
	@ManyToOne
	@JoinColumn(name = "comodidadeId")
	private Comodidade comodidadeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quarto getQuartoId() {
		return quartoId;
	}

	public void setQuartoId(Quarto quartoId) {
		this.quartoId = quartoId;
	}

	public Comodidade getComodidadeId() {
		return comodidadeId;
	}

	public void setComodidadeId(Comodidade comodidadeId) {
		this.comodidadeId = comodidadeId;
	}
	
	
	
}
