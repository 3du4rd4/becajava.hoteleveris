package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import br.hoteleveris.app.controller.BaseController;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService extends BaseController{

	@Autowired
	private ComodidadeRepository _repository;
	
	public BaseResponse inserir(ComodidadeRequest request) {
		
		if(request.getNome() == "")
		 return new BaseResponse(400, "Preencha a descrição!");
		 
		 Comodidade comodidade = new Comodidade(request.getNome());
		
		 _repository.save(comodidade);
		 return new BaseResponse(200,"Comodidade inserida!");
			
	}
	

	public ComodidadeResponse obter(Long id) {
		ComodidadeResponse response = new ComodidadeResponse();

		if (id == null) {

			return new ComodidadeResponse(404, "Comodidade não localizado!");
		}

		Optional<Comodidade> comodidades = _repository.findById(id);
		
		response.setId(comodidades.get().getId());
		response.setNome(comodidades.get().getNome());
		response.setStatusCode(200);
		response.setMessage("Comodidade obtido com sucesso!");

		return response;
	}

}
