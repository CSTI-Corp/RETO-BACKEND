package com.bestrada.springboot.webflux.app;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bestrada.springboot.webflux.app.models.dao.SolicitudDAO;
import com.bestrada.springboot.webflux.app.models.documents.ContactoSolicitud;
import com.bestrada.springboot.webflux.app.models.documents.Solicitud;
import com.bestrada.springboot.webflux.app.models.services.SolicitudService;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class RetoWebfluxApplication implements CommandLineRunner {
	
	@Autowired
	private SolicitudService service;
	
	private static final Logger log = LoggerFactory.getLogger(RetoWebfluxApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RetoWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Flux.just(
			new Solicitud("PROD006", "MARCA2", "URGENTE", LocalDate.now(), "930856877", "Boris Estrada", List.of(new ContactoSolicitud(1L, "Juan Perez", "987654321")) )
		)
		.flatMap( solicitud -> dao.save(solicitud))
		.subscribe( solicitud -> log.info("Insert:" + solicitud.getCodigo() + " " + solicitud.getMarca() ));*/
		
	}
}
