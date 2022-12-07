package com.tekup.Validation;

import com.tekup.dto.OrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderValidator {
    public static List<String> validate(OrderDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("please fill in the reference of the Order");
            errors.add("please fill in the totalPrice of the Order");
            errors.add("please fill in the paymentMethod of the Order");
            errors.add("please fill in the orderDate of the Order");
            errors.add("Please select the address");
            errors.add("Please select the payement");
            errors.add("Please select the client");
            errors.add("Please select the manager");
            return errors;
        }


        if (!StringUtils.hasLength(dto.getReference())) {
            errors.add("please fill in the reference of the Order");
        }
        if (dto.getTotalPrice()==null) {
            errors.add("please fill in the totalPrice of the Order");
        }
/*        if (dto.getPaymentMethod()==null) {
            errors.add("please fill in the paymentMethod of the Order");
        }
  */      if (dto.getOrderDate()==null) {
            errors.add("please fill in the orderDate of the Order");
        }
        if (dto.getAddress() == null || dto.getAddress().getId()==null) {
            errors.add("Please select the address");
        }
        /*if (dto.getPayement() == null || dto.getPayement().getId()==null) {
            errors.add("Please select the payement");
        }*/
        if (dto.getClient() == null || dto.getClient().getId()==null) {
            errors.add("Please select the client");
        }
        if (dto.getManager() == null || dto.getManager().getId()==null) {
            errors.add("Please select the manager");
        }
        return errors;
    }
}
