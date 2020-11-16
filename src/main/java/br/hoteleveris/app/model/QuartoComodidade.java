package br.hoteleveris.app.model;

import javax.persistence.*;

@Entity
public class QuartoComodidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto quarto;
	
	@ManyToOne
	@JoinColumn(name = "comodidadeId")
	private Comodidade comodidade;
	
	public QuartoComodidade() {
		
	}	
	
	public QuartoComodidade(Long id) {
		super();
		this.id = id;
	}


	public QuartoComodidade(Quarto quarto, Comodidade comodidade) {
		this.quarto = quarto;
		this.comodidade = comodidade;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Comodidade getComodidade() {
		return comodidade;
	}

	public void setComodidade(Comodidade comodidade) {
		this.comodidade = comodidade;
	}

	
	
	
}
