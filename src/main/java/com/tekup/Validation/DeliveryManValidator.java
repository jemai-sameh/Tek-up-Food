package com.tekup.Validation;

import com.tekup.dto.AddressDto;
import com.tekup.dto.DeliveryManDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DeliveryManValidator {
    public static List<String> validate(DeliveryManDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the firstName of the DeliveryMan");
            errors.add("please fill in the lastName of the DeliveryMan");
            errors.add("please fill in the phoneNumber of the DeliveryMan");
            errors.add("please fill in the passwd of the DeliveryMan");
            errors.add("please fill in the latitude of the DeliveryMan");
            errors.add("please fill in the longitude of the DeliveryMan");
            errors.add("please fill in the availablity of the DeliveryMan");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getFirstName())) {
            errors.add("please fill in the firstName of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getLastName())) {
            errors.add("please fill in the lastName of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getPhoneNumber())) {
            errors.add("please fill in the phoneNumber of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getPasswd())) {
            errors.add("please fill in the passwd of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getLongitude())) {
            errors.add("please fill in the latitude of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getAvailablity())) {
            errors.add("please fill in the longitude of the DeliveryMan");
        }
        if (!StringUtils.hasLength(dto.getLatitude())) {
            errors.add("please fill in the availablity of the DeliveryMan");
        }
        return errors;
    }


}
