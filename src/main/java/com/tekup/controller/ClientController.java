package com.tekup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@PostMapping("/saveOrUpdate")
	public ResponseEntity<ClientDto> ADD(@Valid @RequestBody ClientDto clientDto) {
		ClientDto clientDtosaved = serviceInterface.save(clientDto);
		return new ResponseEntity<ClientDto>(clientDtosaved, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable Long id) {
		serviceInterface.deleteById(id);
	}

	@GetMapping("/findAll")
	public List<ClientDto> findAll() {
		return serviceInterface.findAll();
	}

	@GetMapping("/findById/{id}")
	public ClientDto findById(@PathVariable Long id) {
		return serviceInterface.findById(id);
	}

}
