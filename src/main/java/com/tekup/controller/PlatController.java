package com.tekup.controller;

import com.tekup.dto.LabelValueDto;
import com.tekup.dto.PlatDto;
import com.tekup.service.interfaces.ImageStorage;
import com.tekup.service.interfaces.PlatServiceInterface;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/food/plat")
@CrossOrigin(origins = "http://localhost:4200")
public class PlatController {

    @Autowired
    PlatServiceInterface serviceInterface;

    @Autowired
    ImageStorage imageStorage;


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlatDto> ADD(@Valid @RequestBody PlatDto dto) {
        return serviceInterface.save(dto);
    }

    @PostMapping(value = "/uploadPlatImage/{id}")
    public ResponseEntity<PlatDto> uploadPlatImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) {
        return this.serviceInterface.uploadImagePlat(id,image);
    }
    @GetMapping("/downloadPlatImage/{imageName}")
    public ResponseEntity<Resource> downloadPlatImage(@PathVariable String imageName, HttpServletRequest request) {
        return this.imageStorage.downloadPlatImage(imageName,request);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return serviceInterface.deleteById(id);
    }

    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlatDto>> findAll() {
        return serviceInterface.findAll();
    }


    @GetMapping(value = "/findAllDto",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LabelValueDto>> findAllDto() {
        return serviceInterface.findAllDto();
    }

    @GetMapping(value = "/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlatDto> findById(@PathVariable Long id) {
        return serviceInterface.findById(id);
    }

}
