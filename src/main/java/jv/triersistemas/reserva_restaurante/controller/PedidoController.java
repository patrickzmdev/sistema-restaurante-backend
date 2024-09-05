package jv.triersistemas.reserva_restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.reserva_restaurante.dto.PedidoDto;
import jv.triersistemas.reserva_restaurante.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public PedidoDto adicionarPedido(@RequestBody PedidoDto novoPedido) {
		return pedidoService.adicionarPedido(novoPedido);
	}
}
