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

import jv.triersistemas.reserva_restaurante.dto.RestauranteDto;
import jv.triersistemas.reserva_restaurante.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@PostMapping
	private RestauranteDto adicionarRestaurante(@RequestBody RestauranteDto novoRestaurante) {
		return restauranteService.adicionarRestaurante(novoRestaurante);
	}
	
	@GetMapping()
	private List<RestauranteDto> getTodosRestaurantes() {
		return restauranteService.getTodosRestaurantes();
	}
	
	@PutMapping("/{id}")
	private RestauranteDto atualizarRestaurante(@PathVariable Long id, @RequestBody RestauranteDto restauranteAtualizado) {
		return restauranteService.atualizarRestaurante(id, restauranteAtualizado);
	}
}
