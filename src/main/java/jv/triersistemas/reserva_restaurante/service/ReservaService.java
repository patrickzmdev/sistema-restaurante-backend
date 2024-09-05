package jv.triersistemas.reserva_restaurante.service;

import java.time.LocalDate;
import java.util.List;

import jv.triersistemas.reserva_restaurante.dto.ReservaDto;
import jv.triersistemas.reserva_restaurante.enums.StatusEnum;

public interface ReservaService {
	ReservaDto adicionarReserva(ReservaDto novaReserva);
	
	List<ReservaDto> buscarReservasPorCliente(Long idCliente);

//	String buscarSeTemReservaNaMesaPorData(LocalDate dataReserva, Integer numeroMesa);

	ReservaDto atualizaReserva(Long id, StatusEnum status);
	
	void concluirReservaNaoFinalizada();

}
