package com.bestrada.springboot.webflux.app.models.dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bestrada.springboot.webflux.app.models.documents.Solicitud;

import reactor.core.publisher.Mono;

public interface SolicitudDAO extends ReactiveCrudRepository<Solicitud, Long> {
	
	 Mono<Solicitud> findByCodigo(String codigo);
	 
	 @Query("SELECT codigo FROM solicitud ORDER BY id DESC LIMIT 1")
	 Mono<String> findLastCodigo();
	 
}
