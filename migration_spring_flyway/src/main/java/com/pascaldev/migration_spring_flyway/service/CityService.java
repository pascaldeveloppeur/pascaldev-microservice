package com.pascaldev.migration_spring_flyway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.CityRequestDto;
import com.pascaldev.migration_spring_flyway.models.City;

@Service
public interface CityService {

	public City addCity(CityRequestDto cityResquestDto);
	public List<City> getCities();
	public City getCity(Long cituId);
	public City deleteCity(Long cituId);
	public City editCity(Long cituId,CityRequestDto cityRequestDto);
}
