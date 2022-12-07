package com.tekup.Validation;

import com.tekup.dto.AddressDto;
import com.tekup.dto.PayementDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PayementValidator {
    public static List<String> validate(PayementDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the paymentDate of the Payement");
            errors.add("please fill in the carteNumber of the Payement");
            errors.add("please fill in the carteType of the Payement");
            errors.add("Please select the order");
            return errors;
        }


        if (dto.getPaymentDate()==null) {
            errors.add("please fill in the paymentDate of the Payement");
        }
        if (!StringUtils.hasLength(dto.getCarteNumber())) {
            errors.add("please fill in the carteNumber of the Payement");
        }
        if (!StringUtils.hasLength(dto.getCarteNumber())) {
            errors.add("please fill in the carteType of the Payement");
        }

        if (dto.getOrder() == null || dto.getOrder().getId()==null) {
            errors.add("Please select the order");
        }
        return errors;
    }


}
