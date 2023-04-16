package com.reservas.model;

import java.util.List;

import javax.persistence.*;


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

	public Cliente(Long id, String nombre_completo, String telefono, String correo, String comentario,
			List<Reserva> reserva) {
		this.id = id;
		this.nombre_completo = nombre_completo;
		this.telefono = telefono;
		this.correo = correo;
		this.comentario = comentario;
		this.reserva = reserva;
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre_completo=" + nombre_completo + ", telefono=" + telefono + ", correo="
				+ correo + ", comentario=" + comentario + ", reserva=" + reserva + "]";
	}

	
}
