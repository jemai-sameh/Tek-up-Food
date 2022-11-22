package com.tekup.controller;

import com.tekup.dto.PlatDto;
import com.tekup.service.interfaces.PlatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/plat")
@CrossOrigin(origins = "http://localhost:4200")
public class PlatController {

    @Autowired
    PlatServiceInterface serviceInterface;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<PlatDto> ADD(@Valid @RequestBody PlatDto dto) {
        PlatDto dtosaved = serviceInterface.save(dto);
        return new ResponseEntity<PlatDto>(dtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<PlatDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public PlatDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
