package org.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.dev.model.Registration;
import org.dev.repository.MemberRepo;
import org.dev.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegistrationService {
	
	@Autowired
	RegistrationRepository registrationRepo;
	
	@Autowired
	MemberRepo memberRepo;
	
	public List<Registration> getAlls(){
		
		log.trace("found all registration");
		return registrationRepo.findAll();
	}
	
	public List<Registration> getAllRegistrationByType(MemberType type){
		List<Registration> registrations = registrationRepo.findAllRegistrationBymemberStatus(type);
		if(!registrations.isEmpty()) {
			return registrations;
		}
		log.trace("aucun membres n'est inscrit");
		return null;
	}
	
	public List<Member> getAllMembersByType(MemberType type){
		List<Member> members = new ArrayList<>();
		if (!getAllRegistrationByType(type).isEmpty()) {
			getAllRegistrationByType(type).forEach(item ->{
				members.add(item.getMember());
			});
			return members;
		}
		
		log.trace("aucun membres n'est inscrit");
		return null;
	}
	
	public List<Member> getAllMembers(){
		List<Member> members = new ArrayList<>();
		 getAlls().forEach(i -> {
			 members.add(i.getMember());
		 });
		return members;
	}
	
	public Registration save(Registration registration) {
		
		Optional<Registration> registation1 = registrationRepo.findById(registration.getId()) ;
		if(registation1.isPresent()) {
			log.trace("vous êtes déjà inscrit");
			return registation1.get();
		}else {
			registration.setMember(memberRepo.findByusername(registration.getUserName()));
			
			return registrationRepo.save(registration);
		}
	}
	

}
