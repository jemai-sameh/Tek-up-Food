package com.tekup.Validation;

import com.tekup.dto.AddressDto;
import com.tekup.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the fullName of the client");
            errors.add("please fill in the phoneNumber of the client");
            errors.add("please fill in the passwd of the client");
            errors.add("please fill in the mail of the client");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getFullName())) {
            errors.add("please fill in the fullName of the client");
        }

        if (!StringUtils.hasLength(dto.getPhoneNumber())) {
            errors.add("please fill in the phoneNumber of the client");
        }
        if (!StringUtils.hasLength(dto.getPassword())) {
            errors.add("please fill in the passwd of the client");
        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("please fill in the mail of the client");
        }
        return errors;
    }


}
