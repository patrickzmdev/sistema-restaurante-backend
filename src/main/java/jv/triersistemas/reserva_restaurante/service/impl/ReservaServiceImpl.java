package jv.triersistemas.reserva_restaurante.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.ReservaDto;
import jv.triersistemas.reserva_restaurante.entity.ClienteEntity;
import jv.triersistemas.reserva_restaurante.entity.MesaEntity;
import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import jv.triersistemas.reserva_restaurante.repository.ClienteRepository;
import jv.triersistemas.reserva_restaurante.repository.MesaRepository;
import jv.triersistemas.reserva_restaurante.repository.ReservaRepository;
import jv.triersistemas.reserva_restaurante.service.ClienteService;
import jv.triersistemas.reserva_restaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	private ReservaRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MesaRepository mesaRepository;

	@Override
	public ReservaDto adicionarReserva(ReservaDto novaReserva) {
		ClienteEntity cliente = clienteRepository.findById(novaReserva.getIdCliente())
				.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
		MesaEntity mesa = mesaRepository.findById(novaReserva.getIdMesa()).orElseThrow(() -> new IllegalArgumentException("Mesa não encontrado"));

		validaDataReserva(novaReserva);
//		validaReservaNaMesmaData(novaReserva);

		ReservaEntity reserva = new ReservaEntity(novaReserva);
		reserva.setCliente(cliente);
		reserva.setMesa(mesa);

		return new ReservaDto(repository.save(reserva));
	}

	@Override
	public List<ReservaDto> buscarReservasPorCliente(Long idCliente) {
		List<ReservaEntity> reservasCliente = repository.findByClienteId(idCliente);
		return reservasCliente.stream().map(ReservaDto::new).toList();
	}

	@Override
	public ReservaDto atualizaReserva(Long id, StatusEnum status) {
		Optional<ReservaEntity> reservaEntity = repository.findById(id);
		if (reservaEntity.isPresent()) {
			validaReservaConcluida(status, reservaEntity.get().getDataReserva());
			validaReservaCancelada(status, reservaEntity.get().getDataReserva());
			reservaEntity.get().atualizarStatus(status);
			var entidadePersistida = repository.save(reservaEntity.get());
			return new ReservaDto(entidadePersistida);
		}
		return null;

	}

//	@Override
//	public String buscarSeTemReservaNaMesaPorData(LocalDate dataReserva, Integer numeroMesa) {
//		List<ReservaEntity> reservasExistentes = getReservaPorNumeroMesa(numeroMesa, dataReserva);
//		if (!reservasExistentes.isEmpty()) {
//			return "Existe uma reserva para está data na mesa " + numeroMesa;
//		}
//		return "Não existe uma reserva para está data na mesa" + numeroMesa;
//	}
//
	public void validaDataReserva(ReservaDto reserva) {
		if (reserva.getDataReserva().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("A data de reserva não pode ser uma data no passado");
		}
	}

//	public void validaReservaNaMesmaData(ReservaDto reserva) {
//		List<ReservaEntity> reservasExistentes = getReservaPorNumeroMesa(reserva.getNumeroMesa(),
//				reserva.getDataReserva());
//		boolean reservasFeitas = reservasExistentes.stream()
//				.anyMatch(reservaExistente -> reservaExistente.getStatus().equals(StatusEnum.FEITA));
//		if (Objects.nonNull(reservasExistentes) && reservasFeitas) {
//			if (!reservasExistentes.isEmpty()) {
//				throw new IllegalArgumentException("Já existe uma reserva da mesa para está data");
//			}
//		}
//	}

	public void validaReservaConcluida(StatusEnum status, LocalDate dataReserva) {
		if (status == StatusEnum.CONCLUIDA
				&& (dataReserva.isBefore(LocalDate.now()))) {
			throw new IllegalArgumentException(
					"A reserva só pode ser alterada para concluida caso a data seja igual a da reserva ou após");
		}

	}

	public void validaReservaCancelada(StatusEnum status, LocalDate dataReserva) {
		if (status == StatusEnum.CANCELADA
				&& dataReserva.equals(LocalDate.now())
				|| dataReserva.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("A reserva só pode ser cancelada com no máximo 1 dia de antecedência");
		}

	}

//	public List<ReservaEntity> getReservaPorNumeroMesa(int numMesa, LocalDate dataReserva) {
//		List<ReservaEntity> reservaPorId = repository.findByNumeroMesaAndDataReserva(numMesa, dataReserva);
//		return reservaPorId;
//	}

	
}
