package com.tekup.Validation;

import com.tekup.dto.ManagerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ManagerValidator {
    public static List<String> validate(ManagerDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the fullName of the DeliveryMan");
            errors.add("please fill in the phoneNumber of the DeliveryMan");
            errors.add("please fill in the passwd of the DeliveryMan");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getFullName())) {
            errors.add("please fill in the fullName of the DeliveryMan");
        }

        if (!StringUtils.hasLength(dto.getPhoneNumber())) {
            errors.add("please fill in the phoneNumber of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getPassword())) {
            errors.add("please fill in the passwd of the DeliveryMan");
        }
        return errors;
    }


}
