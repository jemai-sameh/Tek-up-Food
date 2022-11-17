package com.tekup.model;

import java.util.List;

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
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientID;
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String passwd;
	private String mail;
	
	
	@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	private List<Commande> orders;
	
	
	@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	private List<Payement> payements;
	
}
