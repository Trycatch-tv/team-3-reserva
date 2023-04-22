package com.reservas.controller;

import com.reservas.model.Cliente;
import com.reservas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(clienteService.buscarClientePorId(id));
        }

        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente( @RequestBody @Valid Cliente cliente) {
        try {
            Cliente clienteCreado = clienteService.crearCliente(cliente);
            return ResponseEntity.ok(clienteCreado);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
        try {
            Cliente clienteExistente = clienteService.buscarClientePorId(id);

            if (cliente.getNombre_completo()!= null &&!cliente.getNombre_completo().isEmpty())
                clienteExistente.setNombre_completo(cliente.getNombre_completo());

            if (cliente.getComentario()!= null &&!cliente.getComentario().isEmpty())
            clienteExistente.setComentario(cliente.getComentario());

            if (cliente.getCorreo()!= null &&!cliente.getCorreo().isEmpty())
            clienteExistente.setCorreo(cliente.getCorreo());

            if (cliente.getTelefono()!= null &&!cliente.getTelefono().isEmpty())
            clienteExistente.setTelefono(cliente.getTelefono());


            clienteService.actualizarCliente(clienteExistente);

            return ResponseEntity.ok(clienteExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable Long id) {

        try {
            Cliente clienteEliminado = clienteService.buscarClientePorId(id);

            clienteService.eliminarCliente(id);
            return ResponseEntity.ok(clienteEliminado);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


}
