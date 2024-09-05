package jv.triersistemas.reserva_restaurante.repository;

import java.time.LocalDate;
import java.util.List;

import jv.triersistemas.reserva_restaurante.entity.MesaEntity;

public interface MesaRepositoryCustom {
	List<MesaEntity> buscarMesasPorDataECapacidadePessoas(Long restauranteId, Integer capacidadePessoas, LocalDate data);
}
