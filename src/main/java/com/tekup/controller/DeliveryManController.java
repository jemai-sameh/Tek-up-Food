package com.tekup.controller;

import com.tekup.dto.DeliveryManDto;
import com.tekup.service.interfaces.DeliveryManServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryManDto> ADD(@Valid @RequestBody DeliveryManDto dto) {
        return serviceInterface.save(dto);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return serviceInterface.deleteById(id);
    }

    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeliveryManDto>> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeliveryManDto> findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
