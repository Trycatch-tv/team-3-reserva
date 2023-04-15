package com.reservas.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100,nullable = false)
    private String nombre_completo;


    @Column(name = "phone",length = 100,nullable = false)
    private String telefono;

    @Column(name = "email",length = 100,nullable = false)
    private String correo;

    @Column(name = "comment",length = 255,nullable = false)
    private String comentario;
    
     
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Reserva> reserva;


    public Cliente() {
    }
    public Cliente(Long id, String nombre_completo, String telefono, String correo, String comentario) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.telefono = telefono;
        this.correo = correo;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return ("Telefono " + this.getTelefono() +
                "email "  +
                this.getCorreo()
                + "comentario " + this.getComentario() +
                "Nomre " + this.getComentario());    }
}
