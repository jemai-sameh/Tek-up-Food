package com.tekup.dto;


import com.tekup.model.DeliveryMan;
import lombok.Builder;
import lombok.Data;


import java.util.List;
import java.util.stream.Collectors;
@Data
@Builder
public class DeliveryManDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passwd;
    private String latitude;
    private String longitude;
    private boolean availablity;

    public static DeliveryManDto fromEntity(DeliveryMan deliveryMan) {
        if (deliveryMan == null) {
            return null;
        }
        return DeliveryManDto.builder()
                .id(deliveryMan.getId())
                .firstName(deliveryMan.getFirstName())
                .lastName(deliveryMan.getLastName())
                .phoneNumber(deliveryMan.getPhoneNumber())
                .passwd(deliveryMan.getPasswd())
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
        deliveryMan.setFirstName(deliveryManDto.getFirstName());
        deliveryMan.setLastName(deliveryManDto.getLastName());
        deliveryMan.setPhoneNumber(deliveryManDto.getPhoneNumber());
        deliveryMan.setPasswd(deliveryManDto.getPasswd());
        deliveryMan.setLatitude(deliveryManDto.getLatitude());
        deliveryMan.setLongitude(deliveryManDto.getLongitude());
        deliveryMan.setAvailablity(deliveryManDto.isAvailablity());
        return deliveryMan;
    }

    public static List<DeliveryManDto> fromListEntity(List<DeliveryMan> list) {
        return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
    }


}
