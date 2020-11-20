package br.hoteleveris.app.service.imp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.FaturaService;


@SpringBootTest
public class FaturaTesteImp {
	
	@Autowired
	private FaturaService service;
	
	@Test
	public void Transferencia() {
	 service.inserir();
	 BaseResponse response = new BaseResponse();
		
		Assertions.assertEquals(200,response.getStatusCode());
		Assertions.assertEquals("Transferencia completa", response.getMessage());
		
	}
	
}
