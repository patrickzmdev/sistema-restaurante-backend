package jv.triersistemas.reserva_restaurante.dto;

import jv.triersistemas.reserva_restaurante.entity.PedidoEntity;
import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;
import jv.triersistemas.reserva_restaurante.enums.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestauranteDto {
	private Long id;
	private String nome;
	private String cnpj;
	private int estrelas;
	private TipoComidaEnum tipoComida;
	
	public RestauranteDto(RestauranteEntity restauranteEntity) {
		this.id = restauranteEntity.getId();
		this.nome = restauranteEntity.getNome();
		this.cnpj = restauranteEntity.getCnpj();
		this.estrelas = restauranteEntity.getEstrelas();
		this.tipoComida = restauranteEntity.getTipoComida();
	}
}
