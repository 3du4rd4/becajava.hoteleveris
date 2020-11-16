package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class OcupacaoService {

	@Autowired
	private OcupacaoRepository _repository;
	
	
	public BaseResponse inserir(OcupacaoRequest request) {
		
		if (request.getData() == null)
			return new BaseResponse(400, "Data não foi preenchida!");

		if (request.getQtDiarias() == 0 )
			return new BaseResponse(400, "Quantidade de diárias não foi preenchido");
		
		if (request.getSituacao()== "")
			return new BaseResponse(400, "Situação não foi preenchida");

		if (request.getClienteId() == null )
			return new BaseResponse(400, "Cliente não foi preenchido!");
		
		if (request.getQuartoId() == null )
			return new BaseResponse(400, "Quarto não foi preenchido!");

		Cliente cliente = new Cliente(request.getClienteId());
		
		Quarto quarto = new Quarto(request.getQuartoId());
		
		Ocupacao ocupacao = new Ocupacao(
				request.getData(),
				request.getQtDiarias(),
				request.getSituacao(),
				cliente,
				quarto				
				);
				
		_repository.save(ocupacao);
		return new BaseResponse(201, "Ocupação realizada!");
	}
}