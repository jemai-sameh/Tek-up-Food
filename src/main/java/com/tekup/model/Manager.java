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
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager extends AbstractEntity{


	
	
	private String firstName;
	private String lastName;
	private String mail;

	private String phoneNumber;
	private String passwd;

	@OneToMany(mappedBy = "manager" ,fetch = FetchType.LAZY)
	private Set<Commande> commandes;
	
	@OneToMany(mappedBy = "manager" ,fetch = FetchType.LAZY)
	private Set<Plat> plats;
}
