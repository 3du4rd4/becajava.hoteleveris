package br.hoteleveris.app.service;

import br.hoteleveris.app.request.OcupacaoList;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

public interface OcupacaoService {
	
	BaseResponse inserir(OcupacaoRequest request);
	
	OcupacaoList listar();
}
