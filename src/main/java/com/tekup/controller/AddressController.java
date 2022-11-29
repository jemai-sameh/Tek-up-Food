package com.tekup.controller;
import com.tekup.dto.AddressDto;
import com.tekup.service.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/address")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    @Autowired
    AddressServiceInterface serviceInterface;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<AddressDto> ADD(@Valid @RequestBody AddressDto dto) {
        AddressDto dtosaved = serviceInterface.save(dto);
        return new ResponseEntity<AddressDto>(dtosaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        serviceInterface.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<AddressDto> findAll() {
        return serviceInterface.findAll();
    }

    @GetMapping("/findById/{id}")
    public AddressDto findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}