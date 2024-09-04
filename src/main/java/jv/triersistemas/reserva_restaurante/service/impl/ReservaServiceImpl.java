package jv.triersistemas.reserva_restaurante.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.ReservaDto;
import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;
import jv.triersistemas.reserva_restaurante.repository.ReservaRepository;
import jv.triersistemas.reserva_restaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repository;

	@Override
	public ReservaDto adicionarReserva(ReservaDto novaReserva) {
		ReservaEntity reservaEntity = repository.save(new ReservaEntity(novaReserva));
		return new ReservaDto(reservaEntity);
	}
	
}
