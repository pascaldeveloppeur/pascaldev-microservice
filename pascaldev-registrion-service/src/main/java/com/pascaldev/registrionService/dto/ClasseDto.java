package com.pascaldev.registrionService.dto;

import org.modelmapper.ModelMapper;

import com.pascaldev.registrionService.model.Classe;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClasseDto {

	private Long id;
	private String name;

	public static ClasseDto fromClasse(Classe classe) {

		ModelMapper modelMapper = new ModelMapper();
		ClasseDto classeDto = modelMapper.map(classe, ClasseDto.class);
		return classeDto;
	}

	public static Classe fromClasseDto(ClasseDto classeDto) {
		ModelMapper modelMapper = new ModelMapper();
		Classe classe = modelMapper.map(classeDto, Classe.class);
		return classe;
	}
}
