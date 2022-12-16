package com.tekup.controller;

import com.tekup.dto.OrderDetailsDto;
import com.tekup.dto.OrderDto;
import com.tekup.dto.PlatDto;
import com.tekup.service.interfaces.OrderServiceInterface;
import com.tekup.service.interfaces.PlatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderServiceInterface serviceInterface;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> ADD(@Valid @RequestBody OrderDetailsDto dto) {
        System.out.println(dto.getPaymentMethod().toString());
        return serviceInterface.saveOrder(dto);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return serviceInterface.deleteById(id);
    }

    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
