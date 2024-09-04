package jv.triersistemas.reserva_restaurante.entity;

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
import jv.triersistemas.reserva_restaurante.dto.ReservaDto;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "reserva")
public class ReservaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private LocalDate dataReserva;
	@Column(nullable = false)
	private int quantidadePessoas;
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	private String observacao;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", nullable = false)
	@JsonIgnore
	private ClienteEntity cliente;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mesa_id", nullable = false)
	@JsonIgnore
	private MesaEntity mesa;
	
	public ReservaEntity(ReservaDto dto) {
		this.id = dto.getId();
		this.dataReserva = dto.getDataReserva();
		this.quantidadePessoas = dto.getQuantidadePessoas();
		this.status = Objects.requireNonNullElse(dto.getStatus(), StatusEnum.AGENDADA);
		this.observacao = dto.getObservacao();
	}
	
	public ReservaEntity atualizaMesa(ReservaDto dto) {
		this.dataReserva = dto.getDataReserva();
		this.quantidadePessoas = dto.getQuantidadePessoas();
		this.observacao = dto.getObservacao();
		return this;
	}
	
	public ReservaEntity atualizarStatus(StatusEnum status) {
		this.status = status;
		return this;
	}
}
