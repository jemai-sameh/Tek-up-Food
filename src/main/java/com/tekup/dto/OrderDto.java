package com.tekup.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.tekup.enumeration.PaymentMethod;
import com.tekup.model.Commande;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDto {
	private Long id;

	private String reference;
	private BigDecimal totalPrice;
	private PaymentMethod paymentMethod;

	private Instant orderDate;

	private AddressDto address;

	private PayementDto payement;

	private ClientDto client;

	private ManagerDto manager;

	//private Set<Long> platIds;



	public static OrderDto fromEntity(Commande order) {
		if (order == null) {
			return null;
		}

		return OrderDto.builder()
				.id(order.getId())
				.totalPrice(order.getTotalPrice())
				.reference(order.getReference())
				.paymentMethod(order.getPaymentMethod())
				.orderDate(order.getOrderDate())
				.client(ClientDto.fromEntity(order.getClient()))
				.manager(ManagerDto.fromEntity(order.getManager()))
				.address(AddressDto.fromEntity(order.getAddress()))
				.payement(PayementDto.fromEntity(order.getPayement())).build();
	}

	public static Commande toEntity(OrderDto orderDto) {
		if (orderDto == null) {
			return null;
		}

		Commande order = new Commande();
		order.setId(orderDto.getId());
		order.setTotalPrice(orderDto.getTotalPrice());
		order.setReference(orderDto.getReference());
		order.setPaymentMethod(orderDto.getPaymentMethod());
		order.setOrderDate(orderDto.getOrderDate());
		order.setClient(ClientDto.toEntity(orderDto.getClient()));
		order.setManager(ManagerDto.toEntity(orderDto.getManager()));
		order.setPayement(PayementDto.toEntity(orderDto.getPayement()));
		order.setAddress(AddressDto.toEntity(orderDto.getAddress()));
		return order;
	}
	public static List<OrderDto> fromListEntity(List<Commande> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
