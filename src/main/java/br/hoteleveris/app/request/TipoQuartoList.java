package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

public class TipoQuartoList extends BaseResponse{
	
	private List<TipoQuartoResponse> TipoQuarto;

	public List<TipoQuartoResponse> getTipoQuarto() {
		return TipoQuarto;
	}

	public void setTipoQuarto(List<TipoQuartoResponse> tipoQuarto) {
		TipoQuarto = tipoQuarto;
	}
	
	
}
