package br.hoteleveris.app.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Comodidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Comodidade() {
		
	}
	
	public Comodidade(Long id) {
		this.id = id;
	}	
	
	public Comodidade(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
	
}
