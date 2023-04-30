package com.reservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;



@Setter
@Getter
@ToString
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
