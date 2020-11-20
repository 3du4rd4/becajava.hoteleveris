package br.hoteleveris.app.service;

import br.hoteleveris.app.request.QuartoList;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;

public interface QuartoService {

	BaseResponse inserir(QuartoRequest request);
	
	QuartoResponse obter(int noQuarto);
	
	QuartoList obterPorTipo(Long tipoQuartoId);
	
	QuartoList listar();
	
	BaseResponse atualizar(Long id, SituacaoRequest request);


}