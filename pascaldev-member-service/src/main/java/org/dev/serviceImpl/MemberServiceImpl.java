package org.dev.serviceImpl;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dev.dto.MemberDTO;
import org.dev.model.Member;
import org.dev.model.MemberException;
import org.dev.model.MemberType;
import org.dev.repository.MemberRepo;
import org.dev.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	
	private final MemberRepo memberRepository;
	
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

	@Override
	public MemberDTO save(MemberDTO memberDTO) {
		Member member = MemberDTO.fromMembreDTO(memberDTO);
		member.setDate(new Date());
		Member savedMember =  memberRepository.save(member);
		return MemberDTO.fromMembre(savedMember);
	}

	@Override
	public MemberDTO update(Long id,MemberDTO memberDTO) {
		
		Optional<Member> member = getMemberById(id);
		Member _member = member.get();
		if(member.isPresent()) {
			_member.setFirstName(memberDTO.getFirstName());
			_member.setLastName(memberDTO.getLastName());
			_member.setUsername(memberDTO.getUsername());
			_member.setEmail(memberDTO.getEmail());
			
		}else {
			new MemberException("not found member");
		}
		Member savedMember =  saveMember(_member);
		return MemberDTO.fromMembre(savedMember);
	}

	@Override
	public MemberDTO findById(Long id) {
		return memberRepository.findById(id)
        .map(MemberDTO::fromMembre)
        .orElseThrow(()-> new EntityNotFoundException("Pas de membre trouvé avec l'ID"+id));
	}

	@Override
	public List<MemberDTO> findAll() {
		 return memberRepository.findAll()
	                .stream()
	                .map(MemberDTO::fromMembre)
	                .collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		memberRepository.deleteById(id);
		
	}

	@Override
	public MemberDTO update(MemberDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

}
