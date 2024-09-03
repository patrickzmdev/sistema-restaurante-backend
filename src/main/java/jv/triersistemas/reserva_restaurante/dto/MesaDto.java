package jv.triersistemas.reserva_restaurante.dto;

import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesaDto {
	private Long id;
	private int numero;
	private int capacidadePessoas;
	
	private Long idRestaurante;

	
	public MesaDto(MesaEntity mesaEntity) {
		this.id = mesaEntity.getId();
		this.numero = mesaEntity.getNumero();
		this.capacidadePessoas = mesaEntity.getCapacidadePessoas();
		this.idRestaurante = mesaEntity.getRestaurante().getId();
	}
}
