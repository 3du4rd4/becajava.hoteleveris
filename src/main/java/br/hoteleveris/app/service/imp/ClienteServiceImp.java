package br.hoteleveris.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteList;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private ClienteRepository _repository;

	public BaseResponse inserir(ClienteRequest request) {

		if (request.getNome() == "" || request.getNome() == null)
			return new BaseResponse(400, "Nome não foi preenchido!");

		if (request.getCpf() == null)
			return new BaseResponse(400, "CPF não foi preenchido");

		Cliente cliente = new Cliente(request.getNome(), request.getCpf(), request.getHash());

		_repository.save(cliente);
		return new BaseResponse(201, "Novo cliente salvo com sucesso!");

	}

	public ClienteResponse obter(Long id) {
		ClienteResponse response = new ClienteResponse();

		if (id == null || id <= 0) {

			return new ClienteResponse(400, "Cliente não localizado!");
		}

		Optional<Cliente> cliente = _repository.findById(id);

		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		response.setStatusCode(200);
		response.setMessage("Cliente obtido com sucesso!");

		return response;
	}
	
	public ClienteList listar() {
        List<Cliente> lista = _repository.findAll();

        ClienteList response = new ClienteList();
        response.setClientes(lista);
        response.setStatusCode(200);
        response.setMessage("Clientes obtidos com sucesso.");

        return response;
    }

    public BaseResponse atualizar(Long id, ClienteRequest clienteRequest) {

        Cliente cliente = new Cliente();

        if (clienteRequest.getNome().trim().equals("") || clienteRequest.getNome().equals("string")) {
            return new BaseResponse(400, "O nome do cliente não foi preenchido.");
        }
        if (clienteRequest.getCpf().trim().equals("") || clienteRequest.getCpf().equals("string")) {
            return new BaseResponse(400, "O CPF do cliente não foi preenchido.");
        }
        if (clienteRequest.getHash().trim().equals("") || clienteRequest.getHash().equals("string")) {
            return new BaseResponse(400, "O Hash do cliente não foi preenchido.");
        }

        cliente.setId(id);
        cliente.setNome(clienteRequest.getNome());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setHash(clienteRequest.getHash());
        _repository.save(cliente);
        return new BaseResponse(201, "Cliente atualizado com sucesso.");
    }

    public BaseResponse deletar(Long id) {
        BaseResponse response = new BaseResponse();

        if (_repository.existsById(id) == false) {
            return new BaseResponse(400, "Cliente inválido!");
        }

        _repository.deleteById(id);
        return new BaseResponse(201, "Cliente excluído!");
    }

}
