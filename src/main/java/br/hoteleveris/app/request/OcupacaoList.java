package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.response.OcupacaoResponse;

public class OcupacaoList {

	private List<OcupacaoResponse> Ocupacoes;

	public List<OcupacaoResponse> getOcupacoes() {
		return Ocupacoes;
	}

	public void setOcupacoes(List<OcupacaoResponse> ocupacoes) {
		Ocupacoes = ocupacoes;
	}
}