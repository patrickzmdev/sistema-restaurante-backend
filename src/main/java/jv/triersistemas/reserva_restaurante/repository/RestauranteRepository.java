package jv.triersistemas.reserva_restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.reserva_restaurante.entity.RestauranteEntity;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long>{

}
