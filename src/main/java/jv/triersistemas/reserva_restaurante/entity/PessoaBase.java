package jv.triersistemas.reserva_restaurante.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jv.triersistemas.reserva_restaurante.enums.SexoEnum;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class PessoaBase {
	@Column(nullable = false)
	protected String nome;

	@Column(nullable = false)
	protected String sobrenome;

	@Column(nullable = false, unique = true, length = 11)
	protected String cpf;

	@Column(nullable = false)
	protected LocalDate dataNascimento;

	@Column(nullable = false)
	protected SexoEnum sexo;

	@Column(nullable = false, unique = true)
	protected String telefone;
}
