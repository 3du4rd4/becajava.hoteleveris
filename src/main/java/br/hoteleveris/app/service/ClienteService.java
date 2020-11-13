package br.hoteleveris.app.service;


import org.springframework.stereotype.Service;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

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

}
