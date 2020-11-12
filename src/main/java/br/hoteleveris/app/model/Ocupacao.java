package br.hoteleveris.app.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Ocupacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data;
	private int qtDiarias;
	private String situacao;
	
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente clienteId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQtDiarias() {
		return qtDiarias;
	}

	public void setQtDiarias(int qtDiarias) {
		this.qtDiarias = qtDiarias;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	


}
