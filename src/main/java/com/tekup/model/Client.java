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
public class Client extends AbstractEntity{
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String passwd;
	private String mail;
	
	
	@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	private Set<Commande> orders;
	
	
	/*@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	private Set<Payement> payements;*/
	
}
