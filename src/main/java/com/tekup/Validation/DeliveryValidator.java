package com.tekup.Validation;

import com.tekup.dto.AddressDto;
import com.tekup.dto.DeliveryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DeliveryValidator {
    public static List<String> validate(DeliveryDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the delivery date of the Delivery");
            errors.add("Please select the delivery man");
            errors.add("Please select the order");
            return errors;
        }


        if (dto.getDeliveryDate()==null){
            errors.add("please fill in the delivery date of the Delivery");
        }

        if (dto.getDeliveryMan() == null || dto.getDeliveryMan().getId()==null) {
            errors.add("Please select the delivery man");
        }
        if (dto.getCommande() == null || dto.getCommande().getId()==null) {
            errors.add("Please select the order");
        }
        return errors;
    }


}
