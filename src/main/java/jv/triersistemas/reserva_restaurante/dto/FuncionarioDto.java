package jv.triersistemas.reserva_restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jv.triersistemas.reserva_restaurante.entity.FuncionarioEntity;
import jv.triersistemas.reserva_restaurante.entity.PessoaBase;
import jv.triersistemas.reserva_restaurante.enums.CargoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioDto extends PessoaBase{
	private Long id;
	private CargoEnum cargo;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
	private int cargaHoraria;
	
	private Long idRestaurante;

	
	public FuncionarioDto(FuncionarioEntity funcionarioEntity) {
		this.id = funcionarioEntity.getId();
		this.nome = funcionarioEntity.getNome();
		this.sobrenome = funcionarioEntity.getSobrenome();
		this.cpf = funcionarioEntity.getCpf();
		this.dataNascimento = funcionarioEntity.getDataNascimento();
		this.sexo = funcionarioEntity.getSexo();
		this.telefone = funcionarioEntity.getTelefone();
		this.dataAdmissao = funcionarioEntity.getDataAdmissao();
		this.salario = funcionarioEntity.getSalario();
		this.cargaHoraria = funcionarioEntity.getCargaHoraria();
		this.cargo = funcionarioEntity.getCargo();
		this.idRestaurante = funcionarioEntity.getRestaurante().getId();
	}
}
