package com.tekup.service.interfaces.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tekup.enumeration.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commande{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long OrderID;

	
	private String reference;
	private BigDecimal totalPrice;
	private PaymentMethod paymentMethod;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss",
			 timezone = "Africa/Tunis")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@ManyToOne
	private Address address;
	
	@OneToOne
	private Payement payement;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Manager manager;
	
	@ManyToMany(mappedBy = "orders" ,fetch = FetchType.EAGER)
	private Set<Plat> plats;
	
	
	@OneToMany(mappedBy = "commande",fetch = FetchType.LAZY)
	private Set<Delivery> delivery;
	
}
