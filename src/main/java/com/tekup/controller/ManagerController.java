package com.tekup.controller;

import com.tekup.dto.ManagerDto;
import com.tekup.service.interfaces.ManagerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {

    @Autowired
    ManagerServiceInterface serviceInterface;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<ManagerDto> ADD(@Valid @RequestBody ManagerDto dto) {

        ManagerDto dtosaved = serviceInterface.save(dto);

        return new ResponseEntity<ManagerDto>(dtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<ManagerDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public ManagerDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
