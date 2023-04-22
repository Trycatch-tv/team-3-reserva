package com.reservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mesa {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		@NotBlank(message = "Debe ingresar en nombre completo" )
		@Size(min = 2, max = 20,message = "Mínimo 5 caracteres y máximo 50")
	    @Column(name = "name",unique = true)
	    private String nombre_completo;


		//@NotBlank(message = "El teléfono es obligatorio")
		@NotNull(message = "La capacidad no puede ser nula")
		@NotEmpty(message = "La capacidad no puede vacia")
		//@Size(min = 1, max =2,message = "Número entre 1 y 99")
		@Pattern(regexp = "^[0-9]{1,2}$", message = "Solo númeeros")
	    @Column(name = "capacidad",nullable = false)
	    private int capacidad;

		@NotBlank(message = "El teléfono es obligatorio")
		@Size(min = 3, max = 50,message = "Mínimo 3 caracteres y máximo 50")
	    @Column(name = "location",length = 100,nullable = false)
	    private String ubicacion;

		@Size(min = 3, max = 50,message = "Mínimo 3 caracteres y máximo 50")
	    @Column(name = "comment",length = 255,nullable = true)
	    private String comentario;

		@CreationTimestamp
		@Column(name = "created_at", updatable = false)
		private Date created;

		@UpdateTimestamp
		@Column(name = "updated_at",updatable = true)
		private Date updated;

		@JsonIgnore
	    @OneToMany(mappedBy = "mesa")
	    private List<Reserva> reserva;

}
