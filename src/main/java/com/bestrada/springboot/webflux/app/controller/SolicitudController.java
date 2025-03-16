package com.bestrada.springboot.webflux.app.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
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
import com.bestrada.springboot.webflux.app.models.dao.SolicitudDAO;
import com.bestrada.springboot.webflux.app.models.documents.Solicitud;
import com.bestrada.springboot.webflux.app.models.services.SolicitudService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/api/solicitud", "/api/solicitud/"})
@CrossOrigin(origins = "*")
public class SolicitudController {

    private final SolicitudDAO solicitudDAO;
	
	@Autowired
	private SolicitudService service;
	
	private static final Logger log = LoggerFactory.getLogger(SolicitudController.class);


    SolicitudController(SolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

	
    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> listar() {
        return service.findAll()
                .collectList()
                .map(lista -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("success", true);
                    response.put("data", lista);
                    response.put("errMsj", "");
                    return ResponseEntity.ok().body(response);
                });
    }

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Solicitud>> getSolicitudById(@PathVariable("id") String id) {
		return service.findById(id).map( s -> ResponseEntity.ok()
				.contentType( MediaType.APPLICATION_JSON_UTF8 )
				.body(s))
				.defaultIfEmpty( ResponseEntity.notFound().build()
		);
	}
	
	
	/*@GetMapping("/{codigo}")
	public Mono<ResponseEntity<Solicitud>> getSolicitudByCodigo(@PathVariable("codigo") String id) {
		return service.findByCodigo(id).map( s -> ResponseEntity.ok()
				.contentType( MediaType.APPLICATION_JSON_UTF8 )
				.body(s))
				.defaultIfEmpty( ResponseEntity.notFound().build()
		);
	}*/
	
	@PostMapping
	public Mono<ResponseEntity<Map<String, Object>>> crear(@RequestBody Solicitud solicitud) {
	    return service.findByCodigo(solicitud.getCodigo())
    		.flatMap(existingSolicitud -> {
	            Map<String, Object> errorResponse = new HashMap<>();
	            errorResponse.put("mensaje", "Error: El código ya está en uso.");
	            return Mono.just(ResponseEntity
	                .status(HttpStatus.CONFLICT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(errorResponse));
	        })
	        .switchIfEmpty(	               
                generarCodigo().flatMap(nuevoCodigo -> {
	                solicitud.setCodigo(nuevoCodigo);
	                return service.save(solicitud)
	                    .map(saved -> {
	                    	Map<String, Object> response = new HashMap<>();
	                        response.put("success", true);
	                        response.put("errMsj", null);
	                        response.put("id", saved.getId());
	                        Map<String, Object> data = new HashMap<>();
	                        data.put("sMsj", "La solicitud se guardó satisfactoriamente");
	                        response.put("data", data);
	                        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	                    });
	            })
	        )
	        .defaultIfEmpty(
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new HashMap<>(Map.of(
                    		 "mensaje", "La solicitud con el ID " + solicitud.getCodigo() + " existe.",
                             "success", false
                 )))
	        );
	}
	
	
	private Mono<String> generarCodigo() {
	    return service.findLastCodigo()
	        .defaultIfEmpty("PROD0000")
	        .map(ultimoCodigo -> {
	            int numero = Integer.parseInt(ultimoCodigo.replace("PROD", ""));
	            return String.format("PROD%04d", numero + 1);
	        });
	}
	
	
}
