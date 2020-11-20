package br.hoteleveris.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;
import br.hoteleveris.app.service.ComodidadeService;


@RestController
@RequestMapping("/comodidades")
public class ComodidadeController extends BaseController {
	
	@Autowired
	private ComodidadeService _service;
	
	@PostMapping
	public ResponseEntity inserir(@RequestBody ComodidadeRequest request) {
		
		try {
			BaseResponse response = _service.inserir(request);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);
		}
	}
		@GetMapping(path = "/{id}")
		public ResponseEntity obter(@PathVariable Long id) {

			try {
				ComodidadeResponse comodidade = _service.obter(id);

				return ResponseEntity.status(200).body(comodidade);

			} catch (Exception e) {
				return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);

			}

		}
}
