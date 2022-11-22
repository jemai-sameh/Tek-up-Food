package com.tekup.service.interfaces.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plat  {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long platID;
	private String platName;
	private BigDecimal platPrix;
	private String platType;
	private String description;
	private String image;
	
	@ManyToMany (fetch = FetchType.EAGER)
	private Set<Commande> orders;

	
	@ManyToOne
	private Manager manager;
}

