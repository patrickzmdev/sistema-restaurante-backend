package jv.triersistemas.reserva_restaurante.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.reserva_restaurante.dto.MesaDto;
import jv.triersistemas.reserva_restaurante.service.MesaService;

@RestController
@RequestMapping("/mesas")
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@PostMapping
	public MesaDto adicionarMesa(@RequestBody MesaDto novaMesa) {
		return mesaService.adicionarMesa(novaMesa);
	}
	
	@GetMapping
	public List<MesaDto> getTodasMesas(){
		return  mesaService.getTodasMesas();
	}
	
	@GetMapping("/busca")
	public List<MesaDto> buscarMesaPorDataECapacidadePessoas(@RequestParam Long idRestaurante, @RequestParam LocalDate data, @RequestParam Integer capacidadePessoas){
		return mesaService.buscarMesaPorDataECapacidadePessoas(idRestaurante, data, capacidadePessoas);
	}
	
	@PutMapping
	public MesaDto atualizarMesa(@PathVariable Long id, @RequestBody MesaDto mesaAtualizada) {
		return mesaService.atualizarMesa(id, mesaAtualizada);
	}
}
