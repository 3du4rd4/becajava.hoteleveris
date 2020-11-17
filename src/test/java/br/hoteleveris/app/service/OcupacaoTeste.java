package br.hoteleveris.app.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class OcupacaoTeste {

	@Autowired
	private OcupacaoService service;
	
	@Test
	public void camposNulos() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData(null);
	request.setQtDiarias(0);
	request.setQuartoId(request.getQuartoId());
	request.setClienteId(request.getClienteId());
	request.setSituacao("");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	

}