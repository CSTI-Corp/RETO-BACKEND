package com.bestrada.springboot.webflux.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestrada.springboot.webflux.app.models.dao.ContactoSolicitudDAO;
import com.bestrada.springboot.webflux.app.models.documents.ContactoSolicitud;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactoSolicitudServiceImpl implements ContactoSolicitudService{
	
	@Autowired
	private ContactoSolicitudDAO dao;

	@Override
	public Flux<ContactoSolicitud> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<ContactoSolicitud> findById(String id) {
		Long idLong = Long.parseLong(id);
		return dao.findById(idLong);
	}

	@Override
	public Mono<ContactoSolicitud> save(ContactoSolicitud contactoSolicitud) {
		return dao.save( contactoSolicitud );
	}

	@Override
	public Mono<Void> delete(ContactoSolicitud contactoSolicitud) {
		return null;
	}

}
