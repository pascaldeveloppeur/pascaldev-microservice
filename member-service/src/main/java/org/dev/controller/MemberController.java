package org.dev.controller;


import java.util.List;
import java.util.Optional;

import org.dev.model.Member;
import org.dev.model.MemberException;
import org.dev.service.MemberService;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	  @Autowired
	 MemberService memberService;
	
	@GetMapping("/members/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getMember(@PathVariable("id") Long id) {
		
		log.debug("Call of get member by id : {}", id);
		
		try {
			log.trace("Found : {}", "");
			Optional<Member> member = memberService.getMemberById(id);
			
			return  ResponseEntity.status(HttpStatus.OK).body(member);
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
			List<Member> members = memberService.getAllMembers();
			return  ResponseEntity.status(HttpStatus.OK).body(members);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}

	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createMember(@RequestBody Member member) {
		
		  log.debug("Call of create member : {}", member);
		
		try {
			log.trace("Save : {}", "");
			Member _member = memberService.saveMember(member);
			return  ResponseEntity.status(HttpStatus.OK).body(_member);
		} catch (MemberException e) {
			log.debug(e.getMessage());
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, 
			@RequestBody Member member){
		Optional<Member> memberData = memberService.getMemberById(id);
		
		if(memberData.isPresent()) {
			Member _member = memberData.get();
			_member.setFirstName(member.getFirstName());
			_member.setLastName(member.getLastName());
			_member.setUsername(member.getUsername());
			_member.setEmail(member.getEmail());
			return new ResponseEntity<>(memberService.saveMember(_member), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMemberById(@PathVariable("id") Long id) {
		
		  log.debug("Call of delete member : {}", id);
			
			try {
				
				memberService.deleteMember(id);
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
