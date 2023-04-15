package com.reservas.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservas.model.Mesa;
import com.reservas.repository.IMesaRepository;
import org.springframework.stereotype.Service;

@Service
public class MesaService {
	 @Autowired
	    private IMesaRepository mesaRepository;

	    public List<Mesa> listarMesas() {
	        return mesaRepository.findAll();
	    }

	    public Mesa buscarMesaPorId(Long id) {
	        return mesaRepository.findById(id).get();
	    }

	    public Mesa crearMesa(Mesa mesa) {
	        return mesaRepository.save(mesa);
	    }

	    public Mesa actualizarMesa(Mesa mesa) {
	        return mesaRepository.save(mesa);
	    }

	    public void eliminarMesa(Long id) {

	        mesaRepository.deleteById(id);

	    }
}
