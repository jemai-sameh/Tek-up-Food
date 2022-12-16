package com.tekup.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("manag")
public class Manager extends AppUser{

	@OneToMany(mappedBy = "manager" ,fetch = FetchType.LAZY)
	private Set<Commande> commandes;
	
	@OneToMany(mappedBy = "manager" ,fetch = FetchType.LAZY)
	private Set<Plat> plats;
}
