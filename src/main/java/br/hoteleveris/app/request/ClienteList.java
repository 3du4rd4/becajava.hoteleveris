package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.response.BaseResponse;

public class ClienteList extends BaseResponse{

	
	private List<Cliente> Clientes;
	
	public List<Cliente> getClientes() {
        return Clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        Clientes = clientes;
    }
  
}
