package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.OcupacaoService;

@RestController
@RequestMapping("/ocupacao")
public class OcupacaoController extends BaseController  {
	
	@Autowired
	private OcupacaoService _service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody OcupacaoRequest request) {

		try {
			BaseResponse response = _service.inserir(request);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);

		}
	}
}
