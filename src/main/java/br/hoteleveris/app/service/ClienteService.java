package br.hoteleveris.app.service;


import java.util.Optional;

import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService {
	
	final ClienteRepository _repository;
	 
	private ClienteService(ClienteRepository repository) {
		_repository = repository;
	}	
	
	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente(); 
		BaseResponse base = new BaseResponse();
		
		
		if (clienteRequest.getNome() == "") {
			base.Message = "Nome não foi preenchido!";
			base.StatusCode = 400;
			return base;
			
		}
		if (clienteRequest.getCpf() =="") {
			base.Message = "CPF não foi preenchido";
			base.StatusCode = 400;
			return base;			
		}
		if (clienteRequest.getHash() == "") {
			base.Message = "Hash não foi preenchida!";
			base.StatusCode = 400;
			return base;
		}
		
		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setHash(clienteRequest.getHash());

		_repository.save(cliente);
		base.StatusCode = 201;
		base.Message = "Novo cliente salvo com sucesso!";
		return base;				
				
	}
	
	//obter
	public ClienteResponse obter(Long id) {
		
		Optional<Cliente> listaCliente = _repository.findById(id);
		ClienteResponse response = new ClienteResponse();
			
		if (id == null) {
			response.Message = "Cliente não localizado!";
			response.StatusCode = 404;
			return response;
		}
		
		response.setId(listaCliente.get().getId());
		response.setNome(listaCliente.get().getNome());
		response.setCpf(listaCliente.get().getCpf());
		
		response.Message = "Cliente obtido com sucesso!";
		response.StatusCode = 200;
		return response;
	
	}
	

}
