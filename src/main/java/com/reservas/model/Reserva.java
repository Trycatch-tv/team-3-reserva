package com.reservas.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "date_reservation")
	//@JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fecha;

	@NotNull(message = "No puede ser nulo")
	@Column(name = "time_reservation")
	private LocalTime hora;

	@NotNull(message = "No puede ser nulo")
	@NotBlank(message = "No puede ser blanco")
	@NotEmpty(message = "No puede quedar vacio")
	@Size(min = 1, max =2,message = "Número entre 1 y 99")
	@Pattern(regexp = "^[0-9]{1,2}$", message = "Solo númeeros")
	@Column(name = "number_people")
	private String cantidadDePersonas;

	@Size(min = 5, max = 100,message = "Mínimo 5 caracteres y máximo 100")
	@Column(name = "comment", nullable = true)
	private String Comentario;
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date created;

	@UpdateTimestamp
	private Date updated;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Mesa mesa;
}
