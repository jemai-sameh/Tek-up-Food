package com.tekup.controller;

import com.tekup.dto.DeliveryDto;
import com.tekup.service.interfaces.DeliveryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryDto> ADD(@Valid @RequestBody DeliveryDto deliveryDto) {
        return serviceInterface.save(deliveryDto);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return serviceInterface.deleteById(id);
    }

    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeliveryDto>> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryDto> findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }


}
