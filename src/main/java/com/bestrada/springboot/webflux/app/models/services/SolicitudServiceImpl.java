package com.bestrada.springboot.webflux.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bestrada.springboot.webflux.app.models.dao.SolicitudDAO;
import com.bestrada.springboot.webflux.app.models.documents.Solicitud;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SolicitudServiceImpl implements SolicitudService {
	
	@Autowired
	private SolicitudDAO dao;
	
	@Override
	public Flux<Solicitud> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Solicitud> findById(String id) {
		Long idLong = Long.parseLong(id);
		return dao.findById(idLong);
	}

	@Override
	public Mono<Solicitud> findByCodigo(String codigo) {
		return dao.findByCodigo(codigo);
	}
	
	@Override
	public Mono<String> findLastCodigo() {
		return dao.findLastCodigo();
	}

	@Override
	public Mono<Solicitud> save(Solicitud solicitud) {
		return dao.save( solicitud );
	}

	@Override
	public Mono<Void> delete(Solicitud solicitud) {
		return null;
	}
	
	



}
