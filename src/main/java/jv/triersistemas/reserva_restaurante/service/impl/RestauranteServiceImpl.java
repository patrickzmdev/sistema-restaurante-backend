package jv.triersistemas.reserva_restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.RestauranteDto;
import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;
import jv.triersistemas.reserva_restaurante.repository.RestauranteRepository;
import jv.triersistemas.reserva_restaurante.service.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	private RestauranteRepository repository;

	@Override
	public RestauranteDto adicionarRestaurante(RestauranteDto novoRestaurante) {
		String cnpjSemCaracteres = limparCnpj(novoRestaurante.getCnpj());
		RestauranteEntity restaurante = new RestauranteEntity(novoRestaurante);
		restaurante.setCnpj(cnpjSemCaracteres);
		return new RestauranteDto(repository.save(restaurante));
	}

	@Override
	public List<RestauranteDto> getTodosRestaurantes() {
		List<RestauranteEntity> listaRestaurantes = repository.findAll();
		return listaRestaurantes.stream().map(RestauranteDto::new).toList();
	}

	@Override
	public RestauranteDto atualizarRestaurante(Long id, RestauranteDto restauranteAtualizado) {
		Optional<RestauranteEntity> restaurantePorId = repository.findById(id);
		if (restaurantePorId.isPresent()) {
			restaurantePorId.get().atualizaRestaurante(restauranteAtualizado);
			var entidadePersistida = repository.save(restaurantePorId.get());
			return new RestauranteDto(entidadePersistida);
		}
		return null;
	}

	@Override
	public void removerRestaurante(Long id) {

		Optional<RestauranteEntity> restaurantePorId = repository.findById(id);
		if (restaurantePorId.isPresent()) {

			repository.delete(restaurantePorId.get());
		} else {
			throw new EntityNotFoundException("Restaurante com ID " + id + " não encontrado.");
		}
	}


	public String limparCnpj(String cnpj) {
		return cnpj.replaceAll("[^\\d]", "");
	}

}
