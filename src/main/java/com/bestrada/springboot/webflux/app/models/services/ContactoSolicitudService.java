package com.bestrada.springboot.webflux.app.models.services;

import com.bestrada.springboot.webflux.app.models.documents.ContactoSolicitud;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContactoSolicitudService {
	
	public Flux<ContactoSolicitud> findAll();
    
	public Mono<ContactoSolicitud> findById(String id);
       
	public Mono<ContactoSolicitud> save(ContactoSolicitud contactoSolicitud);
    
	public Mono<Void> delete(ContactoSolicitud contactoSolicitud);
	
}
