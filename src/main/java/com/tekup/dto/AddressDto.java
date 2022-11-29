package com.tekup.dto;

import com.tekup.model.Address;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class AddressDto {

	private Long addressID;
	private String street;
	private String town;
	private String postalCode;

	public static AddressDto fromEntity(Address address ) {
		if (address == null) {
			return null;
		}

		return AddressDto.builder()
				.addressID(address.getAddressID())
				.postalCode(address.getPostalCode())
				.street(address.getStreet())
				.town(address.getTown())
				.build();
	}

	public static Address toEntity(AddressDto addressDto) {
		if (addressDto == null) {
			return null;
		}

		Address address = new Address();
		address.setAddressID(addressDto.getAddressID());
		address.setPostalCode(addressDto.getPostalCode());
		address.setStreet(addressDto.getStreet());
		address.setTown(addressDto.getTown());

		return address;
	}
	public static List<AddressDto> fromListEntity(List<Address> list) {
		return list.stream().map(x -> fromEntity(x)).collect(Collectors.toList());
	}

}