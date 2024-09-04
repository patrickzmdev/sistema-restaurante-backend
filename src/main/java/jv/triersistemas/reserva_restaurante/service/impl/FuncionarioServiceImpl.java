package jv.triersistemas.reserva_restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.FuncionarioDto;
import jv.triersistemas.reserva_restaurante.entity.FuncionarioEntity;
import jv.triersistemas.reserva_restaurante.repository.FuncionarioRepository;
import jv.triersistemas.reserva_restaurante.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	@Override
	public FuncionarioDto adicionarFuncionario(FuncionarioDto novoFuncionario) {
		FuncionarioEntity funcionarioEntity = repository.save(new FuncionarioEntity(novoFuncionario));
		return new FuncionarioDto(funcionarioEntity);
	}

}
