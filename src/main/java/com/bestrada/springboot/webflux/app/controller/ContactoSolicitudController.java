package com.bestrada.springboot.webflux.app.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestrada.springboot.webflux.app.models.dao.ContactoSolicitudDAO;
import com.bestrada.springboot.webflux.app.models.documents.ContactoSolicitud;
import com.bestrada.springboot.webflux.app.models.documents.Solicitud;
import com.bestrada.springboot.webflux.app.models.services.ContactoSolicitudService;
import com.bestrada.springboot.webflux.app.models.services.SolicitudService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/api/contacto", "/api/contacto/"})
public class ContactoSolicitudController {
	
	private final ContactoSolicitudDAO contactoSolicitudDAO;
	
	@Autowired
	private ContactoSolicitudService service;
	private SolicitudService solicitudService;
	
	private static final Logger log = LoggerFactory.getLogger(ContactoSolicitudController.class);
	
	ContactoSolicitudController(
			ContactoSolicitudDAO contactoSolicitudDAO
			,SolicitudService solicitudService
	) {
        this.contactoSolicitudDAO = contactoSolicitudDAO;
        this.solicitudService = solicitudService;
    }
	
	@GetMapping()
	public Mono<ResponseEntity<Flux<ContactoSolicitud>>> listar() {		
		return Mono.just(
				ResponseEntity.ok()
				.contentType( MediaType.APPLICATION_JSON_UTF8 )
				.body( service.findAll())
		);
	}

	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<ContactoSolicitud>> getSolicitudByCodigo(@PathVariable("id") String id) {
		return service.findById(id).map( s -> ResponseEntity.ok()
				.contentType( MediaType.APPLICATION_JSON_UTF8 )
				.body(s))
				.defaultIfEmpty( ResponseEntity.notFound().build()
		);
	}
	
	@PostMapping
	public Mono<ResponseEntity<Map<String, Object>>> crear(@RequestBody ContactoSolicitud contactoSolicitud) {
		
	    String solicitudId = (contactoSolicitud.getSolicitudId() != null) ? contactoSolicitud.getSolicitudId().toString() : "";

	    return solicitudService.findById(solicitudId)
	        .flatMap(solicitud -> service.save(contactoSolicitud)
	            .map(saved -> {
	                Map<String, Object> response = new HashMap<>();
	                response.put("success", true);
	                response.put("mensaje", "Contacto creado exitosamente");
	                response.put("id", saved.getId());
	                return ResponseEntity.status(HttpStatus.CREATED).body(response);
	            })
	        )
	        .defaultIfEmpty(
	                ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(new HashMap<>(Map.of(
	                    		 "mensaje", "La solicitud con el ID " + solicitudId + " no existe.",
	                             "success", false
	                    )))
	        );
	}

	
	
}
