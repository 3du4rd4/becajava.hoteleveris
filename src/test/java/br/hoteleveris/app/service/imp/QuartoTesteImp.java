package br.hoteleveris.app.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeIdRequest;
import br.hoteleveris.app.request.ComodidadeRequest;

import br.hoteleveris.app.request.QuartoList;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.QuartoService;

@SpringBootTest
public class QuartoTesteImp {

	@Autowired
	private QuartoService service;

	public int pegarNumeroRandomico(int min, int max) {
		Random random = new Random();
		return random.ints(min, max).findFirst().getAsInt();
	}

	@Test
	public void criarQuarto() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(9);
		request.setTipoQuartoId(1l);

		request.setSituacao("A");
		int nq = this.pegarNumeroRandomico(1, 1000);
		request.setNoQuarto(nq);

		List<ComodidadeIdRequest> comodidades = new ArrayList<ComodidadeIdRequest>();
		ComodidadeIdRequest obj = new ComodidadeIdRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidades(comodidades);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.getStatusCode());

		Assertions.assertEquals("Quarto Comodidade inserido com sucesso", response.getMessage());

	}

	@Test
	public void criarQuartoSituacaoNull() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(20);
		request.setTipoQuartoId(1L);
		request.setSituacao(null);
		int nq = this.pegarNumeroRandomico(1, 1000);
		request.setNoQuarto(nq);

		List<ComodidadeIdRequest> comodidades = new ArrayList<ComodidadeIdRequest>();
		ComodidadeIdRequest obj = new ComodidadeIdRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidades(comodidades);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void criarAndarVazio() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(0);
		request.setTipoQuartoId(1l);

		request.setSituacao("A");
		int nq = this.pegarNumeroRandomico(1, 1000);
		request.setNoQuarto(nq);

		List<ComodidadeIdRequest> comodidades = new ArrayList<ComodidadeIdRequest>();
		ComodidadeIdRequest obj = new ComodidadeIdRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidades(comodidades);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());

		Assertions.assertEquals("O andar precisa ser preenchido", response.getMessage());
	}

	@Test
	public void criarQuartoNumeroZero() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(1);
		request.setTipoQuartoId(1L);
		request.setSituacao("A");

		request.setNoQuarto(-0);

		List<ComodidadeIdRequest> comodidades = new ArrayList<ComodidadeIdRequest>();
		ComodidadeIdRequest obj = new ComodidadeIdRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidades(comodidades);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void criarNumQuartoMenorZero() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(30);
		request.setTipoQuartoId(1l);

		request.setSituacao("A");
		request.setNoQuarto(-0);

		List<ComodidadeIdRequest> comodidades = new ArrayList<ComodidadeIdRequest>();
		ComodidadeIdRequest obj = new ComodidadeIdRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidades(comodidades);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());

		Assertions.assertEquals("O número do quarto precisa ser maior que 0", response.getMessage());
	}

	@Test
	public void criarQuartoSituacaoVazio() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar(30);
		request.setTipoQuartoId(1l);

		request.setSituacao("");
		int nq = this.pegarNumeroRandomico(1, 1000);
		request.setNoQuarto(nq);

		List<ComodidadeIdRequest> comodidades = new ArrayList<ComodidadeIdRequest>();
		ComodidadeIdRequest obj = new ComodidadeIdRequest();
		obj.setId(1L);
		comodidades.add(obj);

		request.setComodidades(comodidades);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());

		Assertions.assertEquals("A situação do quarto precisa ser preenchido", response.getMessage());
	}

	@Test
	public void atualizarSituacaoQuartoPorId() {
		SituacaoRequest sr = new SituacaoRequest();
		sr.setSituacao("A");

		BaseResponse response = service.atualizar(new Long(1), sr);
		Assertions.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void atualizarSituacaoVazio() {
		SituacaoRequest situacao = new SituacaoRequest();
		situacao.setSituacao("");

		BaseResponse response = service.atualizar(new Long(1), situacao);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void pegarLista() {
		QuartoList obj = new QuartoList();
		obj.setQuartos(obj.getQuartos());
		Long id = 2l;
		BaseResponse response = service.obterPorTipo(id);
		Assertions.assertEquals(200, response.getStatusCode());

	}

	@Test
	public void obterPorIdTipoQuarto() {
		BaseResponse response = service.obterPorTipo(1L);
		Assertions.assertEquals(200, response.getStatusCode());
	}
}