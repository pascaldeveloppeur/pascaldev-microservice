package com.pascaldev.registrionService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.pascaldev_utild_service.model.PascalDevException;
import com.pascaldev.registrionService.dto.ClasseDto;
import com.pascaldev.registrionService.serviceImpl.ClasseServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/classes")
@Slf4j
@RequiredArgsConstructor

public class ClasseController {
	
	private final ClasseServiceImpl classeServiceImpl;
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getClasse(@PathVariable("id") Long id) {

		log.debug("Call of get classe by id : {}", id);

		try {
			log.trace("Found : {}", "");
			ClasseDto classeDto = classeServiceImpl.getById(id);

			return ResponseEntity.status(HttpStatus.OK).body(classeDto);
		} catch (PascalDevException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllClasses(){
		 log.debug("Call of get classe  : {}");
			
			try {
				log.trace("Found : {}", "");
				List<ClasseDto> classeDtos = classeServiceImpl.getAll();
				return  ResponseEntity.status(HttpStatus.OK).body(classeDtos);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createUser(@RequestBody ClasseDto classeDto){
		
		  log.debug("Call of create classe : {}", classeDto);
			
			try {
				log.trace("Save : {}", "");
				ClasseDto newClasseDto = classeServiceImpl.save(classeDto);
				return  ResponseEntity.status(HttpStatus.OK).body(newClasseDto);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ClasseDto> updateClasse(@PathVariable("id") Long id, @RequestBody ClasseDto classeDto){
		
		 log.debug("Call of update classe : {}", id);
			try {
				ClasseDto newClasseDto = classeServiceImpl.update(id, classeDto);
				return new ResponseEntity<>(newClasseDto, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteClasse(@PathVariable("id") Long id){
		 log.debug("Call of delete classe : {}", id);
			
			try {
				
				classeServiceImpl.deleteById(id);
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			} catch (PascalDevException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@DeleteMapping("/delete-all")
	public ResponseEntity<?> deleteAllsClasses(){
		 log.debug("Call of delete all ");
			try {
				classeServiceImpl.deleteAll();
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

}
