package br.hoteleveris.app.request;

import java.sql.Date;

public class OcupacaoRequest {

	private Date data;
	private int qtDiarias;
	private String situacao = "N" ;
	private Long ClienteId;
	private Long QuartoId;
	
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
	public Long getClienteId() {
		return ClienteId;
	}
	public void setClienteId(Long clienteId) {
		ClienteId = clienteId;
	}
	public Long getQuartoId() {
		return QuartoId;
	}
	public void setQuartoId(Long quartoId) {
		QuartoId = quartoId;
	}
	
	
	
}
