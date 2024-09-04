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

import jv.triersistemas.reserva_restaurante.dto.FuncionarioDto;
import jv.triersistemas.reserva_restaurante.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public FuncionarioDto adicionarFuncionario(@RequestBody FuncionarioDto novoFuncionario) {
		return funcionarioService.adicionarFuncionario(novoFuncionario);
	}
	
	@GetMapping
	public List<FuncionarioDto> getTodosFuncionarios() {
		return funcionarioService.getTodosFuncionarios();
	}
	
	@PutMapping
	public FuncionarioDto atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioAtualizado) {
		return funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);
	}
}
