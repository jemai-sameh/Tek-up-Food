package com.tekup.dto;

import com.tekup.model.DeliveryMan;

import java.util.List;

public class DeliveryManDto {


    public static List<DeliveryManDto> fromListEntity(List<DeliveryMan> list) {
        return null;//list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());

    }
}
