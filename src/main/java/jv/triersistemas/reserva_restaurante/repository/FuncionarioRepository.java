package jv.triersistemas.reserva_restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jv.triersistemas.reserva_restaurante.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>	{

}
