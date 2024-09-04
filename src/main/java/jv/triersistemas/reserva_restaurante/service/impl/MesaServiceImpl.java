package jv.triersistemas.reserva_restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.MesaDto;
import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;
import jv.triersistemas.reserva_restaurante.repository.MesaRepository;
import jv.triersistemas.reserva_restaurante.repository.RestauranteRepository;
import jv.triersistemas.reserva_restaurante.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaRepository repository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Override
	public MesaDto adicionarMesa(MesaDto novaMesa) {
		RestauranteEntity restauranteEntity = restauranteRepository.findById(novaMesa.getIdRestaurante())
				.orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));

		MesaEntity mesa = new MesaEntity(novaMesa);
		mesa.setRestaurante(restauranteEntity);
		return new MesaDto(repository.save(mesa));
	}

	@Override
	public List<MesaDto> getTodasMesas() {
		List<MesaEntity> listaMesas = repository.findAll();
		return listaMesas.stream().map(MesaDto::new).toList();
	}

	@Override
	public MesaDto atualizarMesa(Long id, MesaDto mesaAtualizada) {
		Optional<MesaEntity> mesa = repository.findById(id);
		if(mesa.isPresent()) {
			mesa.get().atualizaMesa(mesaAtualizada);
			var entidadePersistida = repository.save(mesa.get());
			return new MesaDto(entidadePersistida);
		}
		return null;
	}

}
