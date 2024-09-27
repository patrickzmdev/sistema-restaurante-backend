package jv.triersistemas.reserva_restaurante.controller;

import java.util.List;

import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerRestaurante(@PathVariable Long id) {
		restauranteService.removerRestaurante(id);
		return ResponseEntity.noContent().build();
	}

}
