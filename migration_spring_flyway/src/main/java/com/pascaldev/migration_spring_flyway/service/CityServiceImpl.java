package com.pascaldev.migration_spring_flyway.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.CityRequestDto;
import com.pascaldev.migration_spring_flyway.models.City;
import com.pascaldev.migration_spring_flyway.repository.CityRepository;

import jakarta.transaction.Transactional;

@Service
public class CityServiceImpl implements CityService {
	private final CityRepository cityRepository;
	
    @Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public City addCity(CityRequestDto cityResquestDto) {
		City city = new City();
		city.setName(cityResquestDto.getName());
		return cityRepository.save(city);
	}

	@Override
	public List<City> getCities() {
		List<City> cities = new ArrayList<>();
		cityRepository.findAll().forEach(cities::add);
		return cities;
	}

	@Override
	public City getCity(Long cituId) {
		
		return cityRepository.findById(cituId).orElseThrow(() ->
		new IllegalArgumentException("city with cityId:" + cituId + "could not be found"));
	}
	

	@Override
	public City deleteCity(Long cituId) {
		City city = getCity(cituId);
		cityRepository.delete(city);
		return city;
	}
     @Transactional 
	@Override
	public City editCity(Long cituId, CityRequestDto cityRequestDto) {
		City cityToEdit = getCity(cituId);
		cityToEdit.setName(cityRequestDto.getName());
		return cityToEdit;
	}

}
