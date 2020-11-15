package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

public class TipoQuartoList extends BaseResponse{
	
	private List<TipoQuarto> TipoQuartos;

	public List<TipoQuarto> getTipoQuartos() {
		return TipoQuartos;
	}

	public void setTipoQuartos(List<TipoQuarto> tipoQuartos) {
		TipoQuartos = tipoQuartos;
	}
	
	
}
