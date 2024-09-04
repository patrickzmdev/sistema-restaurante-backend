package jv.triersistemas.reserva_restaurante.service;

import java.util.List;

import jv.triersistemas.reserva_restaurante.dto.FuncionarioDto;

public interface FuncionarioService {
	FuncionarioDto adicionarFuncionario(FuncionarioDto novoFuncionario);

	List<FuncionarioDto> getTodosFuncionarios();

	FuncionarioDto atualizarFuncionario(Long id, FuncionarioDto funcionarioAtualizado);
}
