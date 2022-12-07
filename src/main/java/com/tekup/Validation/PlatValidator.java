package com.tekup.Validation;

import com.tekup.dto.AddressDto;
import com.tekup.dto.PlatDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PlatValidator {
    public static List<String> validate(PlatDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the platName of the Plat");
            errors.add("please fill in the platPrix of the Plat");
            errors.add("please fill in the platType of the Plat");
            errors.add("please fill in the description of the Plat");
            errors.add("please fill in the image of the Plat");
            errors.add("Please select the manager");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getPlatName())) {
            errors.add("please fill in the platName of the Plat");
        }

        if (dto.getPlatPrix()==null) {
            errors.add("please fill in the platPrix of the Plat");
        }

        if (!StringUtils.hasLength(dto.getPlatType())) {
            errors.add("please fill in the platType of the Plat");
        }

        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("please fill in the description of the Plat");
        }
        if (!StringUtils.hasLength(dto.getImage())) {
            errors.add("please fill in the image of the Plat");
        }

        if (dto.getManager() == null || dto.getManager().getId()==null) {
            errors.add("Please select the manager");
        }
        return errors;
    }


}
