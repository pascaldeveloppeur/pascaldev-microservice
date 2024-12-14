package com.pascaldev.registrionService.controller;

import com.pascaldev.pascaldev_utild_service.model.PascalDevException;
import com.pascaldev.registrionService.dto.InscriptionDto;
import com.pascaldev.registrionService.serviceImpl.InscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
@Slf4j
@RequiredArgsConstructor
public class InscriptionController {
	
	private final InscriptionServiceImpl inscriptionServiceImpl;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getInscription(@PathVariable("id") Long id) {

		log.debug("Call of get inscription by id : {}", id);

		try {
			log.trace("Found : {}", "");
			InscriptionDto inscriptionDto = inscriptionServiceImpl.getById(id);

			return ResponseEntity.status(HttpStatus.OK).body(inscriptionDto);
		} catch (PascalDevException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllInscriptions(){
		 log.debug("Call of get inscription  : {}");
			
			try {
				log.trace("Found : {}", "");
				List<InscriptionDto> inscriptionDtos = inscriptionServiceImpl.getAll();
				return  ResponseEntity.status(HttpStatus.OK).body(inscriptionDtos);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createUser(@RequestBody InscriptionDto inscriptionDto){
		
		  log.debug("Call of create user : {}", inscriptionDto);
			
			try {
				log.trace("Save : {}", "");
				InscriptionDto newInscriptionDto = inscriptionServiceImpl.save(inscriptionDto);
				return  ResponseEntity.status(HttpStatus.OK).body(newInscriptionDto);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<InscriptionDto> updateUser(@PathVariable("id") Long id, @RequestBody InscriptionDto inscriptionDto){
		
		 log.debug("Call of update inscription : {}", id);
			try {
				InscriptionDto newInscriptionDto = inscriptionServiceImpl.update(id, inscriptionDto);
				return new ResponseEntity<>(newInscriptionDto, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		 log.debug("Call of delete inscription : {}", id);
			
			try {
				
				inscriptionServiceImpl.deleteById(id);
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@DeleteMapping("/delete-all")
	public ResponseEntity<?> deleteAlls(){
		 log.debug("Call of delete all ");
			try {
				inscriptionServiceImpl.deleteAll();
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}
