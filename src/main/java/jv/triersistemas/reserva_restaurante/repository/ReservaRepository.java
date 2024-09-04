package jv.triersistemas.reserva_restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>{
    List<ReservaEntity> findByClienteId(Long clienteId);

}
