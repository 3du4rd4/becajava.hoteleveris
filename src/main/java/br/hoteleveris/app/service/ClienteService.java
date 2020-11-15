package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository _repository;


	public BaseResponse inserir(ClienteRequest request) {

		if (request.getNome() == "")
			return new BaseResponse(400, "Nome não foi preenchido!");

		if (request.getCpf() == "")
			return new BaseResponse(400, "CPF não foi preenchido");

		if (request.getHash() == "")
			return new BaseResponse(400, "Hash não foi preenchida!");

		Cliente cliente = new Cliente(request.getNome(), request.getCpf(), request.getHash());

		_repository.save(cliente);
		return new BaseResponse(201, "Novo cliente salvo com sucesso!");

	}

	public ClienteResponse obter(Long id) {
		ClienteResponse response = new ClienteResponse();

		if (id == null) {

			return new ClienteResponse(404, "Cliente não localizado!");
		}

		Optional<Cliente> cliente = _repository.findById(id);
		
		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		response.setStatusCode(200);
		response.setMessage("Cliente obtido com sucesso!");

		return response;
	}
}
