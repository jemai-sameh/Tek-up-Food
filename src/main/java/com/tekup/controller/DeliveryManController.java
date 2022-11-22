package com.tekup.controller;

import com.tekup.dto.DeliveryManDto;
import com.tekup.service.interfaces.DeliveryManServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/deliveryMan")
@CrossOrigin(origins = "http://localhost:4200")
public class DeliveryManController {

    @Autowired
    DeliveryManServiceInterface serviceInterface;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<DeliveryManDto> ADD(@Valid @RequestBody DeliveryManDto dto) {
        DeliveryManDto dtosaved = serviceInterface.save(dto);
        return new ResponseEntity<DeliveryManDto>(dtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<DeliveryManDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public DeliveryManDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
