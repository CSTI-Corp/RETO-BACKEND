package com.bestrada.springboot.webflux.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
import java.util.List;


@Table("solicitud")
public class Solicitud {
	
	@Id
    private Long id;
    private String codigo;
    private String marca;
    private String tipoSolicitud;
    private LocalDate fechaEnvio;
    private String numeroContacto;
    private String nombreContacto;
    
    public Solicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Solicitud(String codigo, String marca, String tipoSolicitud, LocalDate fechaEnvio, String numeroContacto,
			String nombreContacto, List<ContactoSolicitud> contactos) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.tipoSolicitud = tipoSolicitud;
		this.fechaEnvio = fechaEnvio;
		this.numeroContacto = numeroContacto;
		this.nombreContacto = nombreContacto;
	}

	//GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

}
