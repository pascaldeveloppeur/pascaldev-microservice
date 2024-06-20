package org.dev.dto;

import java.util.Date;

import org.dev.model.Member;
import org.dev.model.MemberType;
import org.dev.model.Registration;
import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class RegistrationDTO {

	private Long id;
	private Date registrationDate;
	private double amount;
	private String userName;
	private MemberType memberStatus;
	
	public static RegistrationDTO fromMembre(Registration registration){
        ModelMapper modelMapper = new ModelMapper();
        RegistrationDTO registrationDTO = modelMapper.map(registration, RegistrationDTO.class);
        return registrationDTO;
    }

    public static Registration fromMembreDTO(RegistrationDTO registrationDTO){
        ModelMapper modelMapper = new ModelMapper();
        Registration registration = modelMapper.map(registrationDTO, Registration.class);
        return registration;
    }
}
