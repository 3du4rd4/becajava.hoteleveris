package br.hoteleveris.app.response;

import java.sql.Date;

public class OcupacaoResponse extends BaseResponse {

	private Long id;
	private Date data;
	private int qtDiarias;
	private String situacao;
	private Long ClienteId;
	private Long QuartoId;

	public OcupacaoResponse() {
	}

	public OcupacaoResponse(int statusCode, String message) {
		super();
		setStatusCode(statusCode);
		setMessage(message);
	}

	public OcupacaoResponse(Long id) {
		super();
		this.id = id;
	}

	public OcupacaoResponse(Date data, int qtDiarias, String situacao, Long clienteId, Long quartoId) {
		super();
		this.data = data;
		this.qtDiarias = qtDiarias;
		this.situacao = situacao;
		ClienteId = clienteId;
		QuartoId = quartoId;
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
