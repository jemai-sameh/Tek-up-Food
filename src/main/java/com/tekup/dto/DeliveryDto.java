package com.tekup.dto;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.tekup.model.Delivery;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryDto {

	    private Long id;

	    private Instant DeliveryDate;

	    private OrderDto commande;

	    private DeliveryManDto deliveryMan;

	    public static DeliveryDto fromEntity(Delivery delivery) {
	        if (delivery == null) {
	            return null;
	        }
	        return DeliveryDto.builder()
	                .id(delivery.getId())
	                .DeliveryDate(delivery.getDeliveryDate())
	                .commande(OrderDto.fromEntity(delivery.getCommande()))
	                .deliveryMan(DeliveryManDto.fromEntity(delivery.getDeliveryMan()))
	                .build();

	    }

	    public static Delivery toEntity(DeliveryDto deliveryDto) {
	        if (deliveryDto == null) {
	            return null;
	        }
	        Delivery delivery = new Delivery();
	        delivery.setId(deliveryDto.getId());
	        delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
	        delivery.setCommande(OrderDto.toEntity(deliveryDto.getCommande()));
	        delivery.setDeliveryMan(DeliveryManDto.toEntity(deliveryDto.getDeliveryMan()));

	        return delivery;
	    }

	public static List<DeliveryDto> fromListEntity(List<Delivery> deliveries) {
		return deliveries.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
