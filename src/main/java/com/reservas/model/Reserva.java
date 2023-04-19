package com.reservas.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "time", nullable = false)
	private LocalTime hora;

	@Column(name = "number_people", length = 10, nullable = false)
	private String cantidadDePersonas;

	@Column(name = "comment", length = 100, nullable = false)
	private String Comentario;
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date created;

	@UpdateTimestamp
	@Column(name = "updated_at", updatable = true)
	private Date updated;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Mesa mesa;
}
