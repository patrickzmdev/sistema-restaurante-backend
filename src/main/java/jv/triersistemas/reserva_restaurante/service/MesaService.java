package jv.triersistemas.reserva_restaurante.service;

import java.util.List;

import jv.triersistemas.reserva_restaurante.dto.MesaDto;

public interface MesaService {
	
	MesaDto adicionarMesa(MesaDto novaMesa);
	
	List<MesaDto> getTodasMesas();
	
	MesaDto atualizarMesa(Long id, MesaDto mesaAtualizada);
	
}
