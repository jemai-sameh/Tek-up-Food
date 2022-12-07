package com.tekup.model;

import java.time.Instant;

import javax.persistence.*;

import com.tekup.enumeration.CarteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payement  extends AbstractEntity{

	
	private Instant paymentDate;
	private String carteNumber;

	@Enumerated(EnumType.STRING)
	private CarteType carteType;

	@OneToOne
	private Commande order;
	/*
	@ManyToOne
	private Client client;*/

}
