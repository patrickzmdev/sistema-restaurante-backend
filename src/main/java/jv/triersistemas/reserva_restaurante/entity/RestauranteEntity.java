package jv.triersistemas.reserva_restaurante.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv.triersistemas.reserva_restaurante.dto.RestauranteDto;
import jv.triersistemas.reserva_restaurante.enums.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "restaurante")
public class RestauranteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true, length = 14)
	private String cnpj;

	@Column(nullable = false)
	private int estrelas;

	@Enumerated(EnumType.ORDINAL)
	private TipoComidaEnum tipoComida;
	
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH)
	private List<MesaEntity> mesas;
	
	public RestauranteEntity(RestauranteDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cnpj = dto.getCnpj();
		this.estrelas = dto.getEstrelas();
		this.tipoComida = dto.getTipoComida();
		this.mesas = dto.getMesas();

	}
	
    public RestauranteEntity atualizaRestaurante(RestauranteDto dto) {
    	this.nome = dto.getNome();
    	this.cnpj = dto.getCnpj();
    	this.estrelas = dto.getEstrelas();
    	this.tipoComida = dto.getTipoComida();
    	return this;
    }
}
