package com.tekup.service.interfaces.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long DeliveryID;
	 
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss",
			 timezone = "Africa/Tunis")
	@Temporal(TemporalType.TIMESTAMP)
	private Date DeliveryDate;


	@ManyToOne
	@JoinColumn(name = "deliveryManID")
	private DeliveryMan deliveryMan;
	
	@ManyToOne
	@JoinColumn(name = "orderID")
	private Commande commande;


}
