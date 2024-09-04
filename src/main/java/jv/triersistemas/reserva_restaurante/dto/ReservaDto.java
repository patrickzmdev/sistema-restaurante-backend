package jv.triersistemas.reserva_restaurante.dto;

import java.time.LocalDate;

import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDto {
	private Long id;
	private LocalDate dataReserva;
	private int quantidadePessoas;
	private StatusEnum status;
	private String observacao;

	private Long idCliente;
	private Long idMesa;
	
	public ReservaDto(ReservaEntity reservaEntity) {
		this.id = reservaEntity.getId();
		this.dataReserva = reservaEntity.getDataReserva();
		this.quantidadePessoas = reservaEntity.getQuantidadePessoas();
		this.status = reservaEntity.getStatus();
		this.observacao = reservaEntity.getObservacao();
		this.idCliente = reservaEntity.getCliente().getId();
		this.idMesa = reservaEntity.getMesa().getId();
	}
}
