package com.reservas.model;

import java.util.List;

import javax.persistence.*;
@Entity
public class Mesa {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", length = 100,nullable = false)
	    private String nombre_completo;


	    @Column(name = "capacidad",length = 100,nullable = false)
	    private String capacidad;

	    @Column(name = "location",length = 100,nullable = false)
	    private String ubicacion;

	    @Column(name = "comment",length = 255,nullable = false)
	    private String comentario;
	
	    @OneToMany(mappedBy = "mesa",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	    private List<Reserva> reserva;


	    public Mesa() {
	    }
	    public Mesa(Long id, String nombre_completo, String capacidad, String ubicacion, String comentario) {
	        this.id = id;
	        this.nombre_completo = nombre_completo;
	        this.capacidad = capacidad;
	        this.ubicacion = ubicacion;
	        this.comentario = comentario;
	    }

	   
	    
	    public Long getId() {
			return id;
		}
	    public String getNombre_completo() {
			return nombre_completo;
		}
	    
	    public String getCapacidad() {
			return capacidad;
		}
	    public String getUbicacion() {
			return ubicacion;
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
		public void setCapacidad(String capacidad) {
			this.capacidad = capacidad;
		}
		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}
		
		@Override
	    public String toString() {
	        return ("Capacidad: " + this.getCapacidad() +
	        		"ubicacion: "  + this.getUbicacion() + 
	        		"comentario: " + this.getComentario() +  
	        		"Nombre: " + this.getNombre_completo());   
	        }
	
}
