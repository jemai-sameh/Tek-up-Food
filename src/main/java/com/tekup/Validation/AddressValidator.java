package com.tekup.Validation;

import com.tekup.dto.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {
    public static List<String> validate(AddressDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the street of the address");
            errors.add("please fill in the town of the address");
            errors.add("please fill in the postalCode of the address");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getStreet())) {
            errors.add("please fill in the street of the address");
        }
        if (!StringUtils.hasLength(dto.getTown())) {
            errors.add("please fill in the town of the address");
        }
        if (!StringUtils.hasLength(dto.getPostalCode())) {
            errors.add("please fill in the postalCode of the address");
        }

        return errors;
    }


}
