package com.tekup.controller;

import com.tekup.dto.DeliveryDto;
import com.tekup.service.interfaces.DeliveryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/delivery")
@CrossOrigin(origins = "http://localhost:4200")
public class DeliveryController {

    @Autowired
    DeliveryServiceInterface serviceInterface;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<DeliveryDto> ADD(@Valid @RequestBody DeliveryDto deliveryDto) {
        DeliveryDto deliveryDtosaved = serviceInterface.save(deliveryDto);
        return new ResponseEntity<DeliveryDto>(deliveryDtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<DeliveryDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public DeliveryDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }


}
