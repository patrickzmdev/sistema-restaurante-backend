package jv.triersistemas.reserva_restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.reserva_restaurante.dto.ReservaDto;
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
	
}
