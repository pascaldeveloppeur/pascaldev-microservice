package org.dev.dto;

import java.util.Date;

import org.dev.model.Gender;
import org.dev.model.Member;
import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class MemberDTO {
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private Gender gender;
	private Date dateDeNaissance;
	private String password;
	
	 public static MemberDTO fromMembre(Member member){
	        ModelMapper modelMapper = new ModelMapper();
	        MemberDTO membreDTO = modelMapper.map(member, MemberDTO.class);
	        return membreDTO;
	    }

	    public static Member fromMembreDTO(MemberDTO membreDTO){
	        ModelMapper modelMapper = new ModelMapper();
	        Member member = modelMapper.map(membreDTO, Member.class);
	        return member;
	    }

}
