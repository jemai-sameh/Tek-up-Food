package com.tekup.controller;

import com.tekup.dto.OrderDetailsDto;
import com.tekup.dto.OrderDto;
import com.tekup.dto.PlatDto;
import com.tekup.service.interfaces.OrderServiceInterface;
import com.tekup.service.interfaces.PlatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<OrderDto> ADD(@Valid @RequestBody OrderDetailsDto dto) {
        OrderDto dtosaved = serviceInterface.saveOlder(dto);
        return new ResponseEntity<OrderDto>(dtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<OrderDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
