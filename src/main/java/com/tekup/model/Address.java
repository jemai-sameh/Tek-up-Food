package com.tekup.model;

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
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity
public class Address extends AbstractEntity{


	private String street;
	private String town;
	private String postalCode;

	@OneToMany(mappedBy = "address" ,fetch = FetchType.LAZY)
	private Set<Commande> Commandes;
}
