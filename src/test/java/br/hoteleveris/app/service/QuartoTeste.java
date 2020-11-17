package br.hoteleveris.app.service;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class QuartoTeste {
	@Autowired
	private QuartoService service;


	@Test
	public void inserir() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(1);
		request.setTipoQuartoId(1L);
		request.setSituacao("A");
		request.setNoQuarto(110);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest c = new ComodidadeRequest();
		c.setId(1L);
		comodidades.add(c);
		
		request.setComodidades(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void inserirAndarZero() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(0);
		request.setTipoQuartoId(1L);
		request.setSituacao("A");
		request.setNoQuarto(1674);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest c = new ComodidadeRequest();
		c.setId(1L);
		comodidades.add(c);
		
		request.setComodidades(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoZero() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(2);
		request.setTipoQuartoId(1L);
		request.setSituacao("A");
		request.setNoQuarto(0);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest c = new ComodidadeRequest();
		c.setId(1L);
		comodidades.add(c);
		
		request.setComodidades(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirSituacaoVazia() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(2);
		request.setTipoQuartoId(1L);
		request.setSituacao("");
		request.setNoQuarto(100000);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest c = new ComodidadeRequest();
		c.setId(1L);
		comodidades.add(c);
		
		request.setComodidades(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoSituacaoNull() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(2);
		request.setTipoQuartoId(1L);
		request.setSituacao(null);
		request.setNoQuarto(100000);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest c = new ComodidadeRequest();
		c.setId(1L);
		comodidades.add(c);
		
		request.setComodidades(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void listar() {			
		BaseResponse response = service.listar();
		Assertions.assertEquals(200, response.getStatusCode());
	}
	
	
}