package com.bestrada.springboot.webflux.app.models.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bestrada.springboot.webflux.app.models.documents.ContactoSolicitud;



public interface ContactoSolicitudDAO extends ReactiveCrudRepository<ContactoSolicitud, Long>{
	
	/*@Query("SELECT * FROM solicitud WHERE id = :solicitudId")
    Mono<Solicitud> findSolicitudById(Long solicitudId);*/
}
