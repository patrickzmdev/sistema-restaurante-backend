package jv.triersistemas.reserva_restaurante.service;

import java.util.List;

import jv.triersistemas.reserva_restaurante.dto.ClienteDto;

public interface ClienteService {
	ClienteDto adicionarCliente(ClienteDto novoCliente);
	
	List<ClienteDto> getTodosClientes();

	ClienteDto atualizarCliente(Long id, ClienteDto ClienteAtualizado);

}
