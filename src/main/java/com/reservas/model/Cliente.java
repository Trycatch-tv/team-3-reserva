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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar en nombre completo" )
    @Size(min = 5, max = 50,message = "Mínimo 5 caracteres y máximo 50")
    @Column(name = "name")
    private String nombre_completo;


    /*@NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{10}$", message = "Son 10 dítigos")*/
    @Column(name = "phone")
    private String telefono;

    @NotNull
    @Email(message = "Correo inválido o existente")
    @Column(name = "email",unique = true)
    private String correo;

    @Size(max = 100, message = "El comentario no puede exceder los 100 caracteres")
    @Column(name = "comment")
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
