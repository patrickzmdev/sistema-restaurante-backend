package jv.triersistemas.reserva_restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jv.triersistemas.reserva_restaurante.entity.ClienteEntity;
import jv.triersistemas.reserva_restaurante.entity.PessoaBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@EqualsAndHashCode(callSuper = true)
public class ClienteDto extends PessoaBase {
	private Long id;

	private LocalDate dataCadastro;

	private int quantidadeReservas;

	private BigDecimal quantidadeValorGasto;

	private boolean bloqueado;
	
	private Long idRestaurante;

	public ClienteDto(ClienteEntity clienteEntity) {
		this.id = clienteEntity.getId();
		this.nome = clienteEntity.getNome();
		this.sobrenome = clienteEntity.getSobrenome();
		this.cpf = clienteEntity.getCpf();
		this.dataNascimento = clienteEntity.getDataNascimento();
		this.sexo = clienteEntity.getSexo();
		this.telefone = clienteEntity.getTelefone();
		this.dataCadastro = clienteEntity.getDataCadastro();
		this.quantidadeReservas = clienteEntity.getQuantidadeReservas();
		this.quantidadeValorGasto = clienteEntity.getQuantidadeValorGasto();
		this.bloqueado = clienteEntity.isBloqueado();
		this.idRestaurante = clienteEntity.getRestaurante().getId();
	}
}
