package com.pascaldev.migration_spring_flyway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pascaldev.migration_spring_flyway.dto.request.ZipcodeResquestDto;
import com.pascaldev.migration_spring_flyway.models.ZipCode;

@Service
public interface ZipcodeService {
	public ZipCode addZipcode(ZipcodeResquestDto zipcodeResquestDto);
	public List<ZipCode> getZipcodes();
	public ZipCode getZipcode(Long zipcodeId);
	public ZipCode deleteZipCode(Long zipcodeId);
	public ZipCode editZipCode(Long zipcodeId,ZipcodeResquestDto zipcodeResquestDto);
	public ZipCode addToZipCode(Long zipcodeId, Long cityId); 
    public ZipCode removeCityFromZipCode(Long zicodeId);
}
