package com.tekup.service.interfaces.model;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long managerID;
	
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String passwd;

	@OneToMany(mappedBy = "manager" ,fetch = FetchType.LAZY)
	private Set<Commande> commandes;
	
	@OneToMany(mappedBy = "manager" ,fetch = FetchType.LAZY)
	private Set<Plat> plats;
}
