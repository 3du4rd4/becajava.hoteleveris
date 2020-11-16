package br.hoteleveris.app.response;

public class ComodidadeResponse extends BaseResponse {

	private Long id;
	private String nome;

	public ComodidadeResponse() {

	}

	public ComodidadeResponse(int statusCode, String message) {
		super();
		setStatusCode(statusCode);
		setMessage(message);
	}

	public ComodidadeResponse(Long id) {
		super();
		this.id = id;
	}

	public ComodidadeResponse(String nome) {
		super();
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
