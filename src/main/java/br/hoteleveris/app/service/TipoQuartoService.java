package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {
	@Autowired
	private TipoQuartoRepository _repository;
	
	public BaseResponse inserir(TipoQuartoRequest request) {
		
		if (request.getDescricao() == "") 
			return new BaseResponse(400, "Preencha a descrição!");
		if (request.getValor() == 0)
			return new BaseResponse(400, "Preencha o valor!");
		
		TipoQuarto tipoQuarto = new TipoQuarto(
				request.getDescricao(),
				request.getValor()
				);
			
		_repository.save(tipoQuarto);		
		return new BaseResponse(201, "Quarto cadastrado com sucesso") ;
	}
	
	public TipoQuartoResponse obter(Long id) {
		TipoQuartoResponse response = new TipoQuartoResponse();
		
		if(id == null)
			return new TipoQuartoResponse(400, "Este quarto não existe!");
		
		Optional<TipoQuarto> quarto = _repository.findById(id);
		response.setId(quarto.get().getId());
		response.setDescricao(quarto.get().getDescricao());
		response.setValor(quarto.get().getValor());
		response.setStatusCode(200);
		response.setMessage("Quarto obtido com sucesso!");
		
		return response;
		}
	
	public TipoQuartoList listar() {
		
		List<TipoQuarto> tipoQuartos = _repository.findAll();
		
		TipoQuartoList response = new TipoQuartoList();
		response.setTipoQuartos(tipoQuartos);
		response.setStatusCode(200);
		response.setMessage("Listagem completa de Quartos!");
		
		return response;
		
	}


	
	
}