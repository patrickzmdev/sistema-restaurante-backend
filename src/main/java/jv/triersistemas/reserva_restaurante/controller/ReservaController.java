package jv.triersistemas.reserva_restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.reserva_restaurante.dto.ReservaDto;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import jv.triersistemas.reserva_restaurante.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	ReservaService reservaService;
	
	@PostMapping
	public ReservaDto adicionarReserva(@RequestBody ReservaDto novaReserva) {
		return reservaService.adicionarReserva(novaReserva);
	}
	
	@GetMapping("/cliente/{clienteId}")
	public List<ReservaDto> buscarReservasPorCliente(@PathVariable Long clienteId) {
		List<ReservaDto> tarefas = reservaService.buscarReservasPorCliente(clienteId);
		return tarefas;
	}
	
	@PutMapping()
	public ReservaDto atualizarStatusReserva(@RequestParam Long id, @RequestParam StatusEnum status) {
		return reservaService.atualizaReserva(id, status);
	}
	
}
