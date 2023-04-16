package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservas.model.Reserva;
import com.reservas.repository.IReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private IReservaRepository reservaRepository;
	
	 public List<Reserva> listarReservas() {
	        return reservaRepository.findAll();
	    }

	    public Reserva buscarReservaPorId(Long id) {
	        return reservaRepository.findById(id).get();
	    }

	    public Reserva crearReserva(Reserva reserva) {
	        return reservaRepository.save(reserva);
	    }

	    public Reserva actualizarReserva(Reserva reserva) {
	        return reservaRepository.save(reserva);
	    }

	    public void eliminarReserva(Long id) {

	        reservaRepository.deleteById(id);

	    }
}
