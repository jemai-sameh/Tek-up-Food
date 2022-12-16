package com.tekup.dto;


import com.tekup.model.DeliveryMan;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
@Data
@Builder
public class DeliveryManDto {


    private Long id;
    private String fullName;

    private String phoneNumber;
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",message="it should be an email ")
    private String email;
    private String password;
    private String latitude;
    private String longitude;
    private boolean availablity;

    public static DeliveryManDto fromEntity(DeliveryMan deliveryMan) {
        if (deliveryMan == null) {
            return null;
        }
        return DeliveryManDto.builder()
                .id(deliveryMan.getId())
                .fullName(deliveryMan.getFullName())
                .phoneNumber(deliveryMan.getPhoneNumber())
                .email(deliveryMan.getEmail())
                .password(deliveryMan.getPassword())
                .latitude(deliveryMan.getLatitude())
                .longitude(deliveryMan.getLongitude())
                .availablity(deliveryMan.isAvailablity())
                .build();

    }

    public static DeliveryMan toEntity(DeliveryManDto deliveryManDto) {
        if (deliveryManDto == null) {
            return null;
        }
        DeliveryMan deliveryMan = new DeliveryMan();
        deliveryMan.setId(deliveryManDto.getId());
        deliveryMan.setFullName(deliveryManDto.getFullName());
        deliveryMan.setPhoneNumber(deliveryManDto.getPhoneNumber());
        deliveryMan.setEmail(deliveryManDto.getEmail());
        deliveryMan.setPassword(deliveryManDto.getPassword());

        deliveryMan.setLatitude(deliveryManDto.getLatitude());
        deliveryMan.setLongitude(deliveryManDto.getLongitude());
        deliveryMan.setAvailablity(deliveryManDto.isAvailablity());
        return deliveryMan;
    }

    public static List<DeliveryManDto> fromListEntity(List<DeliveryMan> list) {
        return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
    }


}

