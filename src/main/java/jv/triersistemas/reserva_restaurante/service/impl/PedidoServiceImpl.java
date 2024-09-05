package jv.triersistemas.reserva_restaurante.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.reserva_restaurante.dto.PedidoDto;
import jv.triersistemas.reserva_restaurante.entity.ClienteEntity;
import jv.triersistemas.reserva_restaurante.entity.PedidoEntity;
import jv.triersistemas.reserva_restaurante.entity.ReservaEntity;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;
import jv.triersistemas.reserva_restaurante.repository.PedidoRepository;
import jv.triersistemas.reserva_restaurante.repository.ReservaRepository;
import jv.triersistemas.reserva_restaurante.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public PedidoDto adicionarPedido(PedidoDto novoPedido) {
		ReservaEntity reserva = reservaRepository.findById(novoPedido.getIdReserva())
				.orElseThrow(() -> new IllegalArgumentException("Reserva não encontrado"));
		
		validaDataPedido(reserva);
		validaStatusReserva(reserva);
		PedidoEntity pedido = new PedidoEntity(novoPedido);
		pedido.setReserva(reserva);
		return new PedidoDto(repository.save(pedido));
	}
	
	public void validaDataPedido(ReservaEntity reserva) {
		if(!reserva.getDataReserva().equals(LocalDate.now()) || reserva.getDataReserva().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Não pode adicionar um pedido a uma reserva com data anterior a de hoje");
		}
	}
	
	public void validaStatusReserva(ReservaEntity reserva) {
		if(!reserva.getStatus().equals(StatusEnum.AGENDADA)) {
			throw new IllegalArgumentException("Somente pode adicionar pedidos a uma reserva com status de Agendada");
		}
	}

}
