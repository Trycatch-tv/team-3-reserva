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

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date created;

	@UpdateTimestamp
	@Column(name = "updated_at",updatable = true)
	private Date updated;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reserva;


}
