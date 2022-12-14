package com.tekup.dto;

import com.tekup.enumeration.PaymentMethod;
import com.tekup.model.Commande;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class OrderDetailsDto {
    private Long id;

    private String reference;
    private double totalPrice;
    private PaymentMethod paymentMethod;

    private Instant orderDate;

    private AddressDto address;

    //private PayementDto payement;

    private ClientDto client;

    private ManagerDto manager;

    private Set<Long> platIds;

    public static Commande toEntity(OrderDetailsDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Commande order = new Commande();
        order.setId(orderDto.getId());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setReference(orderDto.getReference());
        order.setOrderDate(orderDto.getOrderDate());
        order.setClient(ClientDto.toEntity(orderDto.getClient()));
        order.setManager(ManagerDto.toEntity(orderDto.getManager()));
        order.setAddress(AddressDto.toEntity(orderDto.getAddress()));
        return order;
    }

}
