package com.tekup.service.interfaces;

import com.tekup.dto.LabelValueDto;
import com.tekup.dto.PlatDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PlatServiceInterface extends GenericInterface<PlatDto>{
    public ResponseEntity<List<LabelValueDto>> findAllDto();

    public ResponseEntity<PlatDto> uploadImagePlat(Long platId, MultipartFile image);
}
