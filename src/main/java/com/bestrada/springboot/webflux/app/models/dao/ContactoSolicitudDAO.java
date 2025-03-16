package com.bestrada.springboot.webflux.app.models.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bestrada.springboot.webflux.app.models.documents.ContactoSolicitud;

import reactor.core.publisher.Flux;

public interface ContactoSolicitudDAO extends ReactiveCrudRepository<ContactoSolicitud, Long>{
	
	Flux<ContactoSolicitud> findBySolicitudId(Long solicitudId);
}
