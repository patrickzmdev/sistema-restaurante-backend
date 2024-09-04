package jv.triersistemas.reserva_restaurante.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.ClienteDto;
import jv.triersistemas.reserva_restaurante.entity.ClienteEntity;
import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;
import jv.triersistemas.reserva_restaurante.repository.ClienteRepository;
import jv.triersistemas.reserva_restaurante.repository.RestauranteRepository;
import jv.triersistemas.reserva_restaurante.service.ClienteService;
import jv.triersistemas.reserva_restaurante.service.RestauranteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	RestauranteRepository restauranteRepository;

	@Override
	public ClienteDto adicionarCliente(ClienteDto novoCliente) {
		RestauranteEntity restaurante = restauranteRepository.findById(novoCliente.getIdRestaurante())
				.orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));
		validarIdade(novoCliente);
		ClienteEntity clienteEntity = new ClienteEntity(novoCliente);
		clienteEntity.setRestaurante(restaurante);
		return new ClienteDto(repository.save(clienteEntity));
	}

	@Override
	public List<ClienteDto> getTodosClientes() {
		List<ClienteEntity> listaClientes = repository.findAll();
		return listaClientes.stream().map(ClienteDto::new).toList();
	}

	@Override
	public ClienteDto atualizarCliente(Long id, ClienteDto ClienteAtualizado) {
		
		return null;
	}
	
	public void validarIdade(ClienteDto cliente) {
		LocalDate idadeMinima = LocalDate.now().minusYears(12);
		LocalDate idadeMaxima = LocalDate.now().minusYears(100);
		if(cliente.getDataNascimento().isAfter(idadeMinima) || cliente.getDataNascimento().isBefore(idadeMaxima)) {
			throw new IllegalArgumentException("Os clientes não podem ter a mais de 100 anos e nem ter menos que 12 anos");
		}
	}
}
