package jv.triersistemas.reserva_restaurante.repository.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import jv.triersistemas.reserva_restaurante.entity.QMesaEntity;
import jv.triersistemas.reserva_restaurante.entity.QReservaEntity;
import jv.triersistemas.reserva_restaurante.entity.QRestauranteEntity;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import jv.triersistemas.reserva_restaurante.repository.MesaRepositoryCustom;

@Repository
public class MesaRepositoryCustomImpl implements MesaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QReservaEntity reserva = QReservaEntity.reservaEntity;
	final QMesaEntity mesa = QMesaEntity.mesaEntity;

	@Override
	public List<MesaEntity> buscarMesasPorDataECapacidadePessoas(Long restauranteId, LocalDate data, Integer capacidadePessoas) {
		var query = new JPAQuery<MesaEntity>(em);

		query.select(mesa).distinct()
		.from(restaurante)
		.join(restaurante.mesas, mesa)
		.leftJoin(mesa.reservas, reserva)
		.where(restaurante.id.eq(restauranteId)
				.and(mesa.qntPessoas.goe(capacidadePessoas))
				.and(reserva.dataReserva.ne(data).or(reserva.dataReserva.isNull()))
				.and(reserva.status.ne(StatusEnum.CANCELADA).or(reserva.status.isNull())));

		return query.fetch();
	}

}
