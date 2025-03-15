package com.bestrada.springboot.webflux.app.models.services;

import com.bestrada.springboot.webflux.app.models.documents.Solicitud;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolicitudService {
	
	public Flux<Solicitud> findAll();
	
	public Mono<Solicitud> findById(String id);
	
	public Mono<Solicitud> findByCodigo(String codigo); 
	
	public Mono<Solicitud> save(Solicitud solicitud);
	
	public Mono<Void> delete(Solicitud solicitud);

	public Mono<String> findLastCodigo();
	
}
