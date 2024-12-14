package com.pascaldev.registrionService.serviceImpl;

import com.pascaldev.pascaldev_utild_service.model.PascalDevException;
import com.pascaldev.registrionService.dto.ClasseDto;
import com.pascaldev.registrionService.model.Classe;
import com.pascaldev.registrionService.repository.ClasseRepository;
import com.pascaldev.registrionService.service.ClasseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClasseServiceImpl implements ClasseService<ClasseDto> {
	
	private final ClasseRepository classeRepository;

	@Override
	public ClasseDto getById(Long id) {
		log.trace("try to get classe by id  : {}", id);

		try {
			Optional<Classe> classe = classeRepository.findById(id);
			if (!classe.isPresent()) {
				log.trace("this classe does not exist");
				return null;
			}
			Classe newClasse = classe.get();
			return ClasseDto.fromClasse(newClasse);
		} catch (PascalDevException e) {
//			String message = messageSource.getMessage("not found user",new Object[] {user}, locale);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "not found classe");
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ClasseDto> getAll() {
		log.trace("try  to find all courses");
		Page<Classe> items = classeRepository.findAll(PageRequest.of(0, 5));
		List<Classe> classes = items.getContent();
		if (classes.isEmpty()) {
			log.trace("this list is empty");
			return null;
		}
		List<ClasseDto> classeDtos = new ArrayList<>();
		for (Classe classe : classes) {
			classeDtos.add(ClasseDto.fromClasse(classe));
		}
		return classeDtos;
	}

	@Override
	public ClasseDto save(ClasseDto classeDto) {
		log.trace("try to save classe : {}", classeDto);

		try {
			if (classeDto == null) {
				throw new PascalDevException("unable.save.null.classe");
			}
			if (!StringUtils.hasText(classeDto.getName())) {
				throw new PascalDevException("unable.save.classe.with.empty.name");
			}
			Optional<Classe> classe = classeRepository.findById(ClasseDto.fromClasseDto(classeDto).getId());
			if (classe.isPresent()) {
				log.trace("this classe already exist");
				return null;
			}
			Classe newClasse = classeRepository.save(ClasseDto.fromClasseDto(classeDto));
			return ClasseDto.fromClasse(newClasse);

		} catch (PascalDevException e) {
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error while save classe : {}", classeDto, e);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "unable.to.save.classe");
		}
	}

	@Override
	public ClasseDto update(Long id, ClasseDto classeDto) {
		Classe  classe = ClasseDto.fromClasseDto(getById(id));
		if (classe == null) {
			throw new PascalDevException("unable.to.update.null.classe");

		}
		classe.setName(classeDto.getName());
		//course.setSubjects(courseDto.getSubjects());

		ClasseDto savedClasseDto = save(ClasseDto.fromClasse(classe));

		return savedClasseDto;
	}

	@Override
	public void deleteById(Long id) {
		log.trace("try to delete classe by id: {}", id);
		try {
			if (id == null) {
				throw new PascalDevException("unable.to.delete.null.classe");
			}
			classeRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void deleteAll() {
		log.trace("try to delete allClasse : {}");

		classeRepository.deleteAll();
	}

}
