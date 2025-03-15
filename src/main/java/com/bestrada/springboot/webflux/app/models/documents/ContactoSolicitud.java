package com.bestrada.springboot.webflux.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("contactos_solicitud")
public class ContactoSolicitud {
	@Id
	private Long id;
	private Long solicitudId;
	private String nombreContacto;
	private String numeroContacto;
    
	public ContactoSolicitud() {
		super();
	}

	public ContactoSolicitud(Long solicitudId, String nombreContacto, String numeroContacto) {
		super();
		this.solicitudId = solicitudId;
		this.nombreContacto = nombreContacto;
		this.numeroContacto = numeroContacto;
	}
	
	//GETTERS AND SETTERS

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSolicitudId() {
		return solicitudId;
	}
	
	public void setSolicitudId(Long solicitudId) {
		this.solicitudId = solicitudId;
	}
	
	public String getNombreContacto() {
		return nombreContacto;
	}
	
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	
	public String getNumeroContacto() {
		return numeroContacto;
	}
	
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}  
    
}
