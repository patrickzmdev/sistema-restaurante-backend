package jv.triersistemas.reserva_restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>{
    List<ReservaEntity> findByClienteId(Long clienteId);
    
    List<ReservaEntity> findByClienteIdAndStatus(Long clieteId, StatusEnum status);

}
