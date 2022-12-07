package com.tekup.model;

import java.time.Instant;
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
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery extends AbstractEntity{


	private Instant deliveryDate;


	@ManyToOne
	@JoinColumn(name = "deliveryManID")
	private DeliveryMan deliveryMan;
	
	@ManyToOne
	@JoinColumn(name = "orderID")
	private Commande commande;
}
