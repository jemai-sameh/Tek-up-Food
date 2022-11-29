package com.tekup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.tekup.enumeration.CarteType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payement  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentID;

	
	private Date paymentDate;
	private String carteNumber;
	private CarteType carteType;

	@OneToOne
	private Commande order;
	/*
	@ManyToOne
	private Client client;*/

}
