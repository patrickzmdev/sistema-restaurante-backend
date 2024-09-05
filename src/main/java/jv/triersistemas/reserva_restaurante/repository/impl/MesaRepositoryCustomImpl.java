package jv.triersistemas.reserva_restaurante.repository.impl;

import java.time.LocalDate;
import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import jv.triersistemas.reserva_restaurante.entity.QMesaEntity;
import jv.triersistemas.reserva_restaurante.entity.QReservaEntity;
import jv.triersistemas.reserva_restaurante.entity.QRestauranteEntity;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import jv.triersistemas.reserva_restaurante.repository.MesaRepositoryCustom;

public class MesaRepositoryCustomImpl implements MesaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QReservaEntity reserva = QReservaEntity.reservaEntity;
	final QMesaEntity mesa = QMesaEntity.mesaEntity;

	@Override
	public List<MesaEntity> buscarMesasPorDataECapacidadePessoas(Long restauranteId, Integer capacidadePessoas, LocalDate data) {
		var query = new JPAQuery<MesaEntity>(em);

		query.select(mesa).distinct()
		.from(restaurante)
		.join(restaurante.mesas, mesa)
		.leftJoin(mesa.reservas, reserva)
		.where(restaurante.id.eq(restauranteId)
				.and(mesa.qntdPessoas.eq(capacidadePessoas))
				.and(reserva.dataReserva.eq(data))
				.and(reserva.status.ne(StatusEnum.CANCELADA)));

		return query.fetch();
	}

}
