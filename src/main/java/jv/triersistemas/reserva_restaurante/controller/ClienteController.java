package jv.triersistemas.reserva_restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.reserva_restaurante.dto.ClienteDto;
import jv.triersistemas.reserva_restaurante.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDto> getTodasCategorias() {
		return clienteService.getTodosClientes();
	}

	@PostMapping
	public ClienteDto adicionarCliente(@RequestBody ClienteDto clienteDto) {
		return clienteService.adicionarCliente(clienteDto);
	}

	@PutMapping("/{id}")
	public ClienteDto atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteAtualizado) {
		return clienteService.atualizarCliente(id, clienteAtualizado);
	}
	
    @PutMapping("/desbloquear/{id}")
    public ClienteDto desbloquearCliente(@PathVariable Long id) {
        return clienteService.desbloquearCliente(id);
    }
    
    @PutMapping("/bloquear/{id}")
    public ClienteDto bloquearCliente(@PathVariable Long id) {
        return clienteService.bloquearCliente(id);
    }
}
