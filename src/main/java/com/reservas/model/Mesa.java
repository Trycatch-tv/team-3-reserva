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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mesa {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", length = 100,nullable = false,unique = true)
	    private String nombre_completo;


	    @Column(name = "capacidad",length = 100,nullable = false)
	    private String capacidad;

	    @Column(name = "location",length = 100,nullable = false)
	    private String ubicacion;

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
