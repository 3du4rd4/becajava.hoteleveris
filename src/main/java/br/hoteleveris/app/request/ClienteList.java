package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

public class ClienteList {

	
	private List<ClienteResponse> Clientes;
	
	public List<ClienteResponse> getClientes() {
        return Clientes;
    }

    public void setClientes(List<ClienteResponse> clientes) {
        Clientes = clientes;
    }
}
