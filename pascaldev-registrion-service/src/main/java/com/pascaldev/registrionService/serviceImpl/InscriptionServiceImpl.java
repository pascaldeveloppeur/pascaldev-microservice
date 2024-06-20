package com.pascaldev.registrionService.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pascaldev.pascaldev_utild_service.model.PascalDevException;
import com.pascaldev.registrionService.dto.InscriptionDto;
import com.pascaldev.registrionService.model.Inscription;
import com.pascaldev.registrionService.repository.InscriptionRepository;
import com.pascaldev.registrionService.service.InscriptionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InscriptionServiceImpl implements InscriptionService<InscriptionDto> {
	
	private final InscriptionRepository inscriptionRepository;

	@Override
	public InscriptionDto getById(Long id) {
		log.trace("try to get inscription by id  : {}", id);

		try {
			Optional<Inscription> inscription = inscriptionRepository.findById(id);
			if (!inscription.isPresent()) {
				log.trace("this inscription does not exist");
				return null;
			}
			Inscription newInscription = inscription.get();
			return InscriptionDto.fromInscription(newInscription);
		} catch (PascalDevException e) {
//			String message = messageSource.getMessage("not found user",new Object[] {user}, locale);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "not found inscription");
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<InscriptionDto> getAll() {
		log.trace("try  to find all courses");
		Page<Inscription> items = inscriptionRepository.findAll(PageRequest.of(0, 5));
		List<Inscription> inscriptions = items.getContent();
		if (inscriptions.isEmpty()) {
			log.trace("this list is empty");
			return null;
		}
		List<InscriptionDto> inscriptionDtos = new ArrayList<>();
		for (Inscription inscription : inscriptions) {
			inscriptionDtos.add(InscriptionDto.fromInscription(inscription));
		}
		return inscriptionDtos;
	}

	@Override
	public InscriptionDto save(InscriptionDto inscriptionDto) {
		log.trace("try to save inscription : {}", inscriptionDto);

		try {
			if (inscriptionDto == null) {
				throw new PascalDevException("unable.save.null.inscription");
			}
			if (!StringUtils.hasText(inscriptionDto.getStudentName())) {
				throw new PascalDevException("unable.save.inscription.with.empty.name");
			}
			Optional<Inscription> inscription = inscriptionRepository.findById(InscriptionDto.fromInscriptionDto(inscriptionDto).getId());
			if (inscription.isPresent()) {
				log.trace("this inscription already exist");
				return null;
			}
			Inscription newInscription = inscriptionRepository.save(InscriptionDto.fromInscriptionDto(inscriptionDto));
			return InscriptionDto.fromInscription(newInscription);

		} catch (PascalDevException e) {
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error while save inscription : {}", inscriptionDto, e);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "unable.to.save.inscription");
		}
	}

	@Override
	public InscriptionDto update(Long id, InscriptionDto inscriptionDto) {
		Inscription  inscription = InscriptionDto.fromInscriptionDto(getById(id));
		if (inscription == null) {
			throw new PascalDevException("unable.to.update.null.inscription");

		}
		inscription.setStudentName(inscriptionDto.getStudentName());
		//course.setSubjects(courseDto.getSubjects());

		InscriptionDto savedInscriptionDto = save(InscriptionDto.fromInscription(inscription));

		return savedInscriptionDto;
	}

	@Override
	public void deleteById(Long id) {
		log.trace("try to delete inscription by id: {}", id);
		try {
			if (id == null) {
				throw new PascalDevException("unable.to.delete.null.inscription");
			}
			inscriptionRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteAll() {
		log.trace("try to delete allInscription : {}");

		inscriptionRepository.deleteAll();
		
	}

//	@Override
//	public InscriptionDto save(InscriptionDto t) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
