package com.tekup.controller;

import com.tekup.dto.PayementDto;
import com.tekup.service.interfaces.PayementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    PayementServiceInterface serviceInterface;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<PayementDto> ADD(@Valid @RequestBody PayementDto dto) {
        PayementDto dtosaved = serviceInterface.save(dto);
        return new ResponseEntity<PayementDto>(dtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<PayementDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public PayementDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
