package org.dev.service;


import java.util.List;
import java.util.Optional;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.dev.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;





@Service
@Slf4j
public class MemberService {
	
	@Autowired
	 MemberRepo memberRepository;
	
	public Optional<Member> getMemberById(Long id) {
		Optional<Member> member = memberRepository.findById(id);
		if(!member.isPresent()) {
			log.trace("this member does not exist");
			return null;
		}
		return member;
	}
	
	public List<Member> getAllMembers(){
		
		log.trace("try  to find all members");
		Page<Member> items=  memberRepository.findAll(PageRequest.of(0, 5));
		List<Member> memberlist= items.getContent();
		if(memberlist.isEmpty()) {
			log.trace("this list is empty");
			return null;
		}
		
		return memberlist ;
	}
	
//	public List<Member> getAllMembersByUserName(String userName){
//		
//		log.trace("try to find members by memberType");
//		if(type.name().isEmpty()) {
//			log.trace("this member does not exist");
//			return null;
//		}
//		List<Member> lisMember= memberRepository.findAllMemberBymemberType(type);
//		
//		return lisMember ;
//	}
	
	public Member saveMember(Member member) {
		
		log.trace("try to save member");
		Optional<Member> item = getMemberById(member.getId());
		
		if(item.isPresent()) {
			log.trace("this member already exist");
		}
		Member member1 = memberRepository.save(member);
		return member1;
	}
	
	public void deleteMember(Long id) {
		log.trace("try to delete member by id");
		log.trace("try to save member");
		Optional<Member> item = getMemberById(id);
		
		if(!item.isPresent()) {
			log.trace("object is not present ");
			
		}
		memberRepository.deleteById(id);
		
	}
	public void deleteMembers() {
		log.trace("try to delete all member ");
		memberRepository.deleteAll();
	}

}
