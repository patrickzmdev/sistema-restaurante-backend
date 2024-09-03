package jv.triersistemas.reserva_restaurante.dto;

import java.math.BigDecimal;

import jv.triersistemas.reserva_restaurante.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDto {
	private Long id;
	private String descricaoPedido;
	private BigDecimal valor;

	private Long idReserva;
	
	public PedidoDto(PedidoEntity pedidoEntity) {
		this.id = pedidoEntity.getId();
		this.descricaoPedido = pedidoEntity.getDescricaoPedido();
		this.valor = pedidoEntity.getValor();
		this.idReserva = pedidoEntity.getReserva().getId();
	}
}
