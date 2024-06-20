package com.pascaldev.registrionService.dto;

import org.modelmapper.ModelMapper;


import com.pascaldev.registrionService.model.Inscription;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InscriptionDto {
	
	private Long id;

	private String studentName;
	
	public static InscriptionDto fromInscription(Inscription inscription) {

		ModelMapper modelMapper = new ModelMapper();
		InscriptionDto inscriptionDto = modelMapper.map(inscription, InscriptionDto.class);
		return inscriptionDto;
	}

	public static Inscription fromInscriptionDto(InscriptionDto inscriptionDto) {
		ModelMapper modelMapper = new ModelMapper();
		Inscription inscription = modelMapper.map(inscriptionDto, Inscription.class);
		return inscription;
	}

}
