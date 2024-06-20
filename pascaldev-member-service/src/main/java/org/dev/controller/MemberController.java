package org.dev.controller;


import java.util.List;
import java.util.Optional;

import org.dev.dto.MemberDTO;
import org.dev.model.Member;
import org.dev.model.MemberException;
import org.dev.serviceImpl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class MemberController {
	
	  
	private final MemberServiceImpl memberService;
	
	@GetMapping("/members/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getMember(@PathVariable("id") Long id) {
		
		log.debug("Call of get member by id : {}", id);
		
		try {
			log.trace("Found : {}", "");
			MemberDTO memberDTO = memberService.findById(id);
			
			return  ResponseEntity.status(HttpStatus.OK).body(memberDTO);
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
			List<MemberDTO> memberDTOs = memberService.findAll();
			return  ResponseEntity.status(HttpStatus.OK).body(memberDTOs);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}

	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createMember(@RequestBody MemberDTO memberDTO) {
		
		  log.debug("Call of create member : {}", memberDTO);
		
		try {
			log.trace("Save : {}", "");
			MemberDTO newMemberDTO = memberService.save(memberDTO);
			return  ResponseEntity.status(HttpStatus.OK).body(newMemberDTO);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MemberDTO> updateMember(@PathVariable("id") Long id, 
			@RequestBody MemberDTO memberDTO){
		
		 log.debug("Call of update member : {}", id);
		try {
			MemberDTO memberDTO1 = memberService.update(id,memberDTO);
			return new ResponseEntity<>(memberDTO1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMemberById(@PathVariable("id") Long id) {
		
		  log.debug("Call of delete member : {}", id);
			
			try {
				
				memberService.delete(id);
				return  ResponseEntity.status(HttpStatus.OK).body(true);
			} catch (MemberException e) {
				log.debug(e.getMessage());
				return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
			}
	}
	
	@DeleteMapping("/delete-all")
	public ResponseEntity<?> deleteMembers() {
		 log.debug("Call of delete all ");
		try {
			memberService.deleteMembers();
			return  ResponseEntity.status(HttpStatus.OK).body(true);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
