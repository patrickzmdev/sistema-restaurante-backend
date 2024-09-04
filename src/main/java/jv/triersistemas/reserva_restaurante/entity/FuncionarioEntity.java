package jv.triersistemas.reserva_restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv.triersistemas.reserva_restaurante.dto.ClienteDto;
import jv.triersistemas.reserva_restaurante.dto.FuncionarioDto;
import jv.triersistemas.reserva_restaurante.enums.CargoEnum;
import jv.triersistemas.reserva_restaurante.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "funcionario")
public class FuncionarioEntity extends PessoaBase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	private CargoEnum cargo;

	@Column(nullable = false)
	private LocalDate dataAdmissao;

	@Column(nullable = false)
	private BigDecimal salario;

	@Column(nullable = false)
	private int cargaHoraria;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	@JsonIgnore
	private RestauranteEntity restaurante;
	
	public FuncionarioEntity(FuncionarioDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.sobrenome = dto.getSobrenome();
		this.cpf = dto.getCpf();
		this.dataNascimento = dto.getDataNascimento();
		this.sexo = Objects.requireNonNullElse(dto.getSexo(), SexoEnum.INDEFINIDO);
		this.telefone = dto.getTelefone();
		this.dataAdmissao = Objects.requireNonNullElse(dto.getDataAdmissao(), LocalDate.now());
		this.salario = dto.getSalario();
		this.cargaHoraria = dto.getCargaHoraria();
		this.cargo = dto.getCargo();
	}
	
	public FuncionarioEntity atualizaFuncionario(FuncionarioDto dto) {
		this.nome = dto.getNome();
		this.sobrenome = dto.getSobrenome();
		this.cpf = dto.getCpf();
		this.dataNascimento = dto.getDataNascimento();
		this.sexo = dto.getSexo();
		this.telefone = dto.getTelefone();
		this.salario = dto.getSalario();
		this.cargaHoraria = dto.getCargaHoraria();
		this.cargo = dto.getCargo();
		return this;
	}
}
