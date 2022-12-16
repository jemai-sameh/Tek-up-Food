package com.tekup.model;

import java.util.Set;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("deMan")
public class DeliveryMan extends AppUser{

	private String latitude;
	private String longitude;
	private boolean availablity;
	
	
	@OneToMany(mappedBy = "deliveryMan",fetch = FetchType.LAZY)
	private Set<Delivery> delivery;

}
