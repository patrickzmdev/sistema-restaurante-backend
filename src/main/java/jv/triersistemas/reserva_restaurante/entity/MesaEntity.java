package jv.triersistemas.reserva_restaurante.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jv.triersistemas.reserva_restaurante.dto.MesaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "mesa")
public class MesaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private int numero;
	@Column(nullable = false)
	private int qntPessoas;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	@JsonIgnore
	private RestauranteEntity restaurante;
	
	@OneToMany(mappedBy = "mesa", cascade = CascadeType.DETACH)
	private List<ReservaEntity> reservas;
	
	public MesaEntity(MesaDto dto) {
		this.id = dto.getId();
		this.numero = dto.getNumero();
		this.qntPessoas = dto.getQntPessoas();
		this.reservas = dto.getReservas();

	}
	
	public MesaEntity atualizaMesa(MesaDto dto) {
		this.qntPessoas = dto.getQntPessoas();
		this.numero = dto.getNumero();
		return this;
	}
}
