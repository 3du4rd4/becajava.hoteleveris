package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class ComodidadeService {

	@Autowired
	private ComodidadeRepository _repository;
	
	public BaseResponse inserir(ComodidadeRequest request) {
		
		if(request.getNome() == "")
		 return new BaseResponse(400, "Preencha a descrição!");
		 
		 Comodidade comodidade = new Comodidade(request.getNome());
		
		 _repository.save(comodidade);
		 return new BaseResponse(400, "Preencha a descrição!");
		 
		
	}
}
