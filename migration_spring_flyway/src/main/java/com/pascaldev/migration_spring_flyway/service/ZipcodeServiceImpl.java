package com.pascaldev.migration_spring_flyway.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.ZipcodeResquestDto;
import com.pascaldev.migration_spring_flyway.models.City;
import com.pascaldev.migration_spring_flyway.models.ZipCode;
import com.pascaldev.migration_spring_flyway.repository.ZipcodeRepository;

import jakarta.transaction.Transactional;

@Service
public class ZipcodeServiceImpl implements ZipcodeService{

	private final ZipcodeRepository zipcodeRepository;
	private final CityService cityService;
	
	@Autowired
	public ZipcodeServiceImpl(ZipcodeRepository zipcodeRepository, CityService cityService) {
		
		this.zipcodeRepository = zipcodeRepository;
		this.cityService = cityService;
	}

	@Transactional
	@Override
	public ZipCode addZipcode(ZipcodeResquestDto zipcodeResquestDto) {
		ZipCode zipCode = new ZipCode();
		zipCode.setName(zipcodeResquestDto.getName());
		if(zipcodeResquestDto.getCityId() == null) {
			return zipcodeRepository.save(zipCode);
		}
		City city = cityService.getCity(zipcodeResquestDto.getCityId());
		zipCode.setCity(city);
		return zipcodeRepository.save(zipCode);
	}

	@Override
	public List<ZipCode> getZipcodes() {
		
		return StreamSupport
				.stream(zipcodeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList() );
	}

	@Override
	public ZipCode getZipcode(Long zipcodeId) {
		
		return zipcodeRepository.findById(zipcodeId).orElseThrow(() ->
		new IllegalArgumentException("zipcode with id: " + zipcodeId + "could not be found"));
	}

	@Override
	public ZipCode deleteZipCode(Long zipcodeId) {
		ZipCode zipCode = getZipcode(zipcodeId);
		zipcodeRepository.delete(zipCode);
		return zipCode;
	}
    @Transactional
	@Override
	public ZipCode editZipCode(Long zipcodeId, ZipcodeResquestDto zipcodeResquestDto) {
		ZipCode zipcodeToEdit = getZipcode(zipcodeId);
		zipcodeToEdit.setName(zipcodeResquestDto.getName());
		if(zipcodeResquestDto.getCityId()!= null) {
			return zipcodeToEdit;
		}
		City city = cityService.getCity(zipcodeResquestDto.getCityId());
		zipcodeToEdit.setCity(city);
		return zipcodeToEdit;
	}
    
    @Transactional
	@Override
	public ZipCode addToZipCode(Long zipcodeId, Long cityId) {
		ZipCode zipCode = getZipcode(zipcodeId);
		City city = cityService.getCity(cityId);
		if(Objects.nonNull(zipCode.getCity())) {
			throw new IllegalArgumentException("zipcode already has a city");
		}
				return zipCode;
	}

    @Transactional
	@Override
	public ZipCode removeCityFromZipCode(Long zicodeId) {
		ZipCode zipCode = getZipcode(zicodeId);
		if(!Objects.nonNull(zipCode.getCity())) {
			throw new IllegalArgumentException("zipcode does  not has a city");
		}
		zipCode.setCity(null);
				return zipCode;
	}

}
