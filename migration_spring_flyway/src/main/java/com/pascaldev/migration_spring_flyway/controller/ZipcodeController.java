package com.pascaldev.migration_spring_flyway.controller;

import java.util.List;import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pascaldev.migration_spring_flyway.dto.request.ZipcodeResquestDto;
import com.pascaldev.migration_spring_flyway.models.ZipCode;
import com.pascaldev.migration_spring_flyway.service.ZipcodeService;

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {
	private final ZipcodeService zipcodeService;

	@Autowired
	public ZipcodeController(ZipcodeService zipcodeService) {
		
		this.zipcodeService = zipcodeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<ZipCode> addZipcode(@RequestBody final ZipcodeResquestDto zipcodeResquestDto){
		ZipCode zipCode = zipcodeService.addZipcode(zipcodeResquestDto);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ZipCode> getZipcode(@PathVariable final Long id){
		ZipCode zipCode = zipcodeService.getZipcode(id);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ZipCode>> getZipcodes(){
		List<ZipCode> zipCodes = zipcodeService.getZipcodes();
		return new ResponseEntity<>(zipCodes, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ZipCode> deleteZipcode (@PathVariable final Long id){
		ZipCode zipCode = zipcodeService.deleteZipCode(id);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	  
	@PostMapping("/edit/{id}")
	public ResponseEntity<ZipCode> editZipcode(@RequestBody final ZipcodeResquestDto zipcodeResquestDto,
			@PathVariable Long id){
		ZipCode zipCode = zipcodeService.editZipCode(id, zipcodeResquestDto);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
	@PostMapping("/addCity/{sityId}/toZipcode/{zipcodeId}")
	public ResponseEntity<ZipCode> addCity(@PathVariable final Long cityId,
			@PathVariable final Long zipcodeId){
		ZipCode zipCode = zipcodeService.addToZipCode(zipcodeId, cityId);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
	@PostMapping("/deleteCity/{zipcodeId}")
	public ResponseEntity<ZipCode> deleteCity(@PathVariable final Long zipcodeId){
		ZipCode zipCode = zipcodeService.removeCityFromZipCode(zipcodeId);
		return new ResponseEntity<>(zipCode, HttpStatus.OK);
	}
	
	
	
	

}
