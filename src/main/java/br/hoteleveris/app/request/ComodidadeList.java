package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.response.BaseResponse;

public class ComodidadeList extends BaseResponse{

	private List<Comodidade> Comdidades;

	public List<Comodidade> getComdidades() {
		return Comdidades;
	}

	public void setComdidades(List<Comodidade> comdidades) {
		Comdidades = comdidades;
	}
	
	
}
