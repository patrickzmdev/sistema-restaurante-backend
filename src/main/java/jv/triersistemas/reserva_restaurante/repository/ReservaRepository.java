package jv.triersistemas.reserva_restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>{

}
