package com.reservas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.model.Reserva;
import com.reservas.service.ReservaService;

@RestController
@CrossOrigin
@RequestMapping("/api/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@GetMapping("/")
	public ResponseEntity<List<Reserva>> listarReserva() {
		return ResponseEntity.ok(reservaService.listarReservas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(reservaService.buscarReservaPorId(id));
		}

		catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/")
	public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
		try {
			Reserva ReservaCreada = reservaService.crearReserva(reserva);
			return ResponseEntity.ok(ReservaCreada);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reserva> editarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
		try {
			Reserva reservaExistente = reservaService.buscarReservaPorId(id);
			if (reserva.getMesa() != null )
				reservaExistente.setMesa(reserva.getMesa());

			if (reserva.getCliente() != null  ) {
				reservaExistente.setCliente(reserva.getCliente());
			}
			
			if (reserva.getCantidadDePersonas() != null && !reserva.getCantidadDePersonas().isEmpty()  ) {
				reservaExistente.setCantidadDePersonas(reserva.getCantidadDePersonas());
			}
			
			if (reserva.getFecha() != null && !reserva.getFecha().isEmpty()    ) {
				reservaExistente.setFecha(reserva.getFecha());
			}
			
			if (reserva.getHora() != null && !reserva.getHora().isEmpty()   ) {
				reservaExistente.setHora(reserva.getHora());
			}
			
			if (reserva.getComentario() != null  && !reserva.getComentario().isEmpty() ) {
				reservaExistente.setComentario(reserva.getComentario());
			}
			
			reservaService.actualizarReserva(reservaExistente);
			

			return ResponseEntity.ok(reservaExistente);

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Reserva> eliminarReserva(@PathVariable Long id) {

		try {
			Reserva reservaEliminada = reservaService.buscarReservaPorId(id);
			reservaService.eliminarReserva(id);
			
			return ResponseEntity.ok(reservaEliminada);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
