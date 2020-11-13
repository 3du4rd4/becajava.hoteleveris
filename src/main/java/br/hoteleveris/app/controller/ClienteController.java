package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {
	final ClienteService _service;
	
	@Autowired
	public ClienteController(ClienteService service) {
		_service = service;
	}
	
	@PostMapping
	public ResponseEntity<BaseResponse> inserir(@RequestBody ClienteRequest clienteRequest) {
		BaseResponse response = _service.inserir(clienteRequest);
		try {
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e){
			return ResponseEntity.status(errorBase.StatusCode).body(response);
			
		}
	}
}
