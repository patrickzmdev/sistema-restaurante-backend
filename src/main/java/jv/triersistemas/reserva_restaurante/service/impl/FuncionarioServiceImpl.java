package jv.triersistemas.reserva_restaurante.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.FuncionarioDto;
import jv.triersistemas.reserva_restaurante.entity.FuncionarioEntity;
import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;
import jv.triersistemas.reserva_restaurante.enums.CargoEnum;
import jv.triersistemas.reserva_restaurante.repository.FuncionarioRepository;
import jv.triersistemas.reserva_restaurante.repository.RestauranteRepository;
import jv.triersistemas.reserva_restaurante.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Override
	public FuncionarioDto adicionarFuncionario(FuncionarioDto novoFuncionario) {
		RestauranteEntity restaurante = restauranteRepository.findById(novoFuncionario.getIdRestaurante())
				.orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));
		
		validarCargaHoraria(novoFuncionario);
		validarSalario(novoFuncionario);
		String cpfSemCaracteres = limparCpf(novoFuncionario.getCpf());
		FuncionarioEntity funcionarioEntity = new FuncionarioEntity(novoFuncionario);
		funcionarioEntity.setRestaurante(restaurante);
		funcionarioEntity.setCpf(cpfSemCaracteres);
		return new FuncionarioDto(repository.save(funcionarioEntity));
	}

	@Override
	public List<FuncionarioDto> getTodosFuncionarios() {
		List<FuncionarioEntity> listaFuncionarios = repository.findAll();
		return listaFuncionarios.stream().map(FuncionarioDto::new).toList();
	}

	@Override
	public FuncionarioDto atualizarFuncionario(Long id, FuncionarioDto funcionarioAtualizado) {
		Optional<FuncionarioEntity> funcionarioPorId = repository.findById(id);
		if(funcionarioPorId.isPresent()) {
			funcionarioPorId.get().atualizaFuncionario(funcionarioAtualizado);
			var entidadePersistida = repository.save(funcionarioPorId.get());
			return new FuncionarioDto(entidadePersistida);
		}
		return null;
	}
	
	public void validarCargaHoraria(FuncionarioDto funcionario) {
		if(funcionario.getCargaHoraria() > 220 && funcionario.getCargo() != CargoEnum.FREELANCER) {
			throw new IllegalArgumentException("O funcionário não pode ter mais de 220 horas mensais");
		}
	}
	
	public void validarSalario(FuncionarioDto funcionario) {
		BigDecimal salarioMinimo = new BigDecimal("1412.00");
		if(funcionario.getCargo() != CargoEnum.FREELANCER && funcionario.getSalario().compareTo(salarioMinimo) <0) {
			throw new IllegalArgumentException("O sálario do funcionário tem que ser maior que um sálario mínimo (R$1412");
		}
	}
	
	public String limparCpf(String cpf) {
		return cpf.replaceAll("[^\\d]", "");
	}

}
