package org.dev.controller;

import java.util.List;
import java.util.Optional;

import org.dev.model.Member;
import org.dev.model.MemberException;
import org.dev.model.Registration;
import org.dev.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/registration")
@Slf4j
public class RegistrationController {
	
	@Autowired
	
	RegistrationService service;
	

	@GetMapping("/registrations")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllRegistrations(){
		
        log.debug("Call of get member by memberType : {}");
		
		try {
			log.trace("Found : {}", "");
			List<Registration> registrations = service.getAlls();
			return  ResponseEntity.status(HttpStatus.OK).body(registrations);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}

	}
	
	@GetMapping("/members")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getAllMembers(){
		
        log.debug("Call of get member by memberType : {}");
		
		try {
			log.trace("Found : {}", "");
			List<Member> members = service.getAllMembers();
			return  ResponseEntity.status(HttpStatus.OK).body(members);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}

	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createRegistration(@RequestBody Registration registration) {
		
		  log.debug("Call of create member : {}", registration);
		
		try {
			log.trace("Save : {}", "");
			Registration _registration = service.save(registration);
			return  ResponseEntity.status(HttpStatus.OK).body(_registration);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
		
	}
	

}
