package com.tekup.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.tekup.enumeration.PaymentMethod;
import com.tekup.service.interfaces.model.Commande;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
	private Long OrderID;

	private String reference;
	private BigDecimal totalPrice;
	private PaymentMethod paymentMethod;

	private Date orderDate;

	private AddressDto address;

	private PayementDto payement;

	private ClientDto client;

	private ManagerDto manager;

	public static OrderDto fromEntity(Commande order) {
		if (order == null) {
			return null;
		}

		return OrderDto.builder().OrderID(order.getOrderID()).address(AddressDto.fromEntity(order.getAddress()))
				.totalPrice(order.getTotalPrice()).reference(order.getReference())
				.paymentMethod(order.getPaymentMethod()).orderDate(order.getOrderDate())
				.client(ClientDto.fromEntity(order.getClient())).manager(ManagerDto.fromEntity(order.getManager()))
				.payement(PayementDto.fromEntity(order.getPayement())).build();
	}

	public static Commande toEntity(OrderDto orderDto) {
		if (orderDto == null) {
			return null;
		}

		Commande order = new Commande();
		order.setOrderID(orderDto.getOrderID());
		order.setAddress(AddressDto.toEntity(orderDto.getAddress()));
		order.setTotalPrice(orderDto.getTotalPrice());
		order.setReference(orderDto.getReference());
		order.setPaymentMethod(orderDto.getPaymentMethod());
		order.setOrderDate(orderDto.getOrderDate());
		order.setClient(ClientDto.toEntity(orderDto.getClient()));
		order.setManager(ManagerDto.toEntity(orderDto.getManager()));
		order.setPayement(PayementDto.toEntity(orderDto.getPayement()));
		return order;
	}
	public static List<OrderDto> fromListEntity(List<Commande> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
