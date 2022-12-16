package com.tekup.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity
@DiscriminatorValue("clien")
public class Client extends AppUser{

	
	
	@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	private Set<Commande> orders;
	
	
	/*@OneToMany(mappedBy = "client" ,fetch = FetchType.LAZY)
	private Set<Payement> payements;*/
	
}
