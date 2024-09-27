package jv.triersistemas.reserva_restaurante.service;

import java.util.List;

import jv.triersistemas.reserva_restaurante.dto.RestauranteDto;

public interface RestauranteService {
	RestauranteDto adicionarRestaurante(RestauranteDto novoRestaurante);
	
	List<RestauranteDto> getTodosRestaurantes();

	RestauranteDto atualizarRestaurante(Long id, RestauranteDto restauranteAtualizado);

	void removerRestaurante(Long id);
}
