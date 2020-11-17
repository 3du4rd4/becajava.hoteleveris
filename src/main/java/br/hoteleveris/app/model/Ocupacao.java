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
	private String situacao = "N";
		
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto quarto;

	public Ocupacao() {
	}

	public Ocupacao(Long id) {
		super();
		this.id = id;
	}

	public Ocupacao(Date data, int qtDiarias, String situacao, Cliente cliente, Quarto quarto) {
		super();
		this.data = data;
		this.qtDiarias = qtDiarias;
		this.situacao = situacao;
		this.cliente = cliente;
		this.quarto = quarto;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}


}
