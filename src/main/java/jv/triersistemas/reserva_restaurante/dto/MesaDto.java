package jv.triersistemas.reserva_restaurante.dto;

import java.util.List;

import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesaDto {
	private Long id;
	private int numero;
	private int qntPessoas;
	
	private Long idRestaurante;
	private List<ReservaEntity> reservas;


	
	public MesaDto(MesaEntity mesaEntity) {
		this.id = mesaEntity.getId();
		this.numero = mesaEntity.getNumero();
		this.qntPessoas = mesaEntity.getQntPessoas();
		this.idRestaurante = mesaEntity.getRestaurante().getId();
		this.reservas = mesaEntity.getReservas();
	}
}
