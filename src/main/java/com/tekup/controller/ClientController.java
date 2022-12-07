package com.tekup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.dto.ClientDto;
import com.tekup.service.interfaces.ClientServiceInterface;


@RestController
@RequestMapping("api/food/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
	
	@Autowired
	ClientServiceInterface serviceInterface;

	@PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> ADD(@Valid @RequestBody ClientDto clientDto) {
		return serviceInterface.save(clientDto);
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {

		return serviceInterface.deleteById(id);
	}

	@GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClientDto>> findAll() {
		return serviceInterface.findAll();
	}

	@GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
		return serviceInterface.findById(id);
	}

}
