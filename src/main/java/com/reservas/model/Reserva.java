package com.reservas.model;


import javax.persistence.*;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Mesa mesa;

	@Column(name = "date",nullable = false)
	private String fecha;

	@Column(name = "time", nullable = false)
	private String hora;

	@Column(name = "number_people", length = 10, nullable = false)
	private String cantidadDePersonas;

	@Column(name = "comment", length = 100, nullable = false)
	private String Comentario;

	public Reserva(Long id, String fecha, String hora, String cantidadDePersonas, String comentario) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadDePersonas = cantidadDePersonas;
		Comentario = comentario;
	}

	public Reserva() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCantidadDePersonas() {
		return cantidadDePersonas;
	}

	public void setCantidadDePersonas(String cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", cantidadDePersonas="
				+ cantidadDePersonas + ", Comentario=" + Comentario + "]";
	}

	
}
