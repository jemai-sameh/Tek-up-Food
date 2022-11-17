package com.tekup.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeliveryMan {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long deliveryManID;
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String passwd;
	private String latitude;
	private String longitude;
	private String availablity;
	
	
	@OneToMany(mappedBy = "deliveryMan",fetch = FetchType.LAZY)
	private List<Delivery> delivery;

}
