package com.tekup.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tekup.enumeration.PaymentMethod;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Commande extends AbstractEntity{

	private String reference;
	private double totalPrice;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	

	private Instant orderDate;

	@ManyToOne
	private Address address;
	
	@OneToOne
	@JsonIgnore
	private Payement payement;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Manager manager;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Plat> plats;
	
	
	@OneToMany(mappedBy = "commande",fetch = FetchType.LAZY)
	private Set<Delivery> deliverySet;

	public void addPlat(Plat entity ) {
		if (this.plats==null ) {
			this.plats = new HashSet<Plat>();
		}
		this.plats.add(entity);
		if ( entity.getOrders()==null ) {
			entity.setOrders(new HashSet<Commande>());
		}
		entity.getOrders().add(this);
	}



}
