package br.hoteleveris.app.service.imp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	public void criarSemHash(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("José");
		request.setCpf("12345678");

		
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
	public void criarHashNulo(){
		ClienteRequest request = new ClienteRequest();
		request.setNome("José");
		request.setCpf("12345678");
		request.setHash(null);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void obterIdMenorQueZero() {
		ClienteResponse response = service.obter(new Long(-5));
		Assertions.assertEquals(400, response.getStatusCode());
		
	}
	
	@Test
	public void obterPorIdZero() {
		BaseResponse response = service.obter(0l);
		Assertions.assertEquals(404,response.getStatusCode());
		Assertions.assertEquals("Cliente não encontrado", response.getMessage());
	}
	
	
	@Test
	public void obterPorIdNaoExistente() {
		BaseResponse response = service.obter(12121212111l);
		Assertions.assertEquals(404,response.getStatusCode());
		Assertions.assertEquals("Cliente não encontrado", response.getMessage());
		
	}
	@Test
	public void obter() {
		Long id = 2L;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(200, response.getStatusCode());
		
	}
	@Test
	public void obterIdInvalido() {
		Long id = null;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Cliente não localizado!", response.getMessage());
		
	}

}