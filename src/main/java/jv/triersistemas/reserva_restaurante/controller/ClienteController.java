package jv.triersistemas.reserva_restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import jv.triersistemas.reserva_restaurante.dto.ClienteDto;
import jv.triersistemas.reserva_restaurante.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public Page<ClienteDto> listarClientes(@RequestParam(defaultValue = "0", required = false) Integer page,
											@RequestParam(defaultValue = "10", required = false) Integer size,
											@RequestParam(required = false) String searchTerm){
		return clienteService.listarClientes(Pageable.ofSize(size).withPage(page), searchTerm);
	}

	@PostMapping
	public ClienteDto adicionarCliente(@RequestBody ClienteDto clienteDto) {
		return clienteService.adicionarCliente(clienteDto);
	}

	@PutMapping("/{id}")
	public ClienteDto atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteAtualizado) {
		return clienteService.atualizarCliente(id, clienteAtualizado);
	}

	@GetMapping("/{id}")
	public ClienteDto buscarClientePorId(@PathVariable Long id) {
		return clienteService.buscarClientePorId(id);
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
