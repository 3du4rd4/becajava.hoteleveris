package br.hoteleveris.app.service.imp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.request.ClienteList;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.service.ClienteService;


@SpringBootTest
public class ClienteTesteImp {
	
	@Autowired
	private ClienteService service;
	
	@Test
	public void criarCliente(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("José");
		request.setCpf("12345");
		request.setHash("3456");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201,response.getStatusCode());
	
	}
	
	@Test
	public void criarSemNome(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("");
		request.setCpf("123333");
		request.setHash("2322");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarSemCpf(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("José");
		request.setHash("12221");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
		
	@Test
	public void criarNomeNulo(){
		ClienteRequest request = new ClienteRequest();
		request.setNome(null);
		request.setCpf("12345678");
		request.setHash("1234443");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
		Assertions.assertEquals("Nome não foi preenchido!",response.getMessage());

	}
	
	@Test
	public void criarCpfNulo(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("José");
		request.setCpf(null);
		request.setHash("1112");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
		
	@Test
	public void obterIdMenorQueZero() {
		ClienteResponse response = service.obter(new Long(-5));
		Assertions.assertEquals(400, response.getStatusCode());
		
	}
	
	@Test
	public void obter() {
		Long id = 2L;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(200, response.getStatusCode());
		
	}
	
	  @Test
	    public void pegaLista() {
	        ClienteList obj = new ClienteList();
	        obj.setClientes(obj.getClientes());

	        BaseResponse response = service.listar();
	        Assertions.assertEquals(200, response.getStatusCode());
	    }	  
	  
	@Test
	public void obterIdInvalido() {
		Long id = null;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Cliente não localizado!", response.getMessage());
		
	}
	
	@Test
    void atualizar() {
        Cliente cliente = new Cliente();
        ClienteRequest request = new ClienteRequest();
        cliente.setId(new Long(1));
        request.setNome("Isa");
        request.setCpf("123456789");
        request.setHash(cliente.getHash());

        BaseResponse response = service.atualizar(new Long(1),request);

        Assertions.assertEquals(201, response.getStatusCode());
        Assertions.assertEquals("Cliente atualizado com sucesso.", response.getMessage());
    }
}