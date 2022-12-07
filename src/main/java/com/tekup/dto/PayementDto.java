package com.tekup.dto;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.tekup.enumeration.CarteType;
import com.tekup.model.Payement;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PayementDto {

	private Long id;
	private Instant paymentDate;
	private String carteNumber;
	private CarteType carteType;

	private OrderDto order;
/*
	private ClientDto client;
	*/
	  public static PayementDto fromEntity(Payement payement) {
		    if (payement == null) {
		      return null;
		    }

		    return PayementDto.builder()
		    		.id(payement.getId())
		    		.carteNumber(payement.getCarteNumber())
		    		.carteType(payement.getCarteType())
		    		.paymentDate(payement.getPaymentDate())
		    		.order(OrderDto.fromEntity(payement.getOrder()))
		    	//	.client(ClientDto.fromEntity(payement.getClient()))
		  
		        .build();
		  }
	  public static Payement toEntity(PayementDto payementDto) {
		    if (payementDto == null) {
		      return null;
		    }
	  
		    Payement payement = new Payement();
		    payement.setId(payementDto.getId());
		    payement.setCarteNumber(payementDto.getCarteNumber());
		    payement.setCarteType(payementDto.getCarteType());
		    payement.setPaymentDate(payementDto.getPaymentDate());
		    payement.setOrder(OrderDto.toEntity(payementDto.getOrder()));
		 //   payement.setClient(ClientDto.toEntity(payementDto.getClient())) ;
	    return payement;
	  }
	public static List<PayementDto> fromListEntity(List<Payement> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}
}
