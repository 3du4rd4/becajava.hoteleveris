package br.hoteleveris.app.model;

import javax.persistence.*;
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String cpf;
	private String hash;
	
	public Cliente () {
		
	}
	
	public Cliente(Long id) {
		super();
		this.id = id;
	}	
		
	public Cliente(String nome, String cpf, String hash) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.hash = hash;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
